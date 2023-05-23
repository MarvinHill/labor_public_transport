import { Component, AfterViewInit, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.css']
})
export class MainViewComponent implements OnInit {
  window: any; 

  constructor() { }

  ngOnInit() {
    this.window = window;
  }
}






