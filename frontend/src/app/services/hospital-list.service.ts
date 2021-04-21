import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

export interface HospitalAllData{
  id:any;
  hospName: any;
  hospEmail: any;
  phone: any;
  state: any;
  city: any;
  pin: any;
  password: any;
}


@Injectable({
  providedIn: 'root'
})
export class HospitalListService {

  temp!: Observable<any>;

  constructor(private httpClient: HttpClient) { }

  getHospitalInfo(): Observable<any>
  {

    console.log("inside HospitalListService->getHospitalInfo");
    this.temp = this.httpClient.get<HospitalAllData[][]>(`${baseUrl}getAllHospitalsData`, {headers:{'Accept':'application/json', 'Content-Type':'application/json'} });
    
    console.log("after httpClient.get call");
    
    return this.temp;

  }
}
