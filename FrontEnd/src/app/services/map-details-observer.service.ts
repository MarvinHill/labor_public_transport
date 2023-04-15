import { Injectable } from '@angular/core';
import { ParkingLot } from '../ParkingLot';
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
    }
    else{
      this.show = ObserverState.NOTHING;
    }


    this.changeVisibility(true);

  }

  isParkingLot = (object : Object): object is ParkingLot => {
  return true;
 }

  changeVisibility(visibility : boolean){
        this.visible = visibility;
  }

  flipVisibility(){
    this.visible = !this.visible;
  }
}