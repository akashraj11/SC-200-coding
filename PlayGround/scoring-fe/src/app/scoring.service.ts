import { Profile } from './profile';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ScoringService {

  public baseUrl = 'http://localhost:8080/results/';

  constructor(private http: HttpClient) { }

  sendToProfile(profile: Profile): Observable<any> {
    return this.http.post(this.baseUrl, profile);
  }
}
