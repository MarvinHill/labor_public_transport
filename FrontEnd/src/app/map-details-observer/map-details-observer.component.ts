import { Component } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import { ShuttleLine } from '../ShuttleLine';
import { ParkingLot } from '../ParkingLot';
import { RnvLine } from '../RnvLine';

@Component({
  selector: 'app-map-details-observer',
  templateUrl: './map-details-observer.component.html',
  styleUrls: ['./map-details-observer.component.css']
})
export class MapDetailsObserverComponent {

  state : number = 0; // 0 Nothing, 1 Parking, 2 RNV, 3 Shuttle Line
  data = null;

  constructor(private service : DataServiceService){}

  openMaps(){
    this.service.openMapExternal('Asperg', 'Ludwigsburg');
  }

  changeDisplay(data){
    switch(data.constructor){
    case(ShuttleLine): this.state = 3; break;
    case(RnvLine): this.state = 2; break;
    case(ParkingLot): this.state = 1; break;
    default: this.state = 0; break;
    }
    this.data = data;
  }

  hide(){
    
  }

}
