import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserLoginServiceService {

  isLoggedIn: Subject<boolean> = new Subject<boolean>();
  logginStatus = false;

  constructor(){
    this.isLoggedIn.next(this.logginStatus);
  }

  changeValue(){
    this.logginStatus = !this.logginStatus;
    this.isLoggedIn.next(this.logginStatus)
  }

}
