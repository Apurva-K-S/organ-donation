import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { ConfirmedValidator } from 'src/app/confirmed.validator';
import {ThankyouServiceService} from 'src/app/services/thankyou-service.service';

@Component({
  selector: 'app-thankyou',
  templateUrl: './thankyou.component.html',
  styleUrls: ['./thankyou.component.css']
})
export class ThankyouComponent implements OnInit {

  form: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder, private thankyouServiceService:ThankyouServiceService,private router: Router) {
    
  }

  ngOnInit(): void {
  }

  submit(){
    this.thankyouServiceService.sendEmail(this.form.value).subscribe(result=>{
      console.log(result);
    })
  }


}
