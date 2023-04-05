
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { interval, Subject } from 'rxjs';
import { ShuttleLine } from './ShuttleLine';
import { Subscription, timer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  lines: Subject<ShuttleLine[]> = new Subject<ShuttleLine[]>();

  http : HttpClient;



  constructor(http:HttpClient) {
    this.http = http;
  }

  update() {
    const request = this.http.get<ShuttleLine[]>('http://localhost:8080/ptl')
    request.subscribe(resp => {
      this.lines.next(resp)
      console.warn(resp);
    });
  }
}
