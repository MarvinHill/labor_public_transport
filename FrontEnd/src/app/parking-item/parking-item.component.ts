import { Component, Input, OnInit } from '@angular/core';
import {ParkingLot} from "../ParkingLot";

@Component({
  selector: 'app-parkingItem',
  templateUrl: './parking-item.component.html',
  styleUrls: ['./parking-item.component.css']
})
export class ParkingItemComponent implements OnInit {
  carParkingLots: ParkingLot[];
  items: number[];

  ngOnInit(): void {

    this.carParkingName = this.carParking.name;
    this.parkID = this.carParking.id;
  }

  @Input() carParking: ParkingLot;
  carParkingName: String = "NAME";
  parkID: number;

}
