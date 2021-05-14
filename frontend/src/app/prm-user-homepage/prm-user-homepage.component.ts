import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { PriUserOrganListService } from 'src/app/services/pri-user-organ-list.service'
import { UserLoginComponent } from '../user-login/user-login.component';

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
  //organLungs = 'Lungs';
  organEyes= 'Eyes';
  //organSkin = 'Skin';

  loginEmail!: string;

  constructor(private priUserOrganListService:PriUserOrganListService, private loginComp: UserLoginComponent,private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {

    this.formGroup = new FormGroup({
      organ_Heart: new FormControl('', [Validators.required]),
      organ_Kidney : new FormControl('',[Validators.required]),
      organ_Liver : new FormControl('',[Validators.required]),
      //organ_Lungs : new FormControl('',[Validators.required]),
      organ_Eyes: new FormControl('',[Validators.required]),
      //organ_Skin: new FormControl('',[Validators.required]),

    })

    this.route.params.subscribe(params=>{
      this.loginEmail = params['loginEmail'];
      
     })

  }

  organDonationList()
  {
    console.log("Inside organDonaltionList() ");
    console.log("Inside Organdonation list",this.formGroup.value);
    console.log("Login form email in prmUserComponent:", this.loginEmail);
    this.formGroup.addControl('loginEmail',new FormControl(this.loginEmail,Validators.required));
    console.log("Inside Organdonation list after adding new formcontrol",this.formGroup.value);

    //if(this.formGroup.valid) 
    // ==> this will be true only when all the check boxes are ticked else it wont work. so cant use it here.
    //{
      console.log("Inside this.primUserList.valid ");

      this.priUserOrganListService.primUserList(this.formGroup.value).subscribe(result=>
        {
          // need to show alert box if its success or error.
          alert("Thank you for saving someone's life");

          this.router.navigateByUrl("/");
   
   
        })
   // }

  }
}
