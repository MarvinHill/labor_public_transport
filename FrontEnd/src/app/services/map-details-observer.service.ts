import { Injectable } from '@angular/core';
import { ParkingLot } from '../ParkingLot';
import { RnvLine } from '../RnvLine';
import { ShuttleLine } from '../ShuttleLine';

@Injectable({
  providedIn: 'root'
})
export class MapDetailsObserverService {

  state : number = 0; // 0 Nothing, 1 Parking, 2 RNV, 3 Shuttle Line
  data = null;
  visible : boolean = true;

  constructor() { }

  changeDisplay(data){
    switch(data.constructor){
    case(ShuttleLine): this.state = 3; break;
    case(RnvLine): this.state = 2; break;
    case(ParkingLot): this.state = 1; break;
    default: this.state = 0; break;
    }
    this.data = data;
  }

  changeVisibility(visibility : boolean){
        this.visible = visibility;
  }

  flipVisibility(){
    this.visible = !this.visible;
  }
}
