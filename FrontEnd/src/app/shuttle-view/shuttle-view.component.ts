import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import{ShuttleLine} from '../ShuttleLine';

@Component({
  selector: 'app-shuttle-view',
  templateUrl: './shuttle-view.component.html',
  styleUrls: ['./shuttle-view.component.css']
})
export class ShuttleViewComponent implements OnInit{

  shuttle_line_list: ShuttleLine[];

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
    request.subscribe(resp => {this.shuttle_line_list = resp});

    console.log(this.shuttle_line_list);

  }

  constructor(private http:HttpClient){}

}
