
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { interval, Subject } from 'rxjs';
import { ShuttleLine } from './ShuttleLine';
import { Subscription, timer } from 'rxjs';
import {ParkingLot} from "./ParkingLot";

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  lines: Subject<ShuttleLine[]> = new Subject<ShuttleLine[]>();

  carParking: Subject<ParkingLot[]> =new Subject<ParkingLot[]>();

  http : HttpClient;



  constructor(http:HttpClient) {
    this.http = http;
  }

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

}
