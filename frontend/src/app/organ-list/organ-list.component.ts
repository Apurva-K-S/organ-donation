import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-organ-list',
  templateUrl: './organ-list.component.html',
  styleUrls: ['./organ-list.component.css']
})
export class OrganListComponent implements OnInit {

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


  constructor() { }

  ngOnInit(): void {
  }


}
