import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { SecUserService, JustOrgansList } from '../services/sec-user.service';

interface Role{
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-sec-user-homepage',
  templateUrl: './sec-user-homepage.component.html',
  styleUrls: ['./sec-user-homepage.component.css']
})
export class SecUserHomepageComponent implements OnInit {

  formGroup! : FormGroup;
  showMe:boolean = false;
  showTable:boolean = false;
  loginEmail!: string;
  //priUserStatus!: string;
  justOrgansLists!: JustOrgansList[];

  hospitals: Role[]=[
    {value: 'Hospital1', viewValue: 'Hospital1'},
    {value: 'Hospital2', viewValue: 'Hospital2'},
    {value: 'Hospital3', viewValue: 'Hospital3'},
    {value: 'Hospital4', viewValue: 'Hospital4'},
    {value: 'Hospital5', viewValue: 'Hospital5'}
  
    ];
    

  constructor(private route: ActivatedRoute, private secUserServ:SecUserService) { 
    //this.priUserStatus = 'alive';
    
  }

  ngOnInit(): void {

    //this.priUserStatus = 'alive';
    this.formGroup = new FormGroup({
      priUserStatus: new FormControl('alive', [Validators.required]),
      hospitalName: new FormControl('', [Validators.required])
    })

    //this.justOrgansLists.forEach(control => this.formGroup.addControl(control.organ, new FormControl('', Validators.required)))

    this.route.params.subscribe(params=>{
      this.loginEmail = params['loginEmail'];
     })
     this.fetchOrganList();
  }

  toggleTag1()
  {
    this.showMe=true
    this.fetchOrganList()
  }
  toggleTag2()
  {
    this.showMe=false
    this.fetchOrganList()
  }

  fetchOrganList()
  {
    this.showTable = true;
    console.log("Inside fetchOrganList list",this.formGroup.value);
    console.log("Login form email in SecUserHomepageComponent:", this.loginEmail);
    this.formGroup.addControl('loginEmail',new FormControl(this.loginEmail,Validators.required));
    console.log("Inside fetchOrganList list after adding new formcontrol",this.formGroup.value);

    this.secUserServ.getOrganList(this.formGroup.value).subscribe(result=>{
        
      this.justOrgansLists = result;
      console.log("inside this.secUserServ.getOrganList(this.formGroup.value).subscribe(result=>{ ");
      console.log("list is: ",this.justOrgansLists);
      this.justOrgansLists.forEach(control => this.formGroup.addControl(control.organ, new FormControl('', Validators.required)))
    })  
  }

  storeHospitalName()
  {
    
    console.log("Inside storeHospitalName",this.formGroup.value);
    console.log("Login form email in storeHospitalName:", this.loginEmail);
    this.formGroup.addControl('loginEmail',new FormControl(this.loginEmail,Validators.required));
    console.log("Inside storeHospitalName list after adding new formcontrol",this.formGroup.value);

    this.secUserServ.storeHospitalName(this.formGroup.value).subscribe(result=>{
        
      if(result['status']==200)
      {
        console.log("stored hospital name + timestamp to database and also sent mail to primary user.")
      }
      else
      {
        alert("unable to store values");
      }

      })
  }
}
