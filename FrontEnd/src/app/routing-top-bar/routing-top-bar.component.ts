import { NgIfContext } from '@angular/common';
import { Component, ElementRef, HostListener, Inject, TemplateRef } from '@angular/core';
import { animate, style, transition, trigger } from '@angular/animations';
import { IfStmt } from '@angular/compiler';
import { interval, timer } from 'rxjs';
import { Router, NavigationEnd, RouterFeature } from '@angular/router';
import { UserLoginServiceService } from '../services/user-login-service.service';


@Component({
  selector: 'app-routing-top-bar',
  templateUrl: './routing-top-bar.component.html',
  styleUrls: ['./routing-top-bar.component.css'],
  animations: [
    trigger('fadeIn', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('250ms', style({ opacity: 1 }))
      ]),
      transition(':leave', [
        style({ opacity: 1 }),
        animate('250ms', style({ opacity: 0 }))
      ]),
    ])
  ]
})
export class RoutingTopBarComponent {
  userService: UserLoginServiceService;
  public innerWidth: number = 500;
  desktop: TemplateRef<NgIfContext<boolean>>;
  mobile: TemplateRef<NgIfContext<boolean>>;
  infoWindow: boolean = false;
  router: Router;
  update: boolean = true;


  ngAfterViewInit() {
    this.innerWidth = window.innerWidth;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = event.target.innerWidth;
  }

  constructor(userService: UserLoginServiceService, router: Router) {
    this.userService = userService;
    this.router = router;

    const source = interval(200);
    source.subscribe(val => this.updateInfoText());
  }

  updateInfoText() {

    if (!this.update) {
      return;
    }

    var elements = Array.from(document.getElementsByClassName("hidden-info")) as HTMLElement[];
    var container = document.getElementById("info-container");

    if (container != null) {
      container.childNodes.forEach(element => {
        container.removeChild(element);
      });

    }

    elements.forEach(element => {

      var clone = element.cloneNode(true);
      if (clone instanceof HTMLElement) {
        clone.className = "info";
      }

      if (container != null) {
        container.appendChild(clone);
      }
    });

    this.update = !this.update
  }

  switchInfoWindow() {
    this.infoWindow = !this.infoWindow;
    this.update = true;
  }

}
