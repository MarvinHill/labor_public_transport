
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { interval, Subject } from 'rxjs';
import { ShuttleLine } from '../ShuttleLine';
import { Subscription, timer } from 'rxjs';
import { Router } from '@angular/router';
import {ParkingLot} from "../ParkingLot";

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  lines: Subject<ShuttleLine[]> = new Subject<ShuttleLine[]>();

  carParking: Subject<ParkingLot[]> =new Subject<ParkingLot[]>();

  bikeParking: Subject<ParkingLot[]> =new Subject<ParkingLot[]>();

  constructor(private http:HttpClient, private router : Router ) {}

  update() {
    const request = this.http.get<ShuttleLine[]>('http://localhost:8080/ptl')
    request.subscribe(resp => {
      this.lines.next(resp)
      console.warn(resp);
    });
  }

  getAllCarParking() {
    const request = this.http.get<ParkingLot[]>('http://localhost:8080/parking/car/all')
    request.subscribe(resp => {
      this.carParking.next(resp);
      console.warn(resp);
    })
  }

  getAllBikeParking() {
    const request = this.http.get<ParkingLot[]>('http://localhost:8080/parking/bike/all')
    request.subscribe(resp => {
      this.bikeParking.next(resp);
      console.warn(resp);
    })
  }

  openMapExternal(from : string, to : string){
    window.open(`https://www.google.de/maps/dir/${from}/${to}/`);
  }
  openMapExternalWithDestPosition(lat : string, lon : string){
      window.open(`https://www.google.de/maps/dir//${lat},${lon}/`);
  }
}
