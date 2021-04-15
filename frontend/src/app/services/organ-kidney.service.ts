import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

export interface KidneyData{
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
export class OrganKidneyService {

  temp!: Observable<any>;

  constructor(private httpClient: HttpClient) { }

  getKidneyData(){
    console.log("inside OrganKidneyService->getKidneyData");
    
    this.temp = this.httpClient.get<KidneyData[]>(`${baseUrl}getKidneyOrgan`, {headers:{'Accept':'application/json', 'Content-Type':'application/json'} });

    console.log("after httpClient.get call");
    
    return this.temp;
  }
}
