import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { ConfirmedValidator } from 'src/app/confirmed.validator';
import {ThankyouServiceService, HospitalData} from 'src/app/services/thankyou-service.service';

interface Role{
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-thankyou',
  templateUrl: './thankyou.component.html',
  styleUrls: ['./thankyou.component.css']
})
export class ThankyouComponent implements OnInit {

  form: FormGroup = new FormGroup({});

  hospitalData!: HospitalData[];
  
  constructor(private fb: FormBuilder, private thankyouServiceService:ThankyouServiceService,private router: Router) {
    
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      hospitalName: new FormControl('', [Validators.required])
    })
    
    this.submit();
  }

  submit(){
    console.log("inside submit of thankyou.component.ts");
    this.thankyouServiceService.getHospitalInfo().subscribe(result=>{
      this.hospitalData = result;
      console.log("inside this.thankyouServiceService.getHospitalInfo().subscribe(result=>{ and the result is: ");
      console.log(this.hospitalData);
    })
  }
  submit2(){
    console.log("the form values are: ", this.form.value);
  }


}
