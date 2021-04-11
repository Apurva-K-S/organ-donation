import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { baseUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PriUserOrganListService {

  constructor(private http: HttpClient) { }

  primUserList(primUserOrganCredentials: any): Observable<any> {
    
    console.log("We are in PriUserOrganListService service class and primUserList() before gng to spring boot.");
    console.log("type is: ", typeof(primUserOrganCredentials));
    console.log("primUserOrganCredentials credentials are: ", primUserOrganCredentials);
    //console.log(this.http.post(`${baseUrl}add`, credentials));

    return this.http.post(`${baseUrl}primUserOrganList`, (primUserOrganCredentials));
  }
}
