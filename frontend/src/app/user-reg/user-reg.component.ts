import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-reg',
  templateUrl: './user-reg.component.html',
  styleUrls: ['./user-reg.component.css']
})
export class UserRegComponent implements OnInit {

  userName:string = '';
  
  constructor() { }

  ngOnInit(): void {
  }

}
