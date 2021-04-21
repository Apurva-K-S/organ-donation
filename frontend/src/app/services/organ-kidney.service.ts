import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

export interface KidneyData{
  bloodGroup: any;
  count: any;
}


export interface KidneyData2{
  bloodGroup: any;
  hospitalName: any;
  donorName: any;
  donatedDateAndTime: any;
}

@Injectable({
  providedIn: 'root'
})
export class OrganKidneyService {

  temp!: Observable<any>;

  constructor(private httpClient: HttpClient) { }

  getKidneyData(){
    console.log("inside OrganKidneyService->getKidneyData");
    
    this.temp = this.httpClient.get<KidneyData[]>(`${baseUrl}getKidneyOrgan`, {headers:{'Accept':'application/json', 'Content-Type':'application/json'} });

    console.log("after httpClient.get call");
    
    return this.temp;
  }

  getPatientData(bldHospitalData: any): Observable<any>
  {
    /*
      required: bloodGroup, hospitalName, donorName, donatedTime (Day, time) => heartData2.

      send bloodGroup and hospitalName and get all the above data.
    */

    console.log("inside OrganKidneyService->getPatientData");
    console.log("form data is: ", bldHospitalData);
    this.temp = this.httpClient.get<KidneyData2[][]>(`${baseUrl}getKidneyDonorInfo`, {params:bldHospitalData, headers:{'Accept':'application/json', 'Content-Type':'application/json'} });
    
    console.log("after httpClient.get call");
    
    return this.temp;

  }
}
