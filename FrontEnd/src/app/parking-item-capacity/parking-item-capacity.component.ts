import { NgStyle } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import {ParkingLot} from "../ParkingLot";
import {ParkingType} from "../ParkingType";

@Component({
  selector: 'app-parkingItemCapacity',
  templateUrl: './parking-item-capacity.component.html',
  styleUrls: ['./parking-item-capacity.component.css']
})
export class ParkingItemCapacityComponent implements OnInit {
  carParkingLots: ParkingLot[];
  bikeParkingLots: ParkingLot[];
  items: number[];

  ngOnInit(): void {

    this.parkingName = this.parking.name;
    this.parkingID = this.parking.id;
    this.parkingAddress = this.parking.address;

  }

  @Input() parking: ParkingLot;
  parkingName: String = "NAME";
  parkingID: number;
  parkingAddress: String = "ADDRESS";

  protected readonly ParkingType = ParkingType;

  // auslastungen: number[] = [50, 100, 75, 25, 25, 75, 50, 100, 9, 11, 10];
  auslastungen: number[] = [];

}
