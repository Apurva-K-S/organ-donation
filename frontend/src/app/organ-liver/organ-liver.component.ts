import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrganLiverService, LiverData } from '../services/organ-liver.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-organ-liver',
  templateUrl: './organ-liver.component.html',
  styleUrls: ['./organ-liver.component.css']
})
export class OrganLiverComponent implements OnInit {

  liverData!: LiverData[]
  constructor(private route: ActivatedRoute, private organLiverService:OrganLiverService, private router: Router) { }

  ngOnInit(): void {
    console.log("Inside ngOnInit");
    console.log("inside organ-liver ngoninit");
    
    this.organLiverService.getLiverData().subscribe(result=>{
      this.liverData = result;

      console.log("inside this.organHeartService.getLiverData().subscribe(result=>{ ");
      console.log("list is: ",this.liverData);

      if(this.liverData.length == 0)
      {
          alert("Currently no donor available for this organ!!");
          this.router.navigateByUrl("/");
      }
  })

  }
}
