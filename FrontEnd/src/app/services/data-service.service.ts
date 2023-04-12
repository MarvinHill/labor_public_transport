
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { interval, Subject } from 'rxjs';

import { Subscription, timer } from 'rxjs';
import { Router } from '@angular/router';
import { ShuttleLine } from '../ShuttleLine';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  lines: Subject<ShuttleLine[]> = new Subject<ShuttleLine[]>();



  constructor(private http:HttpClient, private router : Router ) {}

  update() {
    const request = this.http.get<ShuttleLine[]>('http://localhost:8080/ptl')
    request.subscribe(resp => {
      this.lines.next(resp)
      console.warn(resp);
    });
  }

  openMapExternal(from : string, to : string){
    window.open(`https://www.google.de/maps/dir/${from}/${to}/`);
  }
}
