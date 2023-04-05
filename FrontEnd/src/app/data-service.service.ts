
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, interval, Observable, Subject } from 'rxjs';
import { ShuttleLine } from './ShuttleLine';
import { Subscription, timer } from 'rxjs';
import { UserLoginServiceService } from './user-login-service.service';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  lines: Subject<ShuttleLine[]> = new Subject<ShuttleLine[]>();

  http : HttpClient;

  userLoginService : UserLoginServiceService;



  constructor(http:HttpClient, userLoginService : UserLoginServiceService) {
    this.http = http;
    this.userLoginService = userLoginService;
  }

  update() {
    const request = this.http.get<ShuttleLine[]>('http://localhost:8080/ptl');
    request.subscribe(resp => {
      this.lines.next(resp)
      console.warn(resp);
    });
  }
}
