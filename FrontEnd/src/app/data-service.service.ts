
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

  getData() {
  return this.http.get<ShuttleLine[]>('http://localhost:8080/ptl');
  //https://api.openbrewerydb.org/breweries/search?page=1&per_page=5&query=
  }

  update() {
    const request = this.http.get<ShuttleLine[]>('http://localhost:8080/ptl')
    request.subscribe(resp => {
      this.lines.next(resp)
      console.warn(resp);
      
    });
  }
}
