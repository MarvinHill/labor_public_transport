import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import{ShuttleLine} from '../ShuttleLine';
import { UserLoginServiceService } from '../user-login-service.service';
import { LineScheduleEntry } from '../LineScheduleEntry';

@Component({
  selector: 'app-shuttle-view',
  templateUrl: './shuttle-view.component.html',
  styleUrls: ['./shuttle-view.component.css']
})
export class ShuttleViewComponent{

  shuttleLineList: ShuttleLine[];
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
    dataService.lines.subscribe(value => {
      this.shuttleLineList = value;
    })
    dataService.update()
  }

  delete(item: number){
      console.warn("Delete id: " + item);
    
      const deletePost = this.http.delete('http://localhost:8080/ptl/' + item)
      deletePost.subscribe(val => {
        this.dataService.update();
      })
      }

}
