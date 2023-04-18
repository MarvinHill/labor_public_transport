import { Component, ElementRef, HostListener, OnInit, Renderer2, ViewChild } from '@angular/core';
import * as L from 'leaflet';
import { UserLoginServiceService } from '../user-login-service.service';
import { ShuttleLine } from '../ShuttleLine';
import { ShuttleLineService } from '../services/shuttle-line.service';
import { LineScheduleEntry } from '../LineScheduleEntry';
import { Point } from "leaflet";

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
  windowHeight: number;
  topBarHeight: number;


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
  }

  private initShuttleLineViewOnMap() {
    this.shuttleLineService.getShuttleLines().subscribe(
      lines => {
        console.log(lines);
        this.shuttleLines = lines;
        this.shuttleLines.forEach(line => {
          
          if (line.lineDesignator == "7") {
            this.drawLineToMap(line);
          }
          



          line.lineScheduleEntryList.forEach(entry => {
            this.addMarkerToMap(entry, line);
          });
        });
      }
    );
  }

  private addMarkerToMap(entry: LineScheduleEntry, line: ShuttleLine) {
    var shuttleMarkerIcon = L.icon({
      iconUrl: 'assets/image/shuttle.png',
      iconSize: [60, 60], // size of the icon
      shadowSize: [50, 64], // size of the shadow
      iconAnchor: [30, 60], // point of the icon which will correspond to marker's location
      shadowAnchor: [4, 62],  // the same for the shadow
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });

    var trainMarkerIcon = L.icon({
      iconUrl: 'assets/image/train.png',
      iconSize: [60, 60], // size of the icon
      shadowSize: [50, 64], // size of the shadow
      iconAnchor: [30, 60], // point of the icon which will correspond to marker's location
      shadowAnchor: [4, 62],  // the same for the shadow
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });

    if (line.lineDesignator == "BUGA Shuttlelinie") {
      let marker = new L.Marker(
        [entry.geoLocation.x, entry.geoLocation.y],
        { icon: shuttleMarkerIcon }
      );
  
      marker.bindPopup("<span>" + entry.stationDesignator + "</span>").openPopup();
      marker.addTo(this.layerGroupMarkers);
      marker.addTo(this.map);
    } else {
      let marker = new L.Marker(
        [entry.geoLocation.x, entry.geoLocation.y],
        { icon: trainMarkerIcon }
      );
  
      marker.bindPopup("<span>" + entry.stationDesignator + "</span>").openPopup();
      marker.addTo(this.layerGroupMarkers);
      marker.addTo(this.map);
    }
    
  }
  
  private drawLineToMap(line: ShuttleLine) {
    let fpl = this.tPL(line.geoLinePoints);
    console.log(fpl);
    var polyline = L.polyline(fpl, {color: '#ffee00', weight: 5, opacity: 0.8, smoothFactor: 1}).addTo(this.map);
  }

  private tPL(point: Object[]) {
    var tranformedPolyLine: L.LatLng[] = [];
    for(let i = 0; i < point.length; i++) {
      // @ts-ignore
      tranformedPolyLine.push(new L.LatLng(point[i].y, point[i].x));
    }
    return tranformedPolyLine;
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
  }

  private updateHeight() {
    this.computeMaxHeight();
    document.getElementById("map-container").style.height = this.mapHeight;
    this.map.invalidateSize();
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

