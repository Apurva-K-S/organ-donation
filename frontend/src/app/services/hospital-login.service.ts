import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { map } from 'rxjs/operators';
import { baseUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HospitalLoginService {

  constructor(private http: HttpClient) { }
  login(loginCredentials: any): Observable<any> {
    
    console.log("We are in HospitalLoginServiceand login() before gng to spring boot.");
    console.log("login credentials are: ", loginCredentials);

    return this.http.post(`${baseUrl}hospitalLogin`, (loginCredentials));
  }
}
