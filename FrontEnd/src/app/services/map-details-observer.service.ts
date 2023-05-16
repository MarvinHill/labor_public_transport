import { Injectable } from '@angular/core';
import { ParkingLot } from '../ParkingLot';
import { ShuttleLine } from '../ShuttleLine';
import { ObserverState } from '../ObserverState';
import { RnvLine } from '../RnvLine';

@Injectable({
  providedIn: 'root'
})
export class MapDetailsObserverService {

  public data = null ;
  public visible : boolean = true;
  public show:ObserverState = ObserverState.NOTHING;



  constructor() { }

  changeDisplay(data){

    if("parkingType" in data){
      this.show = ObserverState.PARKING;
      this.data = <ParkingLot> data;
      this.changeVisibility(true);
      return;
    }
    if("lineDesignator" in data){
      this.show = ObserverState.SHUTTLE;
      this.data = <ShuttleLine> data;
      this.changeVisibility(true);
      return;
    }
    else{
      this.changeVisibility(false);
      this.show = ObserverState.NOTHING;
      return;
    }
  }

  changeVisibility(visibility : boolean){
        this.visible = visibility;
  }

  flipVisibility(){
    this.visible = !this.visible;
  }
}
