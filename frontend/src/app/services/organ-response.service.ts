import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

export interface ResponseData{

  donorName: any;
  donorEmail: any;
  recepientName: any;
  donorHospital: any;
  requestHospitalEmail: any;
  organ: any;
  bloodGroup: any;

}
@Injectable({
  providedIn: 'root'
})
export class OrganResponseService {

  temp!: Observable<any>;

  constructor(private httpClient: HttpClient) { }

  getResponseData(hospitalName:any)
  {
    console.log("inside OrganResponseService->getResponseData");
    
    this.temp = this.httpClient.get<ResponseData[]>(`${baseUrl}getResponseData`, {params:hospitalName, headers:{'Accept':'application/json', 'Content-Type':'application/json'} });

    console.log("after httpClient.get call");
    
    return this.temp;
  }

  sendDonationData(credentials:any): Observable<any>
  {
    console.log("inside organ-response.service.ts -> sendDonationData");
    return this.httpClient.post(`${baseUrl}sendDonationData`, (credentials));
  }
}
