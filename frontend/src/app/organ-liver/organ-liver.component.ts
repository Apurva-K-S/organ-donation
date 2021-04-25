import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { OrganLiverService, LiverData, LiverData2 } from '../services/organ-liver.service';
import { Router } from '@angular/router';
import {ThankyouServiceService, HospitalData} from 'src/app/services/thankyou-service.service';

interface Role{
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-organ-liver',
  templateUrl: './organ-liver.component.html',
  styleUrls: ['./organ-liver.component.css']
})
export class OrganLiverComponent implements OnInit {

  form: FormGroup = new FormGroup({});
  liverData!: LiverData[];
  liverData2!: LiverData2[];
  showMe: boolean = false;

  bloodGroups: Role[]=[
    {value: 'None', viewValue: 'None'},
    {value: 'A+', viewValue: 'A+'},
    {value: 'A-', viewValue: 'A-'},
    {value: 'B+', viewValue: 'B+'},
    {value: 'B-', viewValue: 'B-'},
    {value: 'O+', viewValue: 'O+'},
    {value: 'O-', viewValue: 'O-'},
    {value: 'AB+', viewValue: 'AB+'},
    {value: 'AB-', viewValue: 'AB-'}
  
    ];
  
  hospitalData!: HospitalData[];
  hd:HospitalData = {
    hospitalName : "None"
  };

  constructor(private fb: FormBuilder, private thankyouServiceService:ThankyouServiceService, private route: ActivatedRoute, private organLiverService:OrganLiverService, private router: Router) 
  { 
    this.form = fb.group({
      bloodGroup: ['', [Validators.required]],
      hospitalName: ['', [Validators.required]],
    })
  }

  ngOnInit(): void {
    console.log("Inside ngOnInit");
    console.log("inside organ-liver ngoninit");
    
    this.organLiverService.getLiverData().subscribe(result=>{
      this.liverData = result;

      console.log("inside this.organLiverService.getLiverData().subscribe(result=>{ ");
      console.log("list is: ",this.liverData);

      if(this.liverData.length == 0)
      {
          alert("Currently no donor available for this organ!!");
          this.router.navigateByUrl("/");
      }
  })
  this.submit2();
  }

  submit2(){
    console.log("inside submit2 of organ-liver.component.ts");
    this.thankyouServiceService.getHospitalInfo().subscribe(result=>{
      this.hospitalData = result;
      this.hospitalData.push(this.hd);
      console.log("inside this.thankyouServiceService.getHospitalInfo().subscribe(result=>{ and the result is: ");
      console.log(this.hospitalData);
    })
  }

  submit():void{
    
    console.log("in submit()");
    console.log("this.form.value = ", this.form.value);
    this.showMe=true;
    this.organLiverService.getPatientData(this.form.value).subscribe(result=>{
      
      this.liverData2 = result;
      console.log("inside this.organHeartService.getPatientData(this.form.value).subscribe(result=>{ ");
      console.log("list is: ",this.liverData2);
      //console.log(this.heartData2[0]);
      //console.log(this.heartData2[0]["bloodGroup"]);
      console.log(this.liverData2.length);
      if(this.liverData2.length == 0)
      {
          alert("Currently no donor available for this organ!!");
          this.router.navigateByUrl("/organKidney");
      }
      
    })
  }
}