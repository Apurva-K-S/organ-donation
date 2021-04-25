import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormBuilder} from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { OrganHeartService, HeartData, HeartData2 } from '../services/organ-heart.service';
import { Router } from '@angular/router';
import {ThankyouServiceService, HospitalData} from 'src/app/services/thankyou-service.service';

interface Role{
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-organ-heart',
  templateUrl: './organ-heart.component.html',
  styleUrls: ['./organ-heart.component.css']
})
export class OrganHeartComponent implements OnInit {
  form: FormGroup = new FormGroup({});
  heartData!: HeartData[];
  heartData2!: HeartData2[];
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
    
    

  constructor(private fb: FormBuilder, private thankyouServiceService:ThankyouServiceService, private route: ActivatedRoute, private organHeartService:OrganHeartService, private router: Router) 
  { 
    this.form = fb.group({
      bloodGroup: ['', [Validators.required]],
      hospitalName: ['', [Validators.required]],
    })
    
  }

  ngOnInit(): void {
    console.log("Inside ngOnInit");
    console.log("inside organ-heart ngoninit");
    
    this.organHeartService.getHeartData().subscribe(result=>{
      this.heartData = result;
     
      console.log("inside this.organHeartService.getHeartData().subscribe(result=>{ ");
      console.log("list is: ",this.heartData);
      if(this.heartData.length == 0)
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
      this.hospitalData.push(this.hd);
      console.log("inside this.thankyouServiceService.getHospitalInfo().subscribe(result=>{ and the result is: ");
      console.log(this.hospitalData);
    })
  }

  submit():void{
    
    console.log("in submit()");
    console.log("this.form.value = ", this.form.value);
    this.showMe=true;
    this.organHeartService.getPatientData(this.form.value).subscribe(result=>{
      
      this.heartData2 = result;
      console.log("inside this.organHeartService.getPatientData(this.form.value).subscribe(result=>{ ");
      console.log("list is: ",this.heartData2);
      //console.log(this.heartData2[0]);
      //console.log(this.heartData2[0]["bloodGroup"]);
      console.log(this.heartData2.length);
      if(this.heartData2.length == 0)
      {
          alert("Currently no donor available for this organ!!");
          this.router.navigateByUrl("/organHeart");
      }
      
    })

  }

}
