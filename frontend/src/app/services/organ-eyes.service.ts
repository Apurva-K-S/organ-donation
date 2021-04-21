import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

export interface EyesData{
  bloodGroup: any;
  count: any;
  
}

export interface EyesData2{
  bloodGroup: any;
  hospitalName: any;
  donorName: any;
  donatedDateAndTime: any;
}


@Injectable({
  providedIn: 'root'
})
export class OrganEyesService {

  temp!: Observable<any>;

  constructor(private httpClient: HttpClient) { }

  getEyesData(){
    console.log("inside OrganEyesService->getEyesData");
    
    this.temp = this.httpClient.get<EyesData[]>(`${baseUrl}getEyesOrgan`, {headers:{'Accept':'application/json', 'Content-Type':'application/json'} });

    console.log("after httpClient.get call");
    
    return this.temp;
  }
  getPatientData(bldHospitalData: any): Observable<any>
  {
    /*
      required: bloodGroup, hospitalName, donorName, donatedTime (Day, time) => heartData2.

      send bloodGroup and hospitalName and get all the above data.
    */

    console.log("inside OrganEyesService->getPatientData");
    console.log("form data is: ", bldHospitalData);
    this.temp = this.httpClient.get<EyesData2[][]>(`${baseUrl}getEyesDonorInfo`, {params:bldHospitalData, headers:{'Accept':'application/json', 'Content-Type':'application/json'} });
    
    console.log("after httpClient.get call");
    
    return this.temp;

  }

}
