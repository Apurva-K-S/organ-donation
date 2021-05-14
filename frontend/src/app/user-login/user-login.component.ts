import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {UserLoginService} from 'src/app/services/user-login.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  loginForm!: FormGroup;

  constructor(private userLoginService:UserLoginService,private router:Router) { }

  ngOnInit(): void {
    console.log("inside ngOnInit()");
    
    this.initLoginForm()
    this.loginForm.controls["loginAs"].setValue("Primary User");
  }

  get f(){
    return this.loginForm.controls;
  }

  initLoginForm()
  {
    console.log("inside initLoginform");
    
    this.loginForm = new FormGroup({
        loginEmail: new FormControl('',[Validators.required]),
        loginPassword: new FormControl('',[Validators.required]), 
        loginAs: new FormControl('',[Validators.required]),
    })
  }

  login()
  {
    console.log("Inside login() of login-component");
    console.log("Inside login() form value",this.loginForm.value);
    if(this.loginForm.valid)
    {
      console.log("Inside this.loginform.valid ");

      this.userLoginService.login(this.loginForm.value).subscribe(result=>{

        console.log("inside: this.authService.login(this.form.value).subscribe(result=>{ ");
        console.log("Result is: ", result);
        console.log("type of result: ", typeof(result));
        
        console.log("---------------------");
        
      
        if(result['status'] == 200 && this.loginForm.controls['loginAs'].value === "Primary User")
        {
          console.log(result);
          //alert("all working!! Primary user");
          console.log("all working!! Primary user");
          this.router.navigate(["/prmUserHomepage",this.loginForm.controls['loginEmail'].value]);
        }
        else if(result['status'] == 200 && this.loginForm.controls['loginAs'].value === "Secondary User")
        {
          //alert("all working!! Secondary user");
          console.log("all working!! Secondary user");
          this.router.navigate(["/secUserHomepage",this.loginForm.controls['loginEmail'].value]);
      
        }
        else{
          alert("please enter correct credentials!!");
        }
        console.log("coming out of: this.authService.login(this.form.value).subscribe(result=>{ ");
      })
      
      console.log("coming out of this.form.valid");
    }
    else
    {
      alert("please enter valid details");
    }
  }
}