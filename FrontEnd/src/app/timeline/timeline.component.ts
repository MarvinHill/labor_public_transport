import { Component, Input, OnInit } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { LineScheduleEntry } from '../LineScheduleEntry';
import { DataServiceService } from '../services/data-service.service';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {
  items: number[];
  
  
  ngOnInit(): void {

    this.lineName = this.shuttleLine.lineDesignator;
    this.lineScheduleEntryList = this.shuttleLine.lineScheduleEntryList;
    this.shuttleLineID = this.shuttleLine.id;
    this.number = this.lineScheduleEntryList.length-1;
  }


  @Input() shuttleLine: ShuttleLine;
  @Input() restrictSize : boolean = true;

  lineName: string = "no line name";
  shuttleLineID: number;
  lineScheduleEntryList: LineScheduleEntry[];
  shuttleLineList: ShuttleLine[];
  number: number; 


  formateTime(str : string){
    var tokens : string[] = str.split(":");
    var hour : string = tokens[0].trim();
    var min : string = tokens[1].trim();

    return `${hour}:${min}`;
  }


}
