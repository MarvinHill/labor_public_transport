import { Injectable } from '@angular/core';
import { ParkingLot } from '../ParkingLot';
import { RnvLine } from '../RnvLine';
import { ShuttleLine } from '../ShuttleLine';
import { ObserverState } from '../ObserverState';

@Injectable({
  providedIn: 'root'
})
export class MapDetailsObserverService {

  public data = null;
  public visible : boolean = true;
  public show:ObserverState = ObserverState.NOTHING;



  constructor() { }

  changeDisplay(data){
    console.warn(data);
    
    this.changeVisibility(true);
    switch(data.constructor){
      case(ShuttleLine): this.show = ObserverState.SHUTTLE; break;
      case(RnvLine): this.show = ObserverState.RNV; break;
      case(ParkingLot): this.show = ObserverState.PARKING; break;
      default: this.show = ObserverState.NOTHING; break;
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