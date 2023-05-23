import { Component, Input, OnInit } from '@angular/core';
import {ParkingLot} from "../ParkingLot";
import { DataServiceService } from '../services/data-service.service';
import { MapService } from '../services/map.service';
import { LatLng } from 'leaflet';

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
    this.carParkingAddress = this.carParking.address;
  }

  @Input() carParking: ParkingLot;
  carParkingName: String = "NAME";
  parkID: number;
  carParkingAddress: String = "ADDRESS";

  constructor(private mapService : MapService){}

  panToParkingLot(){
      this.mapService.openAndFlyTo(new LatLng(this.carParking.geoLocation.x, this.carParking.geoLocation.y));
  }

}
