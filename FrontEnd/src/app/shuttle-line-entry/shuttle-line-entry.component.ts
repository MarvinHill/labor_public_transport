import { Component, Input, OnInit } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';

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
  lineName = "no line name";
  arrivalTime = "no arrival time";
  stationDesignator = "no station name";
}
