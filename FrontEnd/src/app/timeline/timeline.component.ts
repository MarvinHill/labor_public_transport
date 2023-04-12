import { Component, Input, OnInit } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { LineScheduleEntry } from '../LineScheduleEntry';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {
  ngOnInit(): void {
    this.lineName = this.shuttleLine.lineDesignator;
    this.lineScheduleEntryList = this.shuttleLine.lineScheduleEntryList;
    //this.lineScheduleEntry = this.shuttleLine.lineScheduleEntryList;
    this.arrivalTime = this.shuttleLine.lineScheduleEntryList[this.shuttleLine.id].arrivalTime;
    //this.lineScheduleEntry = this.shuttleLine.lineScheduleEntryList;
    //this.arrivalTime = this.lineScheduleEntry.arrivalTime;
    //this.stationDesignator = this.lineScheduleEntry.stationDesignator;
  }

  @Input() shuttleLine: ShuttleLine;
 // lineScheduleEntry: LineScheduleEntry;
  lineName: string = "no line name";
  lineScheduleEntryList: LineScheduleEntry[];
  arrivalTime: string = "no arrival time";
  publicTransportLine: ShuttleLine;

  @Input() stationDesignator1: string = "no station name";
  @Input() stationDesignator2: string = "no station name";

}
