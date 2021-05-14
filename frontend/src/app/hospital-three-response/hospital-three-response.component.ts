import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OrganResponseService, ResponseData } from '../services/organ-response.service';

@Component({
  selector: 'app-hospital-three-response',
  templateUrl: './hospital-three-response.component.html',
  styleUrls: ['./hospital-three-response.component.css']
})

export class HospitalThreeResponseComponent implements OnInit {

  responseData !: ResponseData[];
  form: FormGroup = new FormGroup({});
  hospitalName = "hospitalName";

  constructor(private organResponseService:OrganResponseService, private router:Router) { }

  ngOnInit(): void {


    console.log("Inside ngOnInit");
    console.log("inside HospitalThreeResponseComponent");

    this.form.addControl(this.hospitalName, new FormControl('Hospital3',Validators.required));
    console.log("the form data is: ", this.form.value);
    this.organResponseService.getResponseData(this.form.value).subscribe(result=>{
      this.responseData = result;
                    

      console.log("inside this.organHeartService.getHeartData().subscribe(result=>{ ");
      console.log("list is: ",this.responseData);
      if(this.responseData.length == 0)
      {
          alert("Currently no requests available!!");
          this.router.navigateByUrl("/hospitalThree");
      }
    })

  }
  submit(tableData:any)
  {
    console.log("this is inside submit() of hospital-three-response.component.ts");
    console.log("values are", tableData);

    this.organResponseService.sendDonationData(tableData).subscribe(result=>{
        
      if(result['status']==200)
      {
        console.log("donated!! Mails have been sent to requested hospitals");
        this.router.navigateByUrl("/hospThreeResponse");
      }
      else
      {
        alert("unable to donate!!");
        this.router.navigateByUrl("/hospThreeResponse");
      }
    })
    
  }

}