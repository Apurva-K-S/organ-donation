import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';
export interface OrganList{
  organName: any;
}

@Injectable({
  providedIn: 'root'
})
export class SecUserService {

  constructor(private httpClient: HttpClient) { }

  getOrganList(secUserdata: any): Observable<any>
  {
    console.log("We are in SecUserService service class and secUserdata() before gng to spring boot.");
    console.log("type is: ", typeof(secUserdata));
    console.log("SecuUserData is: ", secUserdata);
    
    return this.httpClient.get<OrganList[]>(`${baseUrl}secUserGetList`, {params:secUserdata, headers:{'Accept':'application/json', 'Content-Type':'application/json'} });

  }

}
