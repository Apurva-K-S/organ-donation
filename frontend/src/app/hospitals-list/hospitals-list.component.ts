import { Component, OnInit } from '@angular/core';
import {HospitalListService, HospitalAllData} from 'src/app/services/hospital-list.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-hospitals-list',
  templateUrl: './hospitals-list.component.html',
  styleUrls: ['./hospitals-list.component.css']
})
export class HospitalsListComponent implements OnInit {

  hospitalAllData!: HospitalAllData[];

  constructor(private fb: FormBuilder, private route: ActivatedRoute, private hospitalListService:HospitalListService)  
  {  }


  ngOnInit(): void {
    console.log("inside ngOnInit of HospitalsListComponent");
    this.hospitalListService.getHospitalInfo().subscribe(result=>{
      this.hospitalAllData = result;
      console.log("inside this.thankyouServiceService.getHospitalInfo().subscribe(result=>{ and the result is: ");
      console.log(this.hospitalAllData);
    })
  }

}
