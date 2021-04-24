import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class OrganRequestService {

  constructor(private httpClient:HttpClient) { }


  raiseRequest(organRequestDetails: any): Observable<any>
  {

    console.log("Inside raiseReuest of service class");
    console.log("Inside raiserequest service details: ",organRequestDetails);

    return this.httpClient.post(`${baseUrl}organRequest`, (organRequestDetails));
  }


}
