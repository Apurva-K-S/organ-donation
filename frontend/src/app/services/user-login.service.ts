import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { map } from 'rxjs/operators';
import { baseUrl } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  constructor(private http: HttpClient) { }

  login(loginCredentials: any): Observable<any> {
    
    console.log("We are in login service before gng to spring boot.");
    console.log("type is: ", typeof(loginCredentials));
    console.log("login credentials are: ", loginCredentials);
    //console.log(this.http.post(`${baseUrl}add`, credentials));

    return this.http.post(`${baseUrl}login`, (loginCredentials));
   
  }
}
