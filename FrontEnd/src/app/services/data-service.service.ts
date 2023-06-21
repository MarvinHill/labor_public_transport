
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { ShuttleLine } from '../ShuttleLine';
import { Router } from '@angular/router';
import {ParkingLot} from "../ParkingLot";
import {ParkingCapacity} from "../ParkingCapacity";
import { TimeStopInfo } from '../TimeStopInfo';
import { DataCache } from '../DataCache';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  //baseurl : string = 'https://get2buga.de/api';
  private mapLocatorApiURL = "https://nominatim.openstreetmap.org/search";

  baseurl: string = 'http://localhost:8080/api';


  lines: Subject<ShuttleLine[]> = new Subject<ShuttleLine[]>();

  carParking: Subject<ParkingLot[]> = new Subject<ParkingLot[]>();

  bikeParking: Subject<ParkingLot[]> = new Subject<ParkingLot[]>();

  parkingCapacity: Subject<ParkingCapacity[]> =new Subject<ParkingCapacity[]>();

  campsiteParking: Subject<ParkingLot[]> = new Subject<ParkingLot[]>();

  caravanParking: Subject<ParkingLot[]> = new Subject<ParkingLot[]>();

  constructor(private http: HttpClient, private router: Router) { }

  update() {
    const request = this.http.get<ShuttleLine[]>(this.baseurl + '/ptl')
    request.subscribe(resp => {
      this.lines.next(resp)
    });
  }

  shuttleLineCache: DataCache<ShuttleLine> = new DataCache<ShuttleLine>();
  public getShuttleLines(): Promise<ShuttleLine[]> {
    const request = this.shuttleLineCache.pipeRequest(() => {
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

  getAllCampsiteParking() {
    const request = this.http.get<ParkingLot[]>(this.baseurl + '/parking/campsite/all')
    request.subscribe(resp => {
      this.campsiteParking.next(resp);
    })
  }

  getAllCaravanParking() {
    const request = this.http.get<ParkingLot[]>(this.baseurl + '/parking/caravan/all')
    request.subscribe(resp => {
      this.caravanParking.next(resp);
    })
  }

  parkingCache: DataCache<ParkingLot> = new DataCache<ParkingLot>();
  getAllParking() {
    const request = this.parkingCache.pipeRequest(() => {
      return this.http.get<ParkingLot[]>(this.baseurl + '/parking/all');
    });
    return request;
  }

  getAllParkingCapacity() {
    const request = this.http.get<ParkingCapacity[]>(this.baseurl + '/capacity/all')
    request.subscribe(resp => {
      this.parkingCapacity.next(resp);
    })
  }

  openMapExternal(from: string, to: string) {
    window.open(`https://www.google.de/maps/dir/${from}/${to}/`);
  }

  openMapExternalWithDestPosition(lat: string, lon: string) {
    window.open(`https://www.google.de/maps/dir//${lat},${lon}/`);
  }

  public getTimeStopInfo(hasafID: String, UTCTime: String): Observable<TimeStopInfo> {
    var query = this.baseurl + "?" + "hasafID=" + hasafID + "&timeStart=" + UTCTime;
    return this.http.get<TimeStopInfo>(query);
  }

}
