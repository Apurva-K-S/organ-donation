import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { OrganKidneyService, KidneyData, KidneyData2 } from '../services/organ-kidney.service';
import { Router } from '@angular/router';
import {ThankyouServiceService, HospitalData} from 'src/app/services/thankyou-service.service';

interface Role{
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-organ-kidney',
  templateUrl: './organ-kidney.component.html',
  styleUrls: ['./organ-kidney.component.css']
})
export class OrganKidneyComponent implements OnInit {

  form: FormGroup = new FormGroup({});
  kidneyData!: KidneyData[];
  kidneyData2!: KidneyData2[];
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

  constructor(private fb: FormBuilder, private thankyouServiceService:ThankyouServiceService, private route: ActivatedRoute, private organKidneyService:OrganKidneyService, private router: Router) 
  { 
    this.form = fb.group({
      bloodGroup: ['', [Validators.required]],
      hospitalName: ['', [Validators.required]],
    })
  }

  ngOnInit(): void {
    console.log("Inside ngOnInit");
    console.log("inside organ-kidney ngoninit");
    
    this.organKidneyService.getKidneyData().subscribe(result=>{
      this.kidneyData = result;

      console.log("inside this.organHeartService.getKidneyData().subscribe(result=>{ ");
      console.log("list is: ",this.kidneyData);
      if(this.kidneyData.length == 0)
      {
          alert("Currently no donor available for this organ!!");
          this.router.navigateByUrl("/");
      }
    })
    this.submit2();
  }

  submit2(){
    console.log("inside submit2 of organ-kidney.component.ts");
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
    this.organKidneyService.getPatientData(this.form.value).subscribe(result=>{
      
      this.kidneyData2 = result;
      console.log("inside this.organHeartService.getPatientData(this.form.value).subscribe(result=>{ ");
      console.log("list is: ",this.kidneyData2);
      //console.log(this.heartData2[0]);
      //console.log(this.heartData2[0]["bloodGroup"]);
      console.log(this.kidneyData2.length);
      if(this.kidneyData2.length == 0)
      {
          alert("Currently no donor available for this organ!!");
          this.router.navigateByUrl("/organKidney");
      }
      
    })

  }

}