
import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  baseurl : string = 'http://194.195.245.93:8080/buga23publictransport-2.0';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': this.baseurl, // Hier setzen Sie die Allow-Origin-Header
    })
  };

  lines: Subject<ShuttleLine[]> = new Subject<ShuttleLine[]>();

  carParking: Subject<ParkingLot[]> =new Subject<ParkingLot[]>();

  bikeParking: Subject<ParkingLot[]> =new Subject<ParkingLot[]>();

  constructor(private http:HttpClient, private router : Router ) {}

  update() {
    const request = this.http.get<ShuttleLine[]>(this.baseurl + '/ptl')
    request.subscribe(resp => {
      this.lines.next(resp)
      console.warn(resp);
    });
  }

  getData() {
    
    return this.http.get<ShuttleLine[]>(this.baseurl + '/ptl', this.httpOptions);
    //https://api.openbrewerydb.org/breweries/search?page=1&per_page=5&query=
    }

  getAllCarParking() {
    const request = this.http.get<ParkingLot[]>(this.baseurl + '/parking/car/all', this.httpOptions)
    request.subscribe(resp => {
      this.carParking.next(resp);
      console.warn(resp);
    })
  }

  getAllBikeParking() {
    const request = this.http.get<ParkingLot[]>(this.baseurl + '/parking/bike/all', this.httpOptions)
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
