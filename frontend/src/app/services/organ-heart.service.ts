import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

export interface HeartData{
  bloodGroup: any;
  count: any;
}

export interface HeartData2{
  bloodGroup: any;
  hospitalName: any;
  donorName: any;
  donatedDateAndTime: any;
}

@Injectable({
  providedIn: 'root'
})
export class OrganHeartService {

  temp!: Observable<any>;
 
  constructor(private httpClient: HttpClient) { }

  getHeartData()
  {
    console.log("inside OrganHeartService->getHeartData");
    
    this.temp = this.httpClient.get<HeartData[]>(`${baseUrl}getHeartOrgan`, {headers:{'Accept':'application/json', 'Content-Type':'application/json'} });

    console.log("after httpClient.get call");
    
    return this.temp;
  }

  getPatientData(bldHospitalData: any): Observable<any>
  {
    /*
      required: bloodGroup, hospitalName, donorName, donatedTime (Day, time) => heartData2.

      send bloodGroup and hospitalName and get all the above data.
    */

    console.log("inside OrganHeartService->getPatientData");
    console.log("form data is: ", bldHospitalData);
    this.temp = this.httpClient.get<HeartData2[][]>(`${baseUrl}getDonorInfo`, {params:bldHospitalData, headers:{'Accept':'application/json', 'Content-Type':'application/json'} });
    
    console.log("after httpClient.get call");
    
    return this.temp;

  }


}
