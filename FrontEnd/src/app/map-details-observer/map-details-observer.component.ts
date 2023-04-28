import { Component } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { ParkingLot } from '../ParkingLot';
import { RnvLine } from '../RnvLine';
import { MapDetailsObserverService } from '../services/map-details-observer.service';
import { DataServiceService } from '../services/data-service.service';
import { ObserverState } from '../ObserverState';

@Component({
  selector: 'app-map-details-observer',
  templateUrl: './map-details-observer.component.html',
  styleUrls: ['./map-details-observer.component.css']
})
export class MapDetailsObserverComponent {
  protected ObserverState = ObserverState;

  constructor(protected service : DataServiceService, protected observerService : MapDetailsObserverService){}

  openMaps(){
 
    this.service.openMapExternalWithDestPosition(this.observerService?.data.geoLocation.x, this.observerService?.data.geoLocation.y);
  }

}
