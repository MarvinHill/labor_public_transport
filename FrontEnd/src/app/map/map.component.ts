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
  resizeButtonClass: string = "button-min";
  locateButtonClass: string = "button-min";

  private userService: UserLoginServiceService;
  private renderer: Renderer2;

  protected isLoggedIn: boolean = true;
  protected mapHeight: string = "10em";

  userLocation = new L.LayerGroup;
  carParkingLots = new L.LayerGroup;
  carParkingLotEntrances = new L.LayerGroup;
  bikeParkingLots = new L.LayerGroup;
  layerOptions : L.Control.LayersOptions = {
    position : "bottomright",
  }
  layerControl = L.control.layers(null, null, this.layerOptions);



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

  makeLayerControls(){
    this.layerControl.addOverlay(this.userLocation, "Position");
    this.layerControl.addOverlay(this.carParkingLots, "Autoparkplätze");
    this.layerControl.addOverlay(this.bikeParkingLots, "Fahrradparkplätze");
    this.layerControl.addTo(this.map);
  }

  private initMap(): void {
    this.map = L.map('map', {
      center: this.centroid,
      zoom: 15,
      zoomControl: false
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 10,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);

    this.locateUser();

    this.makeLayerControls();
    

    this.dataService.carParking.subscribe(values => {

      values.forEach(element => {
        this.makeCarParking(element);
      });
    })
    this.dataService.bikeParking.subscribe(values => {

      values.forEach(element => {
        this.makeBikeParking(element);
      });
    })

    this.dataService.getAllCarParking();

    this.dataService.getAllBikeParking();

    this.map.addLayer(this.userLocation);

    this.map.addLayer(this.carParkingLots);

    this.map.addLayer(this.bikeParkingLots);

    this.map.addEventListener("click", function (e: any) {
      this.observerService.changeVisibility(false);
    }.bind(this));

  }

  makeCarParking(parkinglot: ParkingLot) {
    var parkingIcon = L.icon({
      iconUrl: 'assets/icon/parking/MarkerCar.png',
      iconSize:     [45, 72], // size of the icon
      iconAnchor:   [22.5, 70], // point of the icon which will correspond to marker's location
      popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
    });
    if(parkinglot.charging === true){
      parkingIcon = L.icon({
        iconUrl: 'assets/icon/parking/MarkerECar.png',
        iconSize:     [45, 72], // size of the icon
        iconAnchor:   [22.5, 70], // point of the icon which will correspond to marker's location
        popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
      });
    }
    if(parkinglot.area.length > 0) {
      var arr = [];
      for (var i = 0; i < parkinglot.area.length; i++) {
        arr.push([parkinglot.area.at(i).x, parkinglot.area.at(i).y]);
      }
      var poly = L.polygon(arr, {color: '#0677e0'}).addTo(this.carParkingLots);
      var marker = L.marker(poly.getCenter(), {icon:parkingIcon});
    }
    else {
      var marker = L.marker([parkinglot.geoLocation.x, parkinglot.geoLocation.y], {icon:parkingIcon});
    }

    marker.on("click", function (e: any) {
      this.observerService.changeDisplay(parkinglot)
    }.bind(this));
    marker.addTo(this.carParkingLots);

    var entranceIcon = L.icon({
      iconUrl: 'assets/icon/parking/Entrance.png',
      iconSize:     [15, 15], // size of the icon
      iconAnchor:   [7.5, 7.5], // point of the icon which will correspond to marker's location
      popupAnchor:  [7.5, 15] // point from which the popup should open relative to the iconAnchor
    });

    if(parkinglot.entrance.length > 0) {
      for (var i = 0; i < parkinglot.entrance.length; i++) {
        L.marker([parkinglot.entrance.at(i).x, parkinglot.entrance.at(i).y], {icon: entranceIcon}).addTo(this.carParkingLotEntrances);
      }
    }

    this.map.on("zoomend", function(e){
      if(this.map.getZoom() < 16 ){
        this.carParkingLotEntrances.remove();
      }
      else{
        if(this.map.hasLayer(this.carParkingLots)){
          this.carParkingLotEntrances.addTo(this.map);
        }
      }
    }.bind(this));
  }

  makeBikeParking(bikeparking: ParkingLot) {
    var parkingIcon = L.icon({
      iconUrl: 'assets/icon/parking/MarkerBike.png',
      iconSize:     [45, 72], // size of the icon
      iconAnchor:   [22.5, 70], // point of the icon which will correspond to marker's location
      popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
    });
    if(bikeparking.area.length > 0) {
      var arr = [];
      for(var i = 0; i < bikeparking.area.length; i++) {
        arr.push([bikeparking.area.at(i).x, bikeparking.area.at(i).y]);
      }
      var poly = L.polygon(arr, {color: '#0677e0'}).addTo(this.bikeParkingLots);
      var marker = L.marker(poly.getCenter(), {icon : parkingIcon}).addTo(this.bikeParkingLots);
    }
    else {
      var marker = L.marker([bikeparking.geoLocation.x, bikeparking.geoLocation.y], {icon: parkingIcon}).addTo(this.bikeParkingLots);
    }
    marker.on("click", function (e: any) {
      this.observerService.changeDisplay(bikeparking)
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
    if (this.minimized) {
      this.mapContainerClass = "map-container-large shadow";
      this.resizeButtonClass = "resize-button-max shadow";
      this.locateButtonClass = "locate-button-max shadow";

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
      this.resizeButtonClass = "button-min";
      this.locateButtonClass = "button-min";
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
      this.mapContainerClass = "map-container-small-mobile shadow";
    } else if (this.minimized) {
      this.mapContainerClass = "map-container-small-desktop shadow";
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

  locateUser() : any {
    const userLocationGroup = this.userLocation;
    this.map.locate({setView: true}).on('locationfound', function(e) {

      var locationIcon = L.icon({
        iconUrl: 'assets/icon/wavingPerson.gif',
        iconSize:     [60, 72], // size of the icon
        iconAnchor:   [22.5, 70], // point of the icon which will correspond to marker's location
        popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
      });

      const location = e.latlng;

      userLocationGroup.clearLayers();
      var marker = L.marker(location, {icon: locationIcon}).addTo(userLocationGroup);
       marker.on("click", function(e) {
         marker.bindPopup("You are Here!").openPopup();
       })
    });
    this.userLocation = userLocationGroup;
  }
}
