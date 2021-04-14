import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { OrganHeartService, HeartData } from '../services/organ-heart.service';

@Component({
  selector: 'app-organ-heart',
  templateUrl: './organ-heart.component.html',
  styleUrls: ['./organ-heart.component.css']
})
export class OrganHeartComponent implements OnInit {

  heartData!: HeartData[];

  constructor(private route: ActivatedRoute, private organHeartService:OrganHeartService) { }

  ngOnInit(): void {
    console.log("Inside ngOnInit");
    console.log("inside organ-heart ngoninit");
    
    this.organHeartService.getHeartData().subscribe(result=>{

    })


  }

}
