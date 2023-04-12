import { Component, Input, OnInit } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { LineScheduleEntry } from '../LineScheduleEntry';

@Component({
  selector: 'app-shuttle-line-entry',
  templateUrl: './shuttle-line-entry.component.html',
  styleUrls: ['./shuttle-line-entry.component.css']
})
export class ShuttleLineEntryComponent implements OnInit {
  ngOnInit(): void {
  this.lineName = this.shuttleLine.lineDesignator;
 // this.lineScheduleEntry = this.shuttleLine.lineScheduleEntryList;
 // this.arrivalTime = this.lineScheduleEntry.arrivalTime;
 // this.stationDesignator = this.lineScheduleEntry.stationDesignator;
  }

  @Input() shuttleLine: ShuttleLine;
  lineName: string = "no line name";
  arrivalTime: string = "no arrival time";
  stationDesignator: string = "no station name";
  





}