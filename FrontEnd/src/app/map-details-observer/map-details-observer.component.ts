import { Component } from '@angular/core';
import { DataServiceService } from '../data-service.service';

@Component({
  selector: 'app-map-details-observer',
  templateUrl: './map-details-observer.component.html',
  styleUrls: ['./map-details-observer.component.css']
})
export class MapDetailsObserverComponent {

  state : number = 1; // 0 Nothing, 1 Parking, 2 RNV

  constructor(private service : DataServiceService){}

  openMaps(){
    this.service.openMapExternal('Asperg', 'Ludwigsburg');
  }

}
