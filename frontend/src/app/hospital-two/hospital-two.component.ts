import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OrganRequestService } from '../services/organ-request.service';


interface BloodGroup{
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-hospital-two',
  templateUrl: './hospital-two.component.html',
  styleUrls: ['./hospital-two.component.css']
})
export class HospitalTwoComponent implements OnInit {

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
    console.log("Inside ngInit of hosp-2-requestform class");
    this.initRequestForm()
  }


  initRequestForm()
  {
    console.log("inside initRequstForm hospital-2");
    
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
    console.log("inside raiseRequest process of hospital 2");
    if(this.hospRequestForm.valid)
    {
      console.log("inside this.hospRequestForm.valid hospital-2");
      this.orgRequestService.raiseRequest(this.hospRequestForm.value).subscribe(result=>{
      
        console.log("Inside the subscribe method of raiseRequest service of hospital-2");
        
      
      })

    

  }

}
}
