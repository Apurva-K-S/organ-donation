import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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
  

  constructor(private fb: FormBuilder) { 

    this.hospForm = fb.group({
      
      hospName: ['', [Validators.required]],
      hospEmail: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      state: ['', [Validators.required]],
      city:  ['', [Validators.required]],
      pin:   ['', [Validators.required]],
      
    })
  }

  ngOnInit(): void {
  }

  get f(){
    return this.hospForm.controls;
  }

  submit()
  {

  }
 

}