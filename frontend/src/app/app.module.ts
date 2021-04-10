import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

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
    ThankyouComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }