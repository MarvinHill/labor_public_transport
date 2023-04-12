import { NgIfContext } from '@angular/common';
import { Component, HostListener, TemplateRef } from '@angular/core';
import { UserLoginServiceService } from '../user-login-service.service';

@Component({
  selector: 'app-routing-top-bar',
  templateUrl: './routing-top-bar.component.html',
  styleUrls: ['./routing-top-bar.component.css']
})
export class RoutingTopBarComponent {
  userService: UserLoginServiceService;
  public innerWidth: number = 500;
desktop: TemplateRef<NgIfContext<boolean>>;
mobile: TemplateRef<NgIfContext<boolean>>;

  ngAfterViewInit() {
    this.innerWidth = window.innerWidth;
}

  @HostListener('window:resize', ['$event'])
onResize(event) {
  this.innerWidth = event.target.innerWidth;
}

constructor(userService: UserLoginServiceService){
this.userService = userService;
}

accountClicked(){
  this.userService.changeValue();
}

}
