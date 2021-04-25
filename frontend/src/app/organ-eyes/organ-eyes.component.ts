import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { OrganEyesService, EyesData, EyesData2 } from '../services/organ-eyes.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ThankyouServiceService, HospitalData} from 'src/app/services/thankyou-service.service';

interface Role{
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-organ-eyes',
  templateUrl: './organ-eyes.component.html',
  styleUrls: ['./organ-eyes.component.css']
})
export class OrganEyesComponent implements OnInit {

  form: FormGroup = new FormGroup({});
  eyesData!: EyesData[];
  eyesData2!: EyesData2[];
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

  constructor(private fb: FormBuilder, private thankyouServiceService:ThankyouServiceService, private route: ActivatedRoute, private organEyesService:OrganEyesService, private router: Router) 
  { 
    this.form = fb.group({
      bloodGroup: ['', [Validators.required]],
      hospitalName: ['', [Validators.required]],
    })
  }

  ngOnInit(): void {
    console.log("Inside ngOnInit");
    console.log("inside organ-eyes ngoninit");
    
    this.organEyesService.getEyesData().subscribe(result=>{
      this.eyesData = result;
      this.hospitalData.push(this.hd);
      console.log("inside this.organEyesService.getEyesData().subscribe(result=>{ ");
      console.log("list is: ",this.eyesData);
      if(this.eyesData.length == 0)
      {
          alert("Currently no donor available for this organ!!");
          this.router.navigateByUrl("/");
      }
    })

    this.submit2();

  }

  submit2(){
    console.log("inside submit2 of organ-eyes.component.ts");
    this.thankyouServiceService.getHospitalInfo().subscribe(result=>{
      this.hospitalData = result;
      console.log("inside this.thankyouServiceService.getHospitalInfo().subscribe(result=>{ and the result is: ");
      console.log(this.hospitalData);
    })
  }

  submit():void{
    
    console.log("in submit()");
    console.log("this.form.value = ", this.form.value);
    this.showMe=true;
    this.organEyesService.getPatientData(this.form.value).subscribe(result=>{
      
      this.eyesData2 = result;
      console.log("inside this.OrganEyesService.getPatientData(this.form.value).subscribe(result=>{ ");
      console.log("list is: ",this.eyesData2);
      //console.log(this.heartData2[0]);
      //console.log(this.heartData2[0]["bloodGroup"]);
      console.log(this.eyesData2.length);
      if(this.eyesData2.length == 0)
      {
          alert("Currently no donor available for this organ!!");
          this.router.navigateByUrl("/organEyes");
      }
      
    })

  }

}
