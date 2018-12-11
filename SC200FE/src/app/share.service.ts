import { Observable } from 'rxjs';
import { BehaviorSubject } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShareService {

  constructor() { }

  private valueObs: BehaviorSubject<any> = new BehaviorSubject<any>(null);

  public setValue(value: any): void {
    this.valueObs.next(value);
    console.log('value after setValue() is called: ' + this.valueObs.value);
  }

  public getValue(): Observable<any> {
    return this.valueObs;
  }
}
