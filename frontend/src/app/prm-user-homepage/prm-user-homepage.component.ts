import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-prm-user-homepage',
  templateUrl: './prm-user-homepage.component.html',
  styleUrls: ['./prm-user-homepage.component.css']
})
export class PrmUserHomepageComponent implements OnInit {

  formGroup! : FormGroup;

  organHeart = 'Heart';
  organKidney = 'Kidney';
  organLiver = 'Liver';
  organLungs = 'Lungs';
  organEyes= 'Eyes';
  organPlasma = 'Plasma';


  constructor() { }

  ngOnInit(): void {

    this.formGroup = new FormGroup({
      heart_name: new FormControl('', [Validators.required])
    })
  }


}
