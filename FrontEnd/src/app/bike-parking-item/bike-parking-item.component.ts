import { Component, Input, OnInit } from '@angular/core';
import {ParkingLot} from "../ParkingLot";

@Component({
  selector: 'app-bike-parking-item',
  templateUrl: './bike-parking-item.component.html',
  styleUrls: ['./bike-parking-item.component.css']
})
export class BikeParkingItemComponent implements OnInit {
  bikeParkingLots: ParkingLot[];
  items: number[];

  ngOnInit(): void {

    this.bikeParkingName = this.bikeParking.name;
    // this.parkID = this.bikeParking.id;
    this.bikeParkingAddress = this.bikeParking.address;
  }

  @Input() bikeParking: ParkingLot;
  bikeParkingName: String = "NAME";
  parkID: number;
  bikeParkingAddress: String = "ADDRESS";

}
