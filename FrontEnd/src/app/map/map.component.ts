import { Component, OnInit, Renderer2, HostListener} from '@angular/core';
import * as L from 'leaflet';
import { MapDetailsObserverService } from "../services/map-details-observer.service";
import { MapService } from '../services/map.service';


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

  @HostListener('window:resize', ['$event'])
  onResize(event: { target: { innerWidth: number; }; }) {
    this.mapService.innerWidth = event.target.innerWidth;
    this.mapService.updateHeight();
    this.mapService.updateWidth();
    this.mapService.updateMobileDesktopMap();

  }
}
