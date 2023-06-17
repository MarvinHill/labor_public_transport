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

  async ngOnInit(): Promise<void> {
    this.parkingName = this.parking.name;
    this.parkingID = this.parking.id;
    this.parkingAddress = this.parking.address;
    this.screenWidth = window.innerWidth;
    this.totalParkingspaces = this.parking.maxCapacity;

    await this.fetchParkingCapacity();

    this.calculateCapacity();
  }

  async fetchParkingCapacity(): Promise<void> {
    return new Promise<void>((resolve) => {
      this.dataService.parkingCapacity.subscribe(value => {
        this.parkingCapacityAll = value;
        resolve();
      });
      this.dataService.getAllParkingCapacity();
    });
  }

  @Input() parking: ParkingLot;
  parkingName: String = "NAME";
  parkingID: number;
  parkingAddress: String = "ADDRESS";

  protected readonly ParkingType = ParkingType;

  auslastungen: number[] = [];

  constructor(private mapService : MapService, private dataService : DataServiceService, private observerService : MapDetailsObserverService){
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
    if((this.totalParkingspaces != 0)) {
      this.parkingCapacityAll.forEach(parkingCapacity => {
        if(parkingCapacity.name.includes(this.parkingName.replace(/\s/g, "").split(',')[0])) {
          this.parkingCapacityThis.push(parkingCapacity);
        }
      })

      var capacitySameDayHour1: ParkingCapacity[] = [];
      var capacitySameDayHour2: ParkingCapacity[] = [];
      var capacitySameDayHour3: ParkingCapacity[] = [];
      var capacitySameDayHour4: ParkingCapacity[] = [];
      var capacitySameDayHour5: ParkingCapacity[] = [];
      var capacitySameDayHour6: ParkingCapacity[] = [];

      console.log(this.parkingCapacityThis)

      this.parkingCapacityThis.forEach(parkingCapacity => {

        console.log(parkingCapacity)

        const dbString: string = parkingCapacity.dateTime.toString();
        const dbDateTime = new Date(Date.parse(dbString));
        const currentDateTime = new Date();

        if((dbDateTime.getFullYear() === currentDateTime.getFullYear()) && (dbDateTime.getMonth() === currentDateTime.getMonth()) && (dbDateTime.getDate() === currentDateTime.getDate())) {
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

        if(this.parseWeekday(parkingCapacity.weekday) === currentDateTime.getDay()) {
          if(dbDateTime.getHours() === currentDateTime.getHours() +1) {
            capacitySameDayHour1.push(parkingCapacity);
          }
          if(dbDateTime.getHours() === currentDateTime.getHours() +2) {
            capacitySameDayHour2.push(parkingCapacity);
          }
          if(dbDateTime.getHours() === currentDateTime.getHours() +3) {
            capacitySameDayHour3.push(parkingCapacity);
          }
          if(dbDateTime.getHours() === currentDateTime.getHours() +4) {
            capacitySameDayHour4.push(parkingCapacity);
          }
          if(dbDateTime.getHours() === currentDateTime.getHours() +5) {
            capacitySameDayHour5.push(parkingCapacity);
          }
          if(dbDateTime.getHours() === currentDateTime.getHours() +6) {
            capacitySameDayHour6.push(parkingCapacity);
          }
        }
      })
      this.auslastungen[4] = this.calculatePercentage(this.calculateMedian(capacitySameDayHour1));
      this.auslastungen[5] = this.calculatePercentage(this.calculateMedian(capacitySameDayHour2));
      this.auslastungen[6] = this.calculatePercentage(this.calculateMedian(capacitySameDayHour3));
      this.auslastungen[7] = this.calculatePercentage(this.calculateMedian(capacitySameDayHour4));
      this.auslastungen[8] = this.calculatePercentage(this.calculateMedian(capacitySameDayHour5));
      this.auslastungen[9] = this.calculatePercentage(this.calculateMedian(capacitySameDayHour6));
    }
  }

  calculatePercentage(currentFreeSpaces: number) {
    return (this.totalParkingspaces - currentFreeSpaces) / (this.totalParkingspaces / 100);
  }

  parseWeekday(dbEntryDay: String): number {
    switch(dbEntryDay) {
      case 'SUNDAY': return 0;
      case 'MONDAY': return 1;
      case 'TUESDAY': return 2;
      case 'WEDNESDAY': return 3;
      case 'THURSDAY': return 4;
      case 'FRIDAY': return 5;
      case 'SATURDAY': return 6;
      default: return 0;
    }
  }

  calculateMedian(arrayOfCapacities: ParkingCapacity[]): number {
    const sortedArray: ParkingCapacity[] = arrayOfCapacities.sort((a, b) => a.freeParkingspaces - b.freeParkingspaces);
    if(arrayOfCapacities.length % 2 === 1) {
      return sortedArray[Math.floor(arrayOfCapacities.length / 2)].freeParkingspaces;
    } else {
      return ((sortedArray[arrayOfCapacities.length / 2].freeParkingspaces) +
        (sortedArray[(arrayOfCapacities.length / 2) -1].freeParkingspaces)) / 2;
    }
  }
}
