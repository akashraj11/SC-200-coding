import { Voting } from './voting';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VotingService {

  public baseUrl = 'http://172.23.239.248:8080/sc200/voting/';
  constructor(private http: HttpClient) { }

  upVote(voting: Voting): Observable<any> {
    return this.http.put(this.baseUrl + 'upvoting', voting);
  }

  downVote(voting: Voting): Observable<any> {
    return this.http.put(this.baseUrl + 'downvoting', voting);
  }

}
