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
    this.arrivalTime = this.lineScheduleEntry.arrivalTime;
    this.stationDesignator = this.lineScheduleEntry.stationDesignator;
  }

  @Input() shuttleLine: ShuttleLine;
  @Input() lineScheduleEntry: LineScheduleEntry;
  lineName: string = "no line name";
  arrivalTime: string = "no arrival time";
  stationDesignator: string = "no station name";

}
