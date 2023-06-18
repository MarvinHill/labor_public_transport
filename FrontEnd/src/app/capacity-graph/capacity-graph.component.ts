import {Component, Input, OnInit} from '@angular/core';
import {ParkingCapacity} from "../ParkingCapacity";
import {ParkingLot} from "../ParkingLot";
import {MapService} from "../services/map.service";
import {DataServiceService} from "../services/data-service.service";

@Component({
  selector: 'app-capacity-graph',
  templateUrl: './capacity-graph.component.html',
  styleUrls: ['./capacity-graph.component.css']
})
export class CapacityGraphComponent implements OnInit{
  carParkingLots: ParkingLot[];
  bikeParkingLots: ParkingLot[];
  parkingCapacityAll: ParkingCapacity[];
  parkingCapacityThis: ParkingCapacity[];
  items: number[];
  totalParkingspaces: number;
  currentDateTime = new Date();


  async ngOnInit(): Promise<void> {
    this.parkingName = this.parking.name;
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

  auslastungen: number[] = [1,1,1,1,1,1,1,1,1,1];

  constructor(private mapService : MapService, private dataService : DataServiceService){
    this.parkingCapacityThis = [];
  }
  calculateCapacity() {
    if((this.totalParkingspaces != 0)) {
      this.parkingCapacityAll.forEach(parkingCapacity => {
        if(parkingCapacity.name === "SAPArenaP6-P8,Parkplatz" && ((this.parkingName === "SAP Arena P6, Parkplatz") ||
          (this.parkingName === "SAP Arena P7, Parkplatz") || (this.parkingName === "SAP Arena P8, Parkplatz"))) {
          this.parkingCapacityThis.push(parkingCapacity);
        } else if(parkingCapacity.name.includes(this.parkingName.replace(/\s/g, "").split(',')[0])) {
          this.parkingCapacityThis.push(parkingCapacity);
        }
      })

      var capacitySameDayHour1: ParkingCapacity[] = [];
      var capacitySameDayHour2: ParkingCapacity[] = [];
      var capacitySameDayHour3: ParkingCapacity[] = [];
      var capacitySameDayHour4: ParkingCapacity[] = [];
      var capacitySameDayHour5: ParkingCapacity[] = [];
      var capacitySameDayHour6: ParkingCapacity[] = [];

      this.parkingCapacityThis.forEach(parkingCapacity => {
        const dbString: string = parkingCapacity.dateTime.toString();
        const dbDateTime = new Date(Date.parse(dbString));

        if((dbDateTime.getFullYear() === this.currentDateTime.getFullYear()) && (dbDateTime.getMonth() === this.currentDateTime.getMonth()) && (dbDateTime.getDate() === this.currentDateTime.getDate())) {
          if(dbDateTime.getHours() === this.currentDateTime.getHours() -3) {
            this.auslastungen[0] = this.calculatePercentage(parkingCapacity.freeParkingspaces);
          }
          if(dbDateTime.getHours() === this.currentDateTime.getHours() -2) {
            this.auslastungen[1] = this.calculatePercentage(parkingCapacity.freeParkingspaces);
          }
          if(dbDateTime.getHours() === this.currentDateTime.getHours() -1) {
            this.auslastungen[2] = this.calculatePercentage(parkingCapacity.freeParkingspaces);
          }
          if(dbDateTime.getHours() === this.currentDateTime.getHours()) {
            this.auslastungen[3] = this.calculatePercentage(parkingCapacity.freeParkingspaces);
          }
        }

        if(this.parseWeekday(parkingCapacity.weekday) === this.currentDateTime.getDay()) {
          if(dbDateTime.getHours() === this.currentDateTime.getHours() +1) {
            capacitySameDayHour1.push(parkingCapacity);
          }
          if(dbDateTime.getHours() === this.currentDateTime.getHours() +2) {
            capacitySameDayHour2.push(parkingCapacity);
          }
          if(dbDateTime.getHours() === this.currentDateTime.getHours() +3) {
            capacitySameDayHour3.push(parkingCapacity);
          }
          if(dbDateTime.getHours() === this.currentDateTime.getHours() +4) {
            capacitySameDayHour4.push(parkingCapacity);
          }
          if(dbDateTime.getHours() === this.currentDateTime.getHours() +5) {
            capacitySameDayHour5.push(parkingCapacity);
          }
          if(dbDateTime.getHours() === this.currentDateTime.getHours() +6) {
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


      //this.auslastungen = [50,55,60,65,70,75,60,50,40,50];
    }
  }

  calculatePercentage(currentFreeSpaces: number) {
    const percent = (this.totalParkingspaces - currentFreeSpaces) / (this.totalParkingspaces / 100);
    if (percent === 0) {
      return 1;
    }
    return percent;
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
    if(arrayOfCapacities.length != 0) {
      const sortedArray: ParkingCapacity[] = arrayOfCapacities.sort((a, b) => a.freeParkingspaces - b.freeParkingspaces);
      if (arrayOfCapacities.length % 2 === 1) {
        return sortedArray[Math.floor(arrayOfCapacities.length / 2)].freeParkingspaces;
      } else {
        return ((sortedArray[arrayOfCapacities.length / 2].freeParkingspaces) +
          (sortedArray[(arrayOfCapacities.length / 2) - 1].freeParkingspaces)) / 2;
      }
    } else {
      return this.totalParkingspaces;
    }
  }
}
