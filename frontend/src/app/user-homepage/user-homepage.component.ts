import { Component, OnInit } from '@angular/core';


interface Role{
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})
export class UserHomepageComponent implements OnInit {

  organHeart = 'Heart';
  organKidney = 'Kidney';
  organLiver = 'Liver';
  organLungs = 'Lungs';
  organPancreas = 'Pancreas';
  organBoneMarrow = 'Bone Marrow';
  organBones = 'Bones';
  organEyes= 'Eyes';
  organPlasma = 'Plasma';
  organSkin = 'Skin';
  organResearch = 'Research';


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

}
