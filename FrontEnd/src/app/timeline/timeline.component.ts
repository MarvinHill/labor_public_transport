import { ChangeDetectionStrategy, Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { LineScheduleEntry } from '../LineScheduleEntry';
import { RnvStopEvent } from '../RnvStopEvent';
import { MapDetailsObserverService } from '../services/map-details-observer.service';
import { MapService } from '../services/map.service';
import { LatLng, Point } from 'leaflet';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
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
  @Input() restrictSize  = true;

  lineName = "no line name";
  shuttleLineID: number;
  lineScheduleEntryList: LineScheduleEntry[];
  shuttleLineList: ShuttleLine[];
  number: number; 
  JSON : JSON = JSON;
  chache : Map<string, RnvStopEvent[]>

  constructor(protected observerService : MapDetailsObserverService, protected mapService : MapService){}

  protected filterAndGetNewest( entries :  RnvStopEvent[]) : RnvStopEvent {
    var now : Date = new Date();
    entries = entries.filter(value => {
        if(value.plannedDeparture == null || value.realtimeDeparture == null){
          return false;
        } 
        var planned : Date = this.setTimeOfDate(value.plannedDeparture);
        var realtime : Date = this.setTimeOfDate(value.realtimeDeparture);

        if(planned != null && (planned > now || realtime > now)){
          return true;
        }
        else {
          return false;
        }
    
    });

    return entries[0];
  }

  panToTransportLine(){
    this.observerService.changeDisplay(this.shuttleLine);
    var point : Point = this.shuttleLine.geoLinePoints[0];
    this.mapService.openAndFlyTo(new LatLng(point.x, point.y));
  }

  private setTimeOfDate(strTime : string) : Date {
    var date : Date = new Date();

    var splitTime : string[] = strTime.split(":");

    date.setSeconds( splitTime[2] as unknown as number);
    date.setMinutes(splitTime[1] as unknown as number);
    date.setHours(splitTime[0] as unknown as number);

    return date;
  }


  private setUp() {
    this.chache = new Map();
    this.lineName = this.shuttleLine.lineDesignator;
    this.lineScheduleEntryList = this.shuttleLine.lineScheduleEntryList;
    this.shuttleLineID = this.shuttleLine.id;
    this.number = this.lineScheduleEntryList.length - 1;    
  }

  protected parseAndGetTimetable(lineScheduleEntry : LineScheduleEntry) : RnvStopEvent[]{
    if(this.chache.has(lineScheduleEntry.station.stationDesignator)){
      return this.chache.get(lineScheduleEntry.station.stationDesignator);
    }
    const parse = this.JSON.parse(lineScheduleEntry.station.timeInfoJSON).timeInfo;
    this.chache.set(
      lineScheduleEntry.station.stationDesignator, 
      parse
      );

    return parse;
  }

  protected parseAndFilterLine(lineScheduleEntry : LineScheduleEntry) : RnvStopEvent[]{
    return this.parseAndGetTimetable(lineScheduleEntry).filter(value => {
      return value.lineGroup === this.shuttleLine.lineDesignator;
    })
  }

  formateTime(str : string){
    if(str == null){
      return "";
    }
    var tokens : string[] = str.split(":");
    var hour : string = tokens[0].trim();
    var min : string = tokens[1].trim();

    return `${hour}:${min}`;
  }


}
