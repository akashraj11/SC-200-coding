import { QuestDetail } from './quest-detail';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChallengeService {

  public baseUrl = 'http://localhost:8080/challengeAPI/v1';

  constructor(private http: HttpClient) { }

  createChallenge(quest: QuestDetail): Observable<any> {
    return this.http.post(this.baseUrl, quest);
  }

  getChallengeById(id: number): Observable<any> {
    return this.http.get(this.baseUrl + '/' + id);
  }

  updateChallenge(id: number, quest: QuestDetail): Observable<any> {
    return this.http.put(this.baseUrl + '/' + id, quest);
  }

}
