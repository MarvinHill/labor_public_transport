import {Component, ElementRef, HostListener, OnInit, Renderer2, ViewChild} from '@angular/core';
import * as L from 'leaflet';
import { UserLoginServiceService } from '../user-login-service.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  private map: L.Map;
  private centroid: L.LatLngExpression = [49.485, 8.5];

  protected minimized: boolean = true;

  private userService : UserLoginServiceService;
  private renderer : Renderer2;

  protected isLoggedIn : boolean = true;
  protected mapHeight: number = 10;

  @ViewChild('container', { static: false }) container: ElementRef;
  
  
  MapComponent(userService : UserLoginServiceService, renderer : Renderer2){
    this.userService = userService;
    this.userService.isLoggedIn.subscribe(value => {
      this.isLoggedIn = value;
    });
    this.renderer = renderer;
  }


  private initMap(): void {
    this.map = L.map('map', {
      center: this.centroid,
      zoom: 15
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 10,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);

  }

  constructor() { }

  ngOnInit(): void {
    this.initMap();
  }

  maximizeMap(): void {
    if(this.minimized) {
      document.getElementById("map-container").className = "map-container-large";
      this.minimized = false;
    }
  }

  minimizeMap(): void {
    if(!this.minimized) {
      document.getElementById("map-container").className = "map-container-small";
      this.minimized = true;
    }
  }

  resizeMap(): void {
    if(this.minimized) {
      this.maximizeMap();
    } else {
      this.minimizeMap();
    }
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
  var windowHeight = window.innerHeight;
  var topBarHeight  = document.getElementById("top-bar").offsetHeight;
  this.mapHeight = windowHeight - topBarHeight;
  }
}

