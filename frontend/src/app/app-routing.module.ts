import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DonatePageComponent } from './donate-page/donate-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { HospitalLoginComponent } from './hospital-login/hospital-login.component';
import { HospitalOneRequestformComponent } from './hospital-one-requestform/hospital-one-requestform.component';
import { HospitalOneResponseComponent } from './hospital-one-response/hospital-one-response.component';
import { HospitalOneComponent } from './hospital-one/hospital-one.component';
import { HospitalRegistrationComponent } from './hospital-registration/hospital-registration.component';
import { HospitalThreeRequestformComponent } from './hospital-three-requestform/hospital-three-requestform.component';
import { HospitalThreeResponseComponent } from './hospital-three-response/hospital-three-response.component';
import { HospitalThreeComponent } from './hospital-three/hospital-three.component';
import { HospitalTwoRequestformComponent } from './hospital-two-requestform/hospital-two-requestform.component';
import { HospitalTwoResponseComponent } from './hospital-two-response/hospital-two-response.component';
import { HospitalTwoComponent } from './hospital-two/hospital-two.component';
import { HospitalsListComponent } from './hospitals-list/hospitals-list.component';
import { ListOfOrgansComponent } from './list-of-organs/list-of-organs.component';
import { OrganEyesComponent } from './organ-eyes/organ-eyes.component';
import { OrganHeartComponent } from './organ-heart/organ-heart.component';
import { OrganKidneyComponent } from './organ-kidney/organ-kidney.component';
import { OrganListComponent } from './organ-list/organ-list.component';
import { OrganLiverComponent } from './organ-liver/organ-liver.component';
import { PrmUserHomepageComponent } from './prm-user-homepage/prm-user-homepage.component';
//import { QrCodeComponent } from './qr-code/qr-code.component';
import { SecUserHomepageComponent } from './sec-user-homepage/sec-user-homepage.component';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { UserHomepageComponent } from './user-homepage/user-homepage.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegComponent } from './user-reg/user-reg.component';


const routes: Routes = [
  {path:'', component:HomePageComponent},
  {path:'usrReg', component:UserRegComponent},
  {path: 'organList', component:OrganListComponent},
  {path: 'usrLogin', component:UserLoginComponent},
  {path: 'usrHomepage', component:UserHomepageComponent},
  {path: 'hospitalsList', component:HospitalsListComponent},
  {path: 'donatePage', component: DonatePageComponent},
  {path: 'listOfOrgans', component: ListOfOrgansComponent},
  {path: 'thankyou', component: ThankyouComponent},
  
  {path: 'prmUserHomepage/:loginEmail', component: PrmUserHomepageComponent},
  {path: 'secUserHomepage/:loginEmail', component: SecUserHomepageComponent},
  
  {path: 'organHeart', component: OrganHeartComponent},
  {path: 'organKidney', component: OrganKidneyComponent},
  {path: 'organEyes', component: OrganEyesComponent},
  {path: 'organLiver', component: OrganLiverComponent},
  //{path: 'qrCode', component: QrCodeComponent},
  
  {path: 'hospitalRegistration', component: HospitalRegistrationComponent},
  {path: 'hospitalLoginComponent', component: HospitalLoginComponent},

  {path: 'hospitalOne', component: HospitalOneComponent},
  {path: 'hospOneRequest', component: HospitalOneRequestformComponent},
  {path: 'hospOneResponse', component: HospitalOneResponseComponent},
  
  {path: 'hospitalTwo', component: HospitalTwoComponent},
  {path: 'hospTwoRequest', component: HospitalTwoRequestformComponent},
  {path: 'hospTwoResponse', component: HospitalTwoResponseComponent},

  {path: 'hospitalThree', component: HospitalThreeComponent},
  {path: 'hospThreeRequest', component: HospitalThreeRequestformComponent},
  {path: 'hospThreeResponse', component: HospitalThreeResponseComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
