import { Component, OnInit } from '@angular/core';
import * as L from 'leaflet';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  private map: L.Map;
  private centroid: L.LatLngExpression = [49.485, 8.5];

  private minimized: boolean = false;

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

  resizeMap(): void {
    console.log("test");
    const container = document.getElementById("map-container");
    if(this.minimized) {
      container.className = "map-container-large";

      this.minimized = false;
    } else {
      container.className = "map-container-small";

      this.minimized = true;
    }
  }
}

