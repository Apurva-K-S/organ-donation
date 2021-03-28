import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { UserRegComponent } from './user-reg/user-reg.component';


const routes: Routes = [
  {path:'', component:HomePageComponent},
  {path:'usrReg', component:UserRegComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
