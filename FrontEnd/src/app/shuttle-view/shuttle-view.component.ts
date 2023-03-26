import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import{ShuttleLine} from '../ShuttleLine';
import { UserLoginServiceService } from '../user-login-service.service';

@Component({
  selector: 'app-shuttle-view',
  templateUrl: './shuttle-view.component.html',
  styleUrls: ['./shuttle-view.component.css']
})
export class ShuttleViewComponent implements OnInit{

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

  ngOnInit(): void {

    const request = this.http.get<ShuttleLine[]>('http://localhost:8080/ptl')
    request.subscribe(resp => {this.shuttleLineList = resp});

    console.log(this.shuttleLineList);

  }

  constructor(http:HttpClient, loginService : UserLoginServiceService){
    this.http = http;
    this.loginService = loginService;
  }

}
