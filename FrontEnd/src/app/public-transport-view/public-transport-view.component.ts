import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { DataServiceService } from '../services/data-service.service';
import { UserLoginServiceService } from '../user-login-service.service';

@Component({
  selector: 'app-public-transport-view',
  templateUrl: './public-transport-view.component.html',
  styleUrls: ['./public-transport-view.component.css']
})
export class PublicTransportViewComponent {


  shuttleLineList: ShuttleLine[];

  constructor( private dataService: DataServiceService){

    this.dataService = dataService;
    dataService.lines.subscribe(value=> {
      this.shuttleLineList = value;
    })
    dataService.update()
  }
}
