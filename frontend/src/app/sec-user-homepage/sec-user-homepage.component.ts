import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { SecUserService } from '../services/sec-user.service';

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
  showMe:boolean = true;
  loginEmail!: string;
  priUserStatus!: string;

  hospitals: Role[]=[
    {value: 'Hospital1', viewValue: 'Hospital1'},
    {value: 'Hospital2', viewValue: 'Hospital2'},
    {value: 'Hospital3', viewValue: 'Hospital3'},
    {value: 'Hospital4', viewValue: 'Hospital4'},
    {value: 'Hospital5', viewValue: 'Hospital5'}
  
    ];
  constructor(private route: ActivatedRoute, private secUserServ:SecUserService) { }

  ngOnInit(): void {

    this.priUserStatus = 'Alive';
    this.formGroup = new FormGroup({
      priUserStatus: new FormControl('', [Validators.required]),
      
    })


    this.route.params.subscribe(params=>{
      this.loginEmail = params['loginEmail'];
      
     })


  }
  toggleTag1()
  {
    this.showMe=true
  }
  toggleTag2()
  {
    this.showMe=false
  }

  fetchOrganList()
  {

    console.log("Inside fetchOrganList list",this.formGroup.value);
    console.log("Login form email in SecUserHomepageComponent:", this.loginEmail);
    this.formGroup.addControl('loginEmail',new FormControl(this.loginEmail,Validators.required));
    console.log("Inside fetchOrganList list after adding new formcontrol",this.formGroup.value);

    this.secUserServ.getOrganList(this.formGroup.value).subscribe(result=>{
        

 
 
      })

  }

}
