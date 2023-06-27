import { Component, AfterViewInit, OnInit, HostListener } from '@angular/core';
import {Router} from '@angular/router';
import { SearchService } from '../services/search.service';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.css']
})
export class MainViewComponent implements OnInit, AfterViewInit {

  
  window: any; 

  constructor() { }

  ngOnInit() {
    this.window = window;
  }

  ngAfterViewInit() {
    this.activateTooltips();
  }

  activateTooltips() {
    const tooltips = document.querySelectorAll('[data-bs-toggle="tooltip"]');
    tooltips.forEach((tooltip) => {
      new bootstrap.Tooltip(tooltip);
    });
  }
}