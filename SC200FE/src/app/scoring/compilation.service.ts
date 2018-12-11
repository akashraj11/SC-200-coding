import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CompilationService {

  public baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  receiveHtml(a: string) {
    return this.http.post(this.baseUrl, a);
  }
}
