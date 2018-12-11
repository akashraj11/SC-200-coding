import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CompilationService {

  public baseUrl = 'http://localhost:8183/compile/';

  constructor(private http: HttpClient) { }

  receiveHtml(a: string) {
    return this.http.post(this.baseUrl, a);
  }
}
