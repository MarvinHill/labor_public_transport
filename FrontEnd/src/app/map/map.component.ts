import { Component, ElementRef, HostListener, OnInit, Renderer2, ViewChild } from '@angular/core';
import * as L from 'leaflet';
import { UserLoginServiceService } from "../services/user-login-service.service";
import { DataServiceService } from "../services/data-service.service";
import { MapDetailsObserverService } from "../services/map-details-observer.service";
import { ParkingLot } from '../ParkingLot';
import { ThisReceiver, verifyHostBindings } from '@angular/compiler';
import {Point} from "leaflet";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  private map: L.Map;
  private centroid: L.LatLngExpression = [49.485, 8.5];

  protected minimized: boolean = true;

  mapContainerClass: string = "map-container-small-desktop";
  resizeButtonClass: string = "resize-button-min";
  private userService: UserLoginServiceService;
  private renderer: Renderer2;

  protected isLoggedIn: boolean = true;
  protected mapHeight: string = "10em";

  carParkingLots = new L.LayerGroup;

  @ViewChild('container', { static: false }) container: ElementRef;

  windowHeight: number;
  windowWidth: number;
  topBarHeight: number;
  public innerWidth: number = 1000;
  breakPoint: number = 720;


  constructor(userService: UserLoginServiceService, renderer: Renderer2, private dataService: DataServiceService, protected observerService: MapDetailsObserverService) {
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

    this.dataService.carParking.subscribe(values => {
      values.forEach(element => {
        this.makeCarMarkers(element);
      });
    })

    this.dataService.carParking.subscribe(values => {
      values.forEach(element => {
        this.makeCarPolygons(element.area);
      });
    })

    this.dataService.carParking.subscribe(values => {
      values.forEach(element => {
        this.makeCarParkingEntries(element.entrances);
      });
    })

    this.dataService.getAllCarParking();


    this.map.addLayer(this.carParkingLots);

    this.map.addEventListener("click", function (e: any) {

      this.observerService.changeVisibility(false);

    }.bind(this));

  }

  makeCarMarkers(parkingLot) {
    var marker = L.marker([parkingLot.geoLocation.x, parkingLot.geoLocation.y]);
    marker.on("click", function (e: any) {
      this.observerService.changeDisplay(parkingLot)
    }.bind(this));
    marker.addTo(this.carParkingLots);
  };

  makeCarPolygons(area: Array<Point>) {
    var arr = [];
    for(var i = 0; i < area.length; i++) {
      arr.push([area.at(i).x, area.at(i).y]);
    }
    L.polygon(arr, {color: 'blue'}).addTo(this.carParkingLots);
  }

  makeCarParkingEntries(entrances: Array<Point>) {
    var arr = [];
    for(var i = 0; i < 1; i++) {
      arr.push([[entrances.at(i).x, entrances.at(i).y]]);
    }
    for(var i = 0; i < arr.length; i++) {
      L.marker(arr.pop());
    }
  }

  ngOnInit(): void {
    this.initMap();
    this.innerWidth = window.innerWidth;
    this.updateHeight();
    this.updateWidth();
    this.updateMobileDesktopMap();
  }

  maximizeMap(): void {
    if (this.minimized) {
      this.mapContainerClass = "map-container-large";
      this.resizeButtonClass = "resize-button-max shadow";

      this.minimized = false;
      this.updateHeight()
      this.updateWidth();
    }
    this.map.invalidateSize();

  }

  minimizeMap(): void {
    if (!this.minimized) {
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
  onResize(event: { target: { innerWidth: number; }; }) {
    this.innerWidth = event.target.innerWidth;
    this.updateHeight();
    this.updateWidth();
    this.updateMobileDesktopMap();

  }

  private updateMobileDesktopMap() {
    if ((this.innerWidth < this.breakPoint) && this.minimized) {
      this.mapContainerClass = "map-container-small-mobile";
    } else if (this.minimized) {
      this.mapContainerClass = "map-container-small-desktop";
    }
  }

  private updateHeight() {
    this.computeMaxHeight();
    document.getElementById("map-container").style.height = this.mapHeight;
  }
  private updateWidth() {
    this.windowWidth = window.innerWidth
  }

  private computeMaxHeight() {
    this.windowHeight = window.innerHeight;
    this.topBarHeight = document.getElementById("top-bar").offsetHeight;
    if (this.minimized) {
      if (this.innerWidth < this.breakPoint) {
        this.mapHeight = "5em";
      }
      else {
        this.mapHeight = "10em";
      }
    }
    else {
      this.mapHeight = (this.windowHeight - this.topBarHeight).toString() + "px";
    }
  }
}
