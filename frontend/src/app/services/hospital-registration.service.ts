import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { map } from 'rxjs/operators';
import { baseUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HospitalRegistrationService {

  constructor(private http: HttpClient) { }

  hospitalRegistration(credentials: any): Observable<any> {
    
    console.log("We are in HospitalRegistrationService");
    
    console.log("credentials are: ", credentials);

    return this.http.post(`${baseUrl}hospitalRegistration`, (credentials));
  }

}
