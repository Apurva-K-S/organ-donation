import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomePageComponent } from './home-page/home-page.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { UserRegComponent } from './user-reg/user-reg.component';
import { OrganListComponent } from './organ-list/organ-list.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserHomepageComponent } from './user-homepage/user-homepage.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    UserRegComponent,
    OrganListComponent,
    UserLoginComponent,
    UserHomepageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
