import { Component, ElementRef, HostListener, OnInit, Renderer2, ViewChild } from '@angular/core';
import * as L from 'leaflet';
import { UserLoginServiceService } from "../services/user-login-service.service";
import { DataServiceService } from "../services/data-service.service";
import { MapDetailsObserverService } from "../services/map-details-observer.service";
import { ParkingLot } from '../ParkingLot';
import { ThisReceiver, verifyHostBindings } from '@angular/compiler';
import {Point} from "leaflet";
import { MapService } from '../map.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit{
  constructor(protected mapService : MapService, protected observerService : MapDetailsObserverService,  protected renderer: Renderer2,){}
  ngOnInit(): void {
     var map : L.Map = L.map('map', {
      center: this.mapService.centroid,
      zoom: 15,
      zoomControl: false
    });
 
    this.mapService.init(map);
  }
}
