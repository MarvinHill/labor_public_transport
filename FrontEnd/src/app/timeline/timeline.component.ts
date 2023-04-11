import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component, OnChanges, Input, OnInit, SimpleChanges } from '@angular/core';
import { DataServiceService } from '../data-service.service';
import { take } from 'rxjs';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
  export class TimelineComponent implements OnInit{

    myData: any;
     @Input() text: string;
     @Input() imageName: string = "notfound";

    dataService: DataServiceService;

    constructor(dataService: DataServiceService){
      }

    ngOnInit(): void {
      this.dataService.getData().pipe(take(1)).subscribe((data) =>
      this.myData = data)
    }

  }
