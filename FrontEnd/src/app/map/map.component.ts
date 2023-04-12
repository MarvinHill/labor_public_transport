import { Component, ElementRef, HostListener, OnInit, Renderer2, ViewChild } from '@angular/core';
import * as L from 'leaflet';
import {UserLoginServiceService} from "../services/user-login-service.service";
import {DataServiceService} from "../services/data-service.service";
import {MapDetailsObserverService} from "../services/map-details-observer.service";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  private map: L.Map;
  private centroid: L.LatLngExpression = [49.485, 8.5];

  protected minimized: boolean = true;

  mapContainerClass:string = "map-container-small-desktop";
  resizeButtonClass:string = "resize-button-min";
  private userService : UserLoginServiceService;
  private renderer : Renderer2;

  protected isLoggedIn: boolean = true;
  protected mapHeight: string = "10em";

  @ViewChild('container', { static: false }) container: ElementRef;

  windowHeight: number;
  windowWidth: number;
  topBarHeight: number;
  public innerWidth: number = 1000;
  breakPoint : number = 720;


  constructor(userService : UserLoginServiceService, renderer : Renderer2, private dataService: DataServiceService, protected observerService : MapDetailsObserverService){
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

    var carParkingLots = new L.LayerGroup;

    this.dataService.carParking.subscribe(values => {
      carParkingLots.clearLayers();
      for (let valuesKey of values) {
        console.log("for-Schleife")
        makeCarMarkers(valuesKey.geoLocation.x, valuesKey.geoLocation.y);
      }
    })

    this.dataService.getAllCarParking();

    makeCarMarkers(49.4874592, 8.4660395);


    function makeCarMarkers(lat: number, lon: number) {
      L.marker([lat, lon]).addTo(carParkingLots);
    }

    this.map.addLayer(carParkingLots);

    this.map.addEventListener("click",function(e){

      this.observerService.changeVisibility(false);

    }.bind(this));
  }

  ngOnInit(): void {
    this.initMap();
    this.innerWidth = window.innerWidth;
    this.updateHeight();
    this.updateWidth();
    this.updateMobileDesktopMap();
  }

  maximizeMap(): void {
    if(this.minimized) {
      this.mapContainerClass = "map-container-large";
      this.resizeButtonClass = "resize-button-max shadow";

      this.minimized = false;
      this.updateHeight()
      this.updateWidth();
    }
    
  }

  minimizeMap(): void {
    if(!this.minimized) {
      this.minimized = true;
      this.updateMobileDesktopMap();
      this.resizeButtonClass = "resize-button-min";
      this.updateHeight()
      this.updateWidth();
    }
    this.map.invalidateSize();
  }

  resizeMap(): void {
    if (this.minimized) {
      this.maximizeMap();
    } else {
      this.minimizeMap();
    }
    this.map.invalidateSize();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = event.target.innerWidth;
    this.updateHeight();
    this.updateWidth();
    this.updateMobileDesktopMap();
    
  }

  private updateMobileDesktopMap(){
    if((this.innerWidth < this.breakPoint) && this.minimized) {
      this.mapContainerClass = "map-container-small-mobile";
    } else if(this.minimized) {
      this.mapContainerClass = "map-container-small-desktop";
    }
  }

  private updateHeight() {
    this.computeMaxHeight();
    document.getElementById("map-container").style.height = this.mapHeight; 
  }
  private updateWidth(){
    this.windowWidth = window.innerWidth
  }

  private computeMaxHeight() {
    this.windowHeight = window.innerHeight;
    this.topBarHeight = document.getElementById("top-bar").offsetHeight;
    if (this.minimized) {
      if(this.innerWidth < this.breakPoint){
        this.mapHeight = "5em";
      }
      else{
        this.mapHeight = "10em";
      }
      
    }
    else {
      this.mapHeight = (this.windowHeight - this.topBarHeight).toString() + "px";
    }
  }
}

