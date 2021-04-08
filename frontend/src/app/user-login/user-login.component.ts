import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  loginForm!: FormGroup;

  constructor() { }

  ngOnInit(): void {
    this.initLoginForm()
  }

  initLoginForm()
  {
    console.log("inside initLoginform");
    
    this.loginForm = new FormGroup({
        loginEmail: new FormControl('',[Validators.required]),
        loginPassword: new FormControl('',[Validators.required]),
          
    })

  }
  login()
  {
    console.log("Inside login() of login-component");
    console.log("Inside login() form value",this.loginForm.value);
    if(this.loginForm.valid)
    {
      console.log("Inside this.loginfor.valid ");
      
    }
    

  }

}
