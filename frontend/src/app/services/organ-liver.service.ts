import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

export interface LiverData{
  bloodGroup: any;
  count: any;
}

export interface LiverData2{
  bloodGroup: any;
  hospitalName: any;
  donorName: any;
  donatedDateAndTime: any;
}

@Injectable({
  providedIn: 'root'
})
export class OrganLiverService {

  temp!: Observable<any>;

  constructor(private httpClient: HttpClient) { }

  getLiverData()
  {
    console.log("inside OrganLiverService->getLiverData");
    
    this.temp = this.httpClient.get<LiverData[]>(`${baseUrl}getLiverOrgan`, {headers:{'Accept':'application/json', 'Content-Type':'application/json'} });

    console.log("after httpClient.get call");
    
    return this.temp;
  }

  getPatientData(bldHospitalData: any): Observable<any>
  {
    /*
      required: bloodGroup, hospitalName, donorName, donatedTime (Day, time) => heartData2.

      send bloodGroup and hospitalName and get all the above data.
    */

    console.log("inside OrganLiverService->getPatientData");
    console.log("form data is: ", bldHospitalData);
    this.temp = this.httpClient.get<LiverData2[][]>(`${baseUrl}getLiverDonorInfo`, {params:bldHospitalData, headers:{'Accept':'application/json', 'Content-Type':'application/json'} });
    
    console.log("after httpClient.get call");
    
    return this.temp;

  }
}
