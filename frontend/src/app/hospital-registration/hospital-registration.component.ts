import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ConfirmedValidator } from 'src/app/confirmed.validator';
import {HospitalRegistrationService} from 'src/app/services/hospital-registration.service';

interface States{
  value: string;
  viewValue: string;
}



@Component({
  selector: 'app-hospital-registration',
  templateUrl: './hospital-registration.component.html',
  styleUrls: ['./hospital-registration.component.css']
})
export class HospitalRegistrationComponent implements OnInit {

  hospForm: FormGroup = new FormGroup({});

  states: States[]=[
    {value: 'Andhra Pradesh', viewValue: 'Andhra Pradesh'},
    {value: 'Telangana', viewValue: 'Telangana'},
    {value: 'Maharashtra', viewValue: 'Maharashtra'},
    {value: 'Tamilnadu', viewValue: 'Tamilnadu'},
    {value: 'Karnataka', viewValue: 'Karnataka'},
    {value: 'Kerala', viewValue: 'Kerala'},
    {value: 'Delhi', viewValue: 'Delhi'},
    {value: 'Orissa', viewValue: 'Orissa'},
    {value: 'Gujarat', viewValue: 'Gujarat'},
    {value: 'West Bengal', viewValue: 'West Bengal'},
  
    ];
  

  constructor(private fb: FormBuilder, private router: Router, private hospitalRegistrationService:HospitalRegistrationService) { 

    this.hospForm = fb.group({
      
      hospName: ['', [Validators.required]],
      hospEmail: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      state: ['', [Validators.required]],
      city:  ['', [Validators.required]],
      pin:   ['', [Validators.required]],
      password: ['', [Validators.required]],
      confirm_password: ['', [Validators.required]]
      
    },{ 
      validator: ConfirmedValidator('password', 'confirm_password')
    })
  }

  ngOnInit(): void {
  }

  get f(){
    return this.hospForm.controls;
  }

  submit()
  {
    console.log("Submitted form is: ", this.hospForm.value);
    console.log("inside submit process");
    if(this.hospForm.valid)
    {
      console.log("inside this.hospForm.valid");
      this.hospitalRegistrationService.hospitalRegistration(this.hospForm.value).subscribe(result=>{

        console.log("inside: this.hospitalRegistrationService.hospitalRegistration(this.form.value).subscribe(result=>{ ");
        if(result['status']==200){
          console.log(result);
          //alert("Registered Successfully!! Email has been sent to hospital.");
          console.log("Registered Successfully!! Email has been sent to hospital.");
          this.router.navigateByUrl("/"); //need to add registration successful code.
        }
        else{
          alert(result.message);
        }
        console.log("coming out of: this.hospitalRegistrationService.hospitalRegistration(this.form.value).subscribe(result=>{ ");
      })

      console.log("coming out of this.form.valid");
    }
    
    console.log("coming out of submit process");
  }
}