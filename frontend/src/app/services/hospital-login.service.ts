import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { map } from 'rxjs/operators';
import { baseUrl } from 'src/environments/environment';


export interface HospitalName{
  hospitalName : any;
}



@Injectable({
  providedIn: 'root'
})
export class HospitalLoginService {

 // hospName!: string;
 temp! :Observable<any>;

  constructor(private http: HttpClient) { }
  login(loginCredentials: any): Observable<any> {
    
    console.log("We are in HospitalLoginServiceand login() before gng to spring boot.");
    console.log("login credentials are: ", loginCredentials);

     this.temp = this.http.post(`${baseUrl}hospitalLogin`, loginCredentials,{responseType: "text"});
     console.log("After receiving get value: ",this.temp);
     return this.temp;
  }
}
