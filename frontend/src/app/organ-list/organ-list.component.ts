import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-organ-list',
  templateUrl: './organ-list.component.html',
  styleUrls: ['./organ-list.component.css']
})
export class OrganListComponent implements OnInit {

  formGroup! : FormGroup;

  organHeart = 'Heart';
  organKidney = 'Kidney';
  organLiver = 'Liver';
  //organLungs = 'Lungs';
  organEyes= 'Eyes';
  //organPlasma = 'Plasma';


  constructor() { }

  ngOnInit(): void {

    this.formGroup = new FormGroup({
      heart_name: new FormControl('', [Validators.required])
    })
  }


}
