import { NgStyle } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import {ParkingLot} from "../ParkingLot";
import {ParkingType} from "../ParkingType";
import {ParkingCapacity} from "../ParkingCapacity";
import {MapService} from "../services/map.service";
import {DataServiceService} from "../services/data-service.service";
import {LatLng} from "leaflet";

@Component({
  selector: 'app-parkingItemCapacity',
  templateUrl: './parking-item-capacity.component.html',
  styleUrls: ['./parking-item-capacity.component.css']
})
export class ParkingItemCapacityComponent implements OnInit {
  carParkingLots: ParkingLot[];
  bikeParkingLots: ParkingLot[];
  parkingCapacity: ParkingCapacity[];
  items: number[];

  ngOnInit(): void {

    this.parkingName = this.parking.name;
    this.parkingID = this.parking.id;
    this.parkingAddress = this.parking.address;


    this.dataService.parkingCapacity.subscribe(value=> {
      this.parkingCapacity = value;
    })
    this.dataService.getAllParkingCapacity();

    this.calculateCapacity();
  }

  @Input() parking: ParkingLot;
  parkingName: String = "NAME";
  parkingID: number;
  parkingAddress: String = "ADDRESS";

  protected readonly ParkingType = ParkingType;

  //auslastungen: number[] = [50, 100, 75, 25, 25, 75, 50, 100, 9, 11, 10];
  auslastungen: number[] = [];

  constructor(private mapService : MapService, private dataService : DataServiceService){}

  panToParkingLot(){
    this.mapService.openAndFlyTo(new LatLng(this.parking.geoLocation.x, this.parking.geoLocation.y));
  }

  calculateCapacity() {

  }
}
