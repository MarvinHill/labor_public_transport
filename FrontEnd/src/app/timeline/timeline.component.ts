import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { LineScheduleEntry } from '../LineScheduleEntry';
import { DataServiceService } from '../services/data-service.service';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit,OnChanges {
  items: number[];

  ngOnChanges(changes: SimpleChanges) {
    this.setUp();
  }
  
  
  ngOnInit(): void {
    this.setUp();
  }


  @Input() shuttleLine: ShuttleLine;
  @Input() restrictSize : boolean = true;

  lineName: string = "no line name";
  shuttleLineID: number;
  lineScheduleEntryList: LineScheduleEntry[];
  shuttleLineList: ShuttleLine[];
  number: number; 


  private setUp() {
    this.lineName = this.shuttleLine.lineDesignator;
    this.lineScheduleEntryList = this.shuttleLine.lineScheduleEntryList;
    this.shuttleLineID = this.shuttleLine.id;
    this.number = this.lineScheduleEntryList.length - 1;
  }

  formateTime(str : string){
    var tokens : string[] = str.split(":");
    var hour : string = tokens[0].trim();
    var min : string = tokens[1].trim();

    return `${hour}:${min}`;
  }


}
