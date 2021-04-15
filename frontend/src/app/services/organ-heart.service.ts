import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

export interface HeartData{
  bloodGroup: any;
  count: any;
  donatedDay: any;
  donatedTime: any;
  donorName: any;
  hospitalName: any;
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
}
