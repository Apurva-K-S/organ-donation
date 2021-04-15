import { ActivatedRoute } from '@angular/router';
import { OrganEyesService, EyesData } from '../services/organ-eyes.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-organ-eyes',
  templateUrl: './organ-eyes.component.html',
  styleUrls: ['./organ-eyes.component.css']
})
export class OrganEyesComponent implements OnInit {

  eyesData!: EyesData[];

  constructor(private route: ActivatedRoute, private organEyesService:OrganEyesService, private router: Router) { }

  ngOnInit(): void {
    console.log("Inside ngOnInit");
    console.log("inside organ-eyes ngoninit");
    
    this.organEyesService.getEyesData().subscribe(result=>{
      this.eyesData = result;

      console.log("inside this.organHeartService.getEyesData().subscribe(result=>{ ");
      console.log("list is: ",this.eyesData);
      if(this.eyesData.length == 0)
      {
          alert("Currently no donor available for this organ!!");
          this.router.navigateByUrl("/");
      }
    })
  }

}
