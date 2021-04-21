import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { map } from 'rxjs/operators';
import { baseUrl } from 'src/environments/environment';

export interface HospitalData{
  hospitalName:any;
}

@Injectable({
  providedIn: 'root'
})
export class ThankyouServiceService {

  temp!: Observable<any>;

  constructor(private httpClient: HttpClient) { }

  getHospitalInfo(): Observable<any> {
    
    console.log("We are in ThankyouService:getHospitalInfo before gng to spring boot.");
  

    this.temp = this.httpClient.get<HospitalData[][]>(`${baseUrl}thankyou`, {headers:{'Accept':'application/json', 'Content-Type':'application/json'} });
   
    return this.temp;
  }
}