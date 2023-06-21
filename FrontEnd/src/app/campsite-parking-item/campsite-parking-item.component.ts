import {Component, Input, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {DataServiceService} from "../services/data-service.service";
import {ParkingLot} from "../ParkingLot";

@Component({
  selector: 'app-campsite-parking-item',
  templateUrl: './campsite-parking-item.component.html',
  styleUrls: ['./campsite-parking-item.component.css']
})
export class CampsiteParkingItemComponent implements OnInit {
  caravanParkingLots: ParkingLot[];
  campsiteParkingLots: ParkingLot[];
  http:HttpClient;
  options!: {
    headers?: HttpHeaders | { [header: string]: string | string[]; };
    observe?: 'body' | 'events' | 'response';
    params?: HttpParams | { [param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>; };
    reportProgress?: boolean;
    responseType?: 'arraybuffer' | 'blob' | 'json' | 'text';
    withCredentials?: boolean;
  };

  dataService: DataServiceService;

  constructor(http:HttpClient,  dataService: DataServiceService){
    this.http = http;
    this.dataService = dataService;
    dataService.getAllCarParking();

    dataService.caravanParking.subscribe(value=> {
      this.caravanParkingLots = value;
    })
    dataService.campsiteParking.subscribe(value=> {
      this.campsiteParkingLots = value;
    })
    dataService.getAllCaravanParking();
    dataService.getAllCampsiteParking();
  }

  ngOnInit(): void {
    this.name = this.park.name;
    this.parkingId = this.park.id;
  }

  @Input() park: ParkingLot;

  name:String = "NAME";
  parkingId: number;

}
