import {Component, HostListener, Input, OnInit} from '@angular/core';
import {ParkingLot} from "../ParkingLot";
import {ParkingType} from "../ParkingType";
import {MapService} from "../services/map.service";
import {LatLng} from "leaflet";
import {MapDetailsObserverService} from '../services/map-details-observer.service';

@Component({
  selector: 'app-parkingItemCapacity',
  templateUrl: './parking-item-capacity.component.html',
  styleUrls: ['./parking-item-capacity.component.css']
})
export class ParkingItemCapacityComponent implements OnInit {
  carParkingLots: ParkingLot[];
  bikeParkingLots: ParkingLot[];
  items: number[];

  public screenWidth: any;

  ngOnInit(): void {
    this.parkingName = this.parking.name;
    this.parkingID = this.parking.id;
    this.parkingAddress = this.parking.address;
    this.screenWidth = window.innerWidth;
  }

  @Input() parking: ParkingLot;
  parkingName = "NAME";
  parkingID: number;
  parkingAddress = "ADDRESS";
  protected readonly ParkingType = ParkingType;

  // auslastungen: number[] = [50, 100, 75, 25, 25, 75, 50, 100, 9, 11, 10];
  auslastungen: number[] = [];

  constructor(private mapService : MapService, private observerService : MapDetailsObserverService){}

  panToParkingLot(){
    this.observerService.changeDisplay(this.parking);
    this.mapService.openAndFlyTo(new LatLng(this.parking.geoLocation.x, this.parking.geoLocation.y));
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: { target: { innerWidth: number; }; }) {
    this.screenWidth = window.innerWidth;
    console.log(this.screenWidth);
  }

}
