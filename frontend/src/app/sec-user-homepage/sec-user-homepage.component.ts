import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';

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
  showMe:boolean = true

  hospitals: Role[]=[
    {value: 'Hospital1', viewValue: 'Hospital1'},
    {value: 'Hospital2', viewValue: 'Hospital2'},
    {value: 'Hospital3', viewValue: 'Hospital3'},
    {value: 'Hospital4', viewValue: 'Hospital4'},
    {value: 'Hospital5', viewValue: 'Hospital5'}
  
    ];
  constructor() { }

  ngOnInit(): void {

  }
  toggleTag1()
  {
    this.showMe=true
  }
  toggleTag2()
  {
    this.showMe=false
  }

}
