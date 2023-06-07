
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { interval, Observable, Subject } from 'rxjs';
import { ShuttleLine } from '../ShuttleLine';
import { Subscription, timer } from 'rxjs';
import { Router } from '@angular/router';
import {ParkingLot} from "../ParkingLot";
import { DataCache } from '../DataCache';
import { MapLocation } from '../MapLocation';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  //baseurl : string = 'https://get2buga.de/api';
  baseurl : string = 'http://localhost:8080/api';

  private mapLocatorApiURL : string = "https://nominatim.openstreetmap.org/search";

  lines: Subject<ShuttleLine[]> = new Subject<ShuttleLine[]>();

  carParking: Subject<ParkingLot[]> =new Subject<ParkingLot[]>();

  bikeParking: Subject<ParkingLot[]> =new Subject<ParkingLot[]>();

  

  constructor(private http:HttpClient, private router : Router ) {}

  update() {
    const request = this.http.get<ShuttleLine[]>(this.baseurl + '/ptl')
    request.subscribe(resp => {
      this.lines.next(resp)
    });
  }

  shuttleLineCache : DataCache<ShuttleLine> = new DataCache<ShuttleLine>();
  public getShuttleLines(): Promise<ShuttleLine[]> {
    const request = this.shuttleLineCache.pipeRequest(()=>{
      return this.http.get<ShuttleLine[]>(this.baseurl + '/ptl');
    });
    return request;    
  }

  public getShuttleLine(id: number): Observable<ShuttleLine> {
    return this.http.get<ShuttleLine>(this.baseurl + '/ptl' + id);
  }

  getData() {
    return this.http.get<ShuttleLine[]>(this.baseurl + '/ptl');
    //https://api.openbrewerydb.org/breweries/search?page=1&per_page=5&query=
    }

  getAllCarParking() {
    const request = this.http.get<ParkingLot[]>(this.baseurl + '/parking/car/all')
    request.subscribe(resp => {
      this.carParking.next(resp);
    })
  }

  getAllBikeParking() {
    const request = this.http.get<ParkingLot[]>(this.baseurl + '/parking/bike/all')
    request.subscribe(resp => {
      this.bikeParking.next(resp);
    })
  }

  parkingCache : DataCache<ParkingLot> = new DataCache<ParkingLot>();
  getAllParking() {
    const request = this.parkingCache.pipeRequest(()=>{
      return this.http.get<ParkingLot[]>(this.baseurl + '/parking/all');
    });
    return request;
  }

  openMapExternal(from : string, to : string){
    window.open(`https://www.google.de/maps/dir/${from}/${to}/`);
  }
  openMapExternalWithDestPosition(lat : string, lon : string){
      window.open(`https://www.google.de/maps/dir//${lat},${lon}/`);
  }
  
}
