import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

export interface EyesData{
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
export class OrganEyesService {

  temp!: Observable<any>;

  constructor(private httpClient: HttpClient) { }

  getEyesData(){
    console.log("inside OrganEyesService->getEyesData");
    
    this.temp = this.httpClient.get<EyesData[]>(`${baseUrl}getEyesOrgan`, {headers:{'Accept':'application/json', 'Content-Type':'application/json'} });

    console.log("after httpClient.get call");
    
    return this.temp;
  }

}
