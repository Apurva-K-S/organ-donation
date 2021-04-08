import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
  
import { ConfirmedValidator } from 'src/app/confirmed.validator';
import {AuthService} from 'src/app/services/auth.service';

@Component({
  selector: 'app-user-reg',
  templateUrl: './user-reg.component.html',
  styleUrls: ['./user-reg.component.css']
})

export class UserRegComponent {
  form: FormGroup = new FormGroup({});
  
  constructor(private fb: FormBuilder, private authService:AuthService,private router: Router) {
  
    this.form = fb.group({
      
      password: ['', [Validators.required]],
      confirm_password: ['', [Validators.required]],
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      email: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      aadhar: ['', [Validators.required]],
      age: ['', [Validators.required]],
      bloodGroup: ['', [Validators.required]],
      gender: ['', [Validators.required]],

      secondary_first_name: ['', [Validators.required]],
      secondary_last_name: ['', [Validators.required]],
      secondary_email: ['', [Validators.required]],
      secondary_phone: ['', [Validators.required]],
      secondary_aadhar: ['', [Validators.required]],
      termsConditionsCheckbox: ['', [Validators.required]],
      secondary_relationship: ['', [Validators.required]]
    }, { 
      validator: ConfirmedValidator('password', 'confirm_password')
    })
  }
    
  get f(){
    return this.form.controls;
  }
   
 

  submit(){
    console.log(this.form.value);
    console.log("inside submit process");
    if(this.form.valid)
    {
      console.log("inside this.form.valid");
      this.authService.login(this.form.value).subscribe(result=>{

        console.log("inside: this.authService.login(this.form.value).subscribe(result=>{ ");
        //if(result.success){
        console.log(result);
        //  alert(result.message);
          
        //}
        //else{
        //  alert(result.message);
        //}
        console.log("coming out of: this.authService.login(this.form.value).subscribe(result=>{ ");
      })

      console.log("coming out of this.form.valid");
    }
    
    console.log("coming out of submit process");
    this.router.navigateByUrl("/"); //need to add registration successful code.
    
  }
   
}