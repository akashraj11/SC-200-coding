import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }
  findByText(searchText: string){
    console.log(searchText+"http");
     return this.http.get<any>(environment.apiUrl+`challenge/challengeAPI/v1/suggestion/`+searchText)
      
  
  }
  findAll(){
    return this.http.get<any>(environment.apiUrl+`challenge/challengeAPI/v1/suggestion/basic`)
  }
}
