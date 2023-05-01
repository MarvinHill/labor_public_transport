import { Component, Input, OnInit } from '@angular/core';
import {ParkingLot} from "../ParkingLot";
import { DataServiceService } from '../services/data-service.service';

@Component({
  selector: 'app-parkingItem',
  templateUrl: './parking-item.component.html',
  styleUrls: ['./parking-item.component.css']
})
export class ParkingItemComponent {

  @Input() carParking: ParkingLot;

}
