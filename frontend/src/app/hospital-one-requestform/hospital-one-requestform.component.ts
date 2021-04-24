import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OrganRequestService } from '../services/organ-request.service';


interface BloodGroup{
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-hospital-one-requestform',
  templateUrl: './hospital-one-requestform.component.html',
  styleUrls: ['./hospital-one-requestform.component.css']
})
export class HospitalOneRequestformComponent implements OnInit {


  bloodGroups: BloodGroup[]=[
    {value: 'A+', viewValue: 'A+'},
    {value: 'A-', viewValue: 'A-'},
    {value: 'B+', viewValue: 'B+'},
    {value: 'B-', viewValue: 'B-'},
    {value: 'O+', viewValue: 'O+'},
    {value: 'O-', viewValue: 'O-'},
    {value: 'AB+', viewValue: 'AB+'},
    {value: 'AB-', viewValue: 'AB-'}
  
    ];
  
    organHeart = 'Heart';
  organKidney = 'Kidney';
  organLiver = 'Liver';
  //organLungs = 'Lungs';
  organEyes= 'Eyes';
  
  hospRequestForm!: FormGroup;


  constructor(private orgRequestService:OrganRequestService) { }

  ngOnInit(): void {
    console.log("Inside ngInit of hosp-1-requestform class");
    this.initRequestForm()
  }


  initRequestForm()
  {
    console.log("inside initRequstForm");
    
    this.hospRequestForm = new FormGroup({
      patientFirstName: new FormControl('',[Validators.required]),
      patientLastName: new FormControl('',[Validators.required]), 
      patientEmail: new FormControl('',[Validators.required]),
      patientPhone: new FormControl('',[Validators.required]),

      hospitalEmail: new FormControl('',[Validators.required]),

      hospitalPhone: new FormControl('',[Validators.required]),
      organ_Heart: new FormControl(''),
      organ_Kidney : new FormControl(''),
      organ_Liver : new FormControl(''),
      organ_Eyes: new FormControl(''),
      bloodGroup: new FormControl(''),

      

    })
  }

  raiseRequest()
  {

    console.log(this.hospRequestForm.value);
    console.log("inside raiseRequest process");
    if(this.hospRequestForm.valid)
    {
      console.log("inside this.hospRequestForm.valid");
      this.orgRequestService.raiseRequest(this.hospRequestForm.value).subscribe(result=>{
      
        console.log("Inside the subscribe method of raiseRequest service");
        
      
      })

    

  }

}
}
