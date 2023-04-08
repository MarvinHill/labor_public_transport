import { Component } from '@angular/core';

@Component({
  selector: 'app-map-details-observer',
  templateUrl: './map-details-observer.component.html',
  styleUrls: ['./map-details-observer.component.css']
})
export class MapDetailsObserverComponent {

  state : number = 0; // 0 Nothing, 1 Parking, 2 RNV

}
