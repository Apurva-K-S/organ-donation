import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

export interface LiverData{
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
}
