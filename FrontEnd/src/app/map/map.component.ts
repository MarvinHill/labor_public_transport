import {Component, HostListener, OnInit, TemplateRef} from '@angular/core';
import * as L from 'leaflet';
import {NgIfContext} from "@angular/common";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  private map: L.Map;
  private centroid: L.LatLngExpression = [49.485, 8.5];

  private minimized: boolean = true;

  mapContainerClass:string = "map-container-small-desktop";

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
      this.mapContainerClass = "map-container-large";

      this.minimized = false;
    }
  }

  minimizeMap(): void {
    if(!this.minimized) {
      if (this.innerWidth < 992) {
        this.mapContainerClass = "map-container-small-mobile";
      } else {
        this.mapContainerClass = "map-container-small-desktop";
      }
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

  public innerWidth: number = 500;
  desktop: TemplateRef<NgIfContext<boolean>>;
  mobile: TemplateRef<NgIfContext<boolean>>;

  ngAfterViewInit() {
    this.innerWidth = window.innerWidth;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = event.target.innerWidth;
  }
}

