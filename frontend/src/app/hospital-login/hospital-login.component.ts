import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {HospitalLoginService, HospitalName} from 'src/app/services/hospital-login.service';

@Component({
  selector: 'app-hospital-login',
  templateUrl: './hospital-login.component.html',
  styleUrls: ['./hospital-login.component.css']
})
export class HospitalLoginComponent implements OnInit {

  loginForm!: FormGroup;
  hospName!: HospitalName;
  constructor(private hospitalLoginService:HospitalLoginService, private router:Router) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      loginEmail: new FormControl('',[Validators.required]),
      loginPassword: new FormControl('',[Validators.required]), 
  })
  }
  get f(){
    return this.loginForm.controls;
  }

  login()
  {
    console.log("Inside login() of hospital-login-component");
    console.log("Inside login() form value",this.loginForm.value);
    console.log("Inside login() form value",this.loginForm.valid);
    if(this.loginForm.valid)
    {
      console.log("Inside this.loginform.valid ");

      this.hospitalLoginService.login(this.loginForm.value).subscribe(result=>{

        //this.hospName = result;
        console.log("inside: this.hospitalLoginService.login(this.loginForm.value).subscribe(result=>{ ")
        console.log("Logging console after login inside hosp login component: ",result);
        if(result === "Hospital1") // change it to "Sunshine"
          this.router.navigateByUrl("/hospitalOne");
        else if(result === "Hospital2") // change it to "Moonshine"
          this.router.navigateByUrl("/hospitalTwo");
        else if(result === "Hospital3") // change it to "Moonshine"
          this.router.navigateByUrl("/hospitalThree");
        
      })
    }
  }
}
