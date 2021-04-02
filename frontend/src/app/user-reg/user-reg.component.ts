import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';
  
import { ConfirmedValidator } from 'src/app/confirmed.validator';

@Component({
  selector: 'app-user-reg',
  templateUrl: './user-reg.component.html',
  styleUrls: ['./user-reg.component.css']
})

export class UserRegComponent {
  form: FormGroup = new FormGroup({});
  
  constructor(private fb: FormBuilder) {

//    console.log("inside constructor");
  
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

      secondary_firstName: ['', [Validators.required]],
      secondary_lastName: ['', [Validators.required]],
      secondary_email: ['', [Validators.required]],
      secondary_phone: ['', [Validators.required]],
      secondary_aadhar: ['', [Validators.required]],
      termsConditionsCheckbox: ['', [Validators.required]],
      secondary_relationship: ['', [Validators.required]]
    }, { 
      validator: ConfirmedValidator('password', 'confirm_password')
    })
//    console.log("constructor end");
  }
    
  /*ngOnInit(): void {
    console.log("inside ngOnInit()");
    this.initForm();
    console.log("at the end of ngOnInit()");
  }

  initForm()
  {
    console.log("inside initform");

    this.form = new FormGroup({
        firstName: new FormControl('', Validators.compose([Validators.required])),
        lastName: new FormControl('', [Validators.required]),
        email: new FormControl('', [Validators.required]),
        phone: new FormControl('', [Validators.required]),
        aadhar: new FormControl('', Validators.compose([Validators.required,])),
        age: new FormControl('', [Validators.required]),
        bloodGroup: new FormControl('', [Validators.required]),
        Male: new FormControl('', [Validators.required]),
        Female: new FormControl('', [Validators.required]),
        password: new FormControl('', [Validators.required]),
        confirm_password: new FormControl('', [Validators.required]),

        secondary_firstName: new FormControl('', [Validators.required]),
        secondary_lastName: new FormControl('', [Validators.required]),
        secondary_email: new FormControl('', [Validators.required]),
        secondary_phone: new FormControl('', [Validators.required]),
        secondary_aadhar: new FormControl('', [Validators.required]),
        termsConditionsCheckbox: new FormControl('', [Validators.required]),
        secondary_relationship: new FormControl('', [Validators.required]),
      })
    
      console.log("at the end of initForm()");
  }*/

  get f(){
//    console.log(this.form.value);
//    console.log(this.form.valid);
    return this.form.controls;
  }
   
  submit(){
    console.log(this.form.value);

  }
   
}