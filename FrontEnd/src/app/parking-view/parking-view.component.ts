import {Component, Input, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {UserLoginServiceService} from "../services/user-login-service.service";
import {DataServiceService} from "../services/data-service.service";
import {ParkingLot} from "../ParkingLot";

@Component({
  selector: 'app-parking-view',
  templateUrl: './parking-view.component.html',
  styleUrls: ['./parking-view.component.css']
})
export class ParkingViewComponent implements OnInit{
  carParkingLots: ParkingLot[];
  http:HttpClient;
  loginService : UserLoginServiceService;
  options!: {
    headers?: HttpHeaders | { [header: string]: string | string[]; };
    observe?: 'body' | 'events' | 'response';
    params?: HttpParams | { [param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>; };
    reportProgress?: boolean;
    responseType?: 'arraybuffer' | 'blob' | 'json' | 'text';
    withCredentials?: boolean;
  };

  dataService: DataServiceService;

  constructor(http:HttpClient, loginService : UserLoginServiceService,  dataService: DataServiceService){
    this.http = http;
    this.loginService = loginService;
    this.dataService = dataService;
    dataService.carParking.subscribe(value=> {
      this.carParkingLots = value;
    })
    dataService.getAllCarParking();
  }

  ngOnInit(): void {
    this.name = this.carPark.name;
    this.parkingId = this.carPark.id;
  }

  @Input() carPark: ParkingLot;

  name:String = "NAME";
  parkingId: number;



}
