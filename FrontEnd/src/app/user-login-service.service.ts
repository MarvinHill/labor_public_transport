import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserLoginServiceService {

  isLoggedIn: Subject<boolean> = new Subject<boolean>(); 
  logginStatus: boolean = false;
  router: Router;

  constructor(router : Router){
    this.isLoggedIn.next(this.logginStatus);
    this.router = router;
  }

  changeValue(){
    this.logginStatus = !this.logginStatus;
    this.isLoggedIn.next(this.logginStatus)
  }

  showLoginPage(){
    this.router.navigateByUrl('/second')
  }

}
