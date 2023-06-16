import { NgStyle } from '@angular/common';
import {Component, HostListener, Input, OnInit} from '@angular/core';
import {ParkingLot} from "../ParkingLot";
import {ParkingType} from "../ParkingType";
import {ParkingCapacity} from "../ParkingCapacity";
import {MapService} from "../services/map.service";
import {DataServiceService} from "../services/data-service.service";
import {LatLng} from "leaflet";
import { MapDetailsObserverService } from '../services/map-details-observer.service';

@Component({
  selector: 'app-parkingItemCapacity',
  templateUrl: './parking-item-capacity.component.html',
  styleUrls: ['./parking-item-capacity.component.css']
})
export class ParkingItemCapacityComponent implements OnInit {
  carParkingLots: ParkingLot[];
  bikeParkingLots: ParkingLot[];
  parkingCapacityAll: ParkingCapacity[];
  parkingCapacityThis: ParkingCapacity[];
  items: number[];
  totalParkingspaces: number;

  public screenWidth: any;

  ngOnInit(): void {
    this.parkingName = this.parking.name;
    this.parkingID = this.parking.id;
    this.parkingAddress = this.parking.address;
    this.screenWidth = window.innerWidth;
    this.totalParkingspaces = this.parking.maxCapacity;

    this.calculateCapacity();
  }

  @Input() parking: ParkingLot;
  parkingName: String = "NAME";
  parkingID: number;
  parkingAddress: String = "ADDRESS";

  protected readonly ParkingType = ParkingType;

  auslastungen: number[] = [];

  constructor(private mapService : MapService, private dataService : DataServiceService){
    this.dataService.parkingCapacity.subscribe(value=> {
      this.parkingCapacityAll = value;
    })
    this.dataService.getAllParkingCapacity();

    this.parkingCapacityThis = [];
  }

  panToParkingLot(){
    this.observerService.changeDisplay(this.parking);
    this.mapService.openAndFlyTo(new LatLng(this.parking.geoLocation.x, this.parking.geoLocation.y));
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: { target: { innerWidth: number; }; }) {
    this.screenWidth = window.innerWidth;
    console.log(this.screenWidth);
  }

  calculateCapacity() {
    if(this.totalParkingspaces != 0) {
      this.parkingCapacityAll.forEach(parkingCapacity => {
        if(parkingCapacity.name.includes(this.parkingName.replace(/\s/g, "").split(',')[0].concat(','))) {
          this.parkingCapacityThis.push(parkingCapacity);
        }
      })

      this.parkingCapacityThis.forEach(parkingCapacity => {
        const dbString: string = parkingCapacity.dateTime.toString();
        const dbDateTime = new Date(Date.parse(dbString));
        const currentDateTime = new Date();

        if((dbDateTime.getFullYear() === currentDateTime.getFullYear()) && (dbDateTime.getMonth() === currentDateTime.getMonth())
         && (dbDateTime.getDate() === currentDateTime.getDate())) {
          if(dbDateTime.getHours() === currentDateTime.getHours() -3) {
            this.auslastungen[0] = this.calculatePercentage(parkingCapacity.freeParkingspaces);
          }
          if(dbDateTime.getHours() === currentDateTime.getHours() -2) {
            this.auslastungen[1] = this.calculatePercentage(parkingCapacity.freeParkingspaces);
          }
          if(dbDateTime.getHours() === currentDateTime.getHours() -1) {
            this.auslastungen[2] = this.calculatePercentage(parkingCapacity.freeParkingspaces);
          }
          if(dbDateTime.getHours() === currentDateTime.getHours()) {
            this.auslastungen[3] = this.calculatePercentage(parkingCapacity.freeParkingspaces);
          }
        }
      })
    }
  }

  calculatePercentage(currentFreeSpaces: number) {
    return (this.totalParkingspaces - currentFreeSpaces) / (this.totalParkingspaces / 100);
  }
}
