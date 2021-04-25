import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
//import { NgxQRCodeModule } from '@techiediaries/ngx-qrcode';
//import { NgxQRCodeModule } from 'ngx-qrcode2';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomePageComponent } from './home-page/home-page.component';
import { UserRegComponent } from './user-reg/user-reg.component';
import { OrganListComponent } from './organ-list/organ-list.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserHomepageComponent } from './user-homepage/user-homepage.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HospitalsListComponent } from './hospitals-list/hospitals-list.component';
import { HttpClientModule } from '@angular/common/http';
import { DonatePageComponent } from './donate-page/donate-page.component';
import { ConfirmEqualValidatorDirective } from './custom-directives/confirm-equal-validator.directive';
import { ListOfOrgansComponent } from './list-of-organs/list-of-organs.component';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';
import { PrmUserHomepageComponent } from './prm-user-homepage/prm-user-homepage.component';
import { SecUserHomepageComponent } from './sec-user-homepage/sec-user-homepage.component';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { OrganHeartComponent } from './organ-heart/organ-heart.component';
import { OrganKidneyComponent } from './organ-kidney/organ-kidney.component';
import { OrganLiverComponent } from './organ-liver/organ-liver.component';
import { OrganEyesComponent } from './organ-eyes/organ-eyes.component';
//import { QrCodeComponent } from './qr-code/qr-code.component';
//import { QRCodeModule } from 'angular2-qrcode';
import { HospitalRegistrationComponent } from './hospital-registration/hospital-registration.component';
import { HospitalLoginComponent } from './hospital-login/hospital-login.component';
import { HospitalOneComponent } from './hospital-one/hospital-one.component';
import { HospitalTwoComponent } from './hospital-two/hospital-two.component';
import { HospitalOneRequestformComponent } from './hospital-one-requestform/hospital-one-requestform.component';
import { HospitalTwoRequestformComponent } from './hospital-two-requestform/hospital-two-requestform.component';
import { HospitalOneResponseComponent } from './hospital-one-response/hospital-one-response.component';
import { HospitalTwoResponseComponent } from './hospital-two-response/hospital-two-response.component';
import { HospitalThreeComponent } from './hospital-three/hospital-three.component';
import { HospitalThreeRequestformComponent } from './hospital-three-requestform/hospital-three-requestform.component';
import { HospitalThreeResponseComponent } from './hospital-three-response/hospital-three-response.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    UserRegComponent,
    OrganListComponent,
    UserLoginComponent,
    UserHomepageComponent,
    HospitalsListComponent,
    DonatePageComponent,
    ConfirmEqualValidatorDirective,
    ListOfOrgansComponent,
    NavigationBarComponent,
    PrmUserHomepageComponent,
    SecUserHomepageComponent,
    ThankyouComponent,
    OrganHeartComponent,
    OrganKidneyComponent,
    OrganLiverComponent,
    OrganEyesComponent,
//    QrCodeComponent,
    HospitalRegistrationComponent,
    HospitalLoginComponent,
    HospitalOneComponent,
    HospitalTwoComponent,
    HospitalOneRequestformComponent,
    HospitalTwoRequestformComponent,
    HospitalOneResponseComponent,
    HospitalTwoResponseComponent,
    HospitalThreeComponent,
    HospitalThreeRequestformComponent,
    HospitalThreeResponseComponent    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
//    NgxQRCodeModule,
//    QRCodeModule
    
  ],
  providers: [
    UserLoginComponent,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }