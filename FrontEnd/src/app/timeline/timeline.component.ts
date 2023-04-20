import { Component, Input, OnInit } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { LineScheduleEntry } from '../LineScheduleEntry';
import { DataServiceService } from '../data-service.service';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {
  
  shuttleLineList: ShuttleLine[];
  items: number[];


  createRange() {
    this.items = [];
    for (var i = 1; i <= this.lineScheduleEntryList.length; i++) {
      this.items.push(i);
    }
    return this.items;
  }


  ngOnInit(): void {
 
    this.lineName = this.shuttleLine.lineDesignator;
    this.lineScheduleEntryList = this.shuttleLine.lineScheduleEntryList;
    this.shuttleLineID = this.shuttleLine.id;
    this.number = this.lineScheduleEntryList.length-1;
    console.log(this.lineScheduleEntryList.length);
  }


  @Input() shuttleLine: ShuttleLine;

  lineName: string = "no line name";
  shuttleLineID: number;
  lineScheduleEntryList: LineScheduleEntry[];
  number: number; 
  @Input() imageName: String = "train.png";


 /* <div class="col-md-12">
        <button type="button" class="btn btn-outline-secondary waves-effect px-3"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-map" viewBox="0 0 25 25">
          <path fill-rule="evenodd" d="M15.817.113A.5.5 0 0 1 16 .5v14a.5.5 0 0 1-.402.49l-5 1a.502.502 0 0 1-.196 0L5.5 15.01l-4.902.98A.5.5 0 0 1 0 15.5v-14a.5.5 0 0 1 .402-.49l5-1a.5.5 0 0 1 .196 0L10.5.99l4.902-.98a.5.5 0 0 1 .415.103zM10 1.91l-4-.8v12.98l4 .8V1.91zm1 12.98 4-.8V1.11l-4 .8v12.98zm-6-.8V1.11l-4 .8v12.98l4-.8z"/>
        </svg>
        </button>
      </div>*/

  //Muss ich noch sortieren (nach Uhrzeit) oder wird dies schon in sql abgefragt
}