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
export class ParkingViewComponent{
  carParkingLots: ParkingLot[];
  bikeParkingLots: ParkingLot[];
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

  carButtonClass: string = "selected-button";
  bikeButtonClass: string = "unselected-button";

  constructor(http:HttpClient, loginService : UserLoginServiceService,  dataService: DataServiceService){
    this.http = http;
    this.loginService = loginService;
    this.dataService = dataService;
    dataService.carParking.subscribe(value=> {
      this.carParkingLots = value;
    })
    dataService.getAllCarParking();

    dataService.bikeParking.subscribe(value=> {
      this.bikeParkingLots = value;
    })
    dataService.getAllBikeParking();
  }

  @Input() park: ParkingLot;



  switchCar() : void {
    this.carButtonClass = "selected-button";
    this.bikeButtonClass = "unselected-button";

    document.getElementById("bikeParkingContent").style.display = "none";
    document.getElementById("carParkingContent").style.display = "block";
  }

  switchBike() : void {
    this.bikeButtonClass = "selected-button";
    this.carButtonClass = "unselected-button";

    document.getElementById("carParkingContent").style.display = "none";
    document.getElementById("bikeParkingContent").style.display = "block";
  }
}
