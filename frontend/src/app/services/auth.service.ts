import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { map } from 'rxjs/operators';
import { baseUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials: any): Observable<any> {
    
    console.log("We are in auth service before gng to spring boot.");
    console.log("type is: ", typeof(credentials));
    console.log("credentials are: ", credentials);
    console.log("type is: ", typeof(JSON.stringify(credentials)));
    console.log(this.http.post(`${baseUrl}add`, credentials));
    
    return this.http.post(`${baseUrl}add`, (credentials));
  }
}