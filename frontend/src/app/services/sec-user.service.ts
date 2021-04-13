import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';
export interface JustOrgansList{
  organ: any;
}

@Injectable({
  providedIn: 'root'
})
export class SecUserService {

  temp!: Observable<any>;
  justOrgansList!: JustOrgansList[];

  constructor(private httpClient: HttpClient) { }

  getOrganList(secUserdata: any): Observable<any>
  {
    console.log("We are in SecUserService service class and secUserdata() before gng to spring boot.");
    console.log("type is: ", typeof(secUserdata));
    console.log("SecuUserData is: ", secUserdata);
    
    this.temp = this.httpClient.get<JustOrgansList[]>(`${baseUrl}secUserGetList`, {params:secUserdata, headers:{'Accept':'application/json', 'Content-Type':'application/json'} });

    console.log("after httpClient.get call");
    
    return this.temp;
  }

  storeHospitalName(secUserdata: any): Observable<any>
  {
    console.log("We are in SecUserService service class and storeHospitalName() before gng to spring boot.");
    console.log("type is: ", typeof(secUserdata));
    console.log("SecUserData is: ", secUserdata);
    
    return this.httpClient.post(`${baseUrl}storeHospitalName`, secUserdata);;
  }
}
