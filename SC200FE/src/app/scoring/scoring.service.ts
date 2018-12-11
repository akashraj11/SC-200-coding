import { Score } from './score';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ScoringService {

  public baseUrl = environment.apiUrl + 'score';

  constructor(private http: HttpClient) { }

  sendToProfile(profile: Score): Observable<any> {
    return this.http.post(this.baseUrl, profile);
  }
}
