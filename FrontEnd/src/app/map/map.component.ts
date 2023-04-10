import { Component, ElementRef, HostListener, OnInit, Renderer2, ViewChild } from '@angular/core';
import * as L from 'leaflet';
import { UserLoginServiceService } from '../user-login-service.service';
import { ShuttleLine } from '../ShuttleLine';

import { LineScheduleEntry } from '../LineScheduleEntry';
import { ShuttleLineService } from '../services/shuttle-line.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  shuttleLines: ShuttleLine[];

  private map: L.Map;
  private layerGroupMarkers: L.LayerGroup = new L.LayerGroup();
  private centroid: L.LatLngExpression = [49.485, 8.5];

  protected minimized: boolean = true;

  private userService: UserLoginServiceService;
  private renderer: Renderer2;

  protected isLoggedIn: boolean = true;
  protected mapHeight: string = "10em";


  @ViewChild('container', { static: false }) container: ElementRef;
  windowHeight: number = 0;
  topBarHeight: number = 0;
  windowWidth: number = 0;


  constructor(
    private shuttleLineService: ShuttleLineService,
    userService: UserLoginServiceService,
    renderer: Renderer2
  ) {
    this.shuttleLineService = shuttleLineService;
    this.userService = userService;
    this.userService.isLoggedIn.subscribe(value => {
      this.isLoggedIn = value;
    });
    this.renderer = renderer;
  }

  public getMap(): L.Map {
    return this.map;
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
    this.layerGroupMarkers.addTo(this.map);
  }

  ngOnInit(): void {
    this.initMap();
    this.initShuttleLineViewOnMap();
    this.updateHeight();
    this.updateWidth();
  }

  private initShuttleLineViewOnMap() {
    this.shuttleLineService.getShuttleLines().subscribe(
      lines => {
        this.shuttleLines = lines;
        this.shuttleLines.forEach(line => {
          line.lineScheduleEntryList.forEach(entry => {
            this.addMarkerToMap(entry);
          });
        });
      }
    );
  }

  private addMarkerToMap(entry: LineScheduleEntry) {
    var customIcon = L.icon({
      iconUrl: 'assets/image/ShuttleLineEntry.png',
      iconSize: [30, 30], // size of the icon
      shadowSize: [50, 64], // size of the shadow
      iconAnchor: [15, 30], // point of the icon which will correspond to marker's location
      shadowAnchor: [4, 62],  // the same for the shadow
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });

    let marker = new L.Marker(
      [entry.geoLocation.y, entry.geoLocation.x],
      { icon: customIcon }
    );

    marker.bindPopup("<b>Hello world!</b><br>I am a popup.").openPopup();
    marker.addTo(this.layerGroupMarkers);

    marker.addTo(this.map);
  }


  maximizeMap(): void {
    if (this.minimized) {
      document.getElementById("map-container").className = "map-container-large";
      this.minimized = false;
    }
    this.updateHeight()
  }

  minimizeMap(): void {
    if (!this.minimized) {
      document.getElementById("map-container").className = "map-container-small";
      this.minimized = true;
      this.updateHeight()
    }
  }

  resizeMap(): void {
    if (this.minimized) {
      this.maximizeMap();
    } else {
      this.minimizeMap();
    }
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.updateHeight();
    this.updateWidth();
  }

  private updateHeight() {
    this.computeMaxHeight();
    document.getElementById("map-container").style.height = this.mapHeight;
    this.map.invalidateSize();
  }
  private updateWidth(){
    this.windowWidth = window.innerWidth
  }

  private computeMaxHeight() {
    this.windowHeight = window.innerHeight;
    this.topBarHeight = document.getElementById("top-bar").offsetHeight;
    if (this.minimized) {
      this.mapHeight = "10em";
    }
    else {
      this.mapHeight = (this.windowHeight - this.topBarHeight).toString() + "px";
    }
  }



}

