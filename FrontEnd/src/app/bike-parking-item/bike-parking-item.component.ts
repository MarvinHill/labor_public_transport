import { Component, Input, OnInit } from '@angular/core';
import {ParkingLot} from "../ParkingLot";
import { LatLng } from 'leaflet';
import { MapService } from '../services/map.service';

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

  constructor(protected mapService : MapService){}

  @Input() bikeParking: ParkingLot;
  bikeParkingName = "NAME";
  parkID: number;
  bikeParkingAddress = "ADDRESS";

  panToBikeParkingLot(){
    this.mapService.openAndFlyTo(new LatLng(this.bikeParking.geoLocation.x, this.bikeParking.geoLocation.y));
}
}
