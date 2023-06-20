import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component } from '@angular/core';

import{ShuttleLine} from '../ShuttleLine';
import { DataServiceService } from '../services/data-service.service';
import { TransportType } from '../TransportType';


@Component({
  selector: 'app-shuttle-view',
  templateUrl: './shuttle-view.component.html',
  styleUrls: ['./shuttle-view.component.css']
})
export class ShuttleViewComponent{

  shuttleLineList: ShuttleLine[];
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

  constructor(http:HttpClient, dataService: DataServiceService){
    this.http = http;
    this.dataService = dataService;
    dataService.lines.subscribe(value=> {
      this.shuttleLineList = value.filter(value => {
        return value.transportType == TransportType[TransportType.Shuttle];
      });
    })
    dataService.update()
  }

}
