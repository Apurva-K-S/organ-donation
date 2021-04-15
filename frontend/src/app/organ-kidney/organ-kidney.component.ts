import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrganKidneyService, KidneyData } from '../services/organ-kidney.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-organ-kidney',
  templateUrl: './organ-kidney.component.html',
  styleUrls: ['./organ-kidney.component.css']
})
export class OrganKidneyComponent implements OnInit {

  kidneyData!: KidneyData[];

  constructor(private route: ActivatedRoute, private organKidneyService:OrganKidneyService, private router: Router) { }

  ngOnInit(): void {
    console.log("Inside ngOnInit");
    console.log("inside organ-kidney ngoninit");
    
    this.organKidneyService.getKidneyData().subscribe(result=>{
      this.kidneyData = result;

      console.log("inside this.organHeartService.getKidneyData().subscribe(result=>{ ");
      console.log("list is: ",this.kidneyData);
      if(this.kidneyData.length == 0)
      {
          alert("Currently no donor available for this organ!!");
          this.router.navigateByUrl("/");
      }
    })

  }
}