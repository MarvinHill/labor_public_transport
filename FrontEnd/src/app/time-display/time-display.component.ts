import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { RnvStopEvent } from '../RnvStopEvent';
import { TimeState } from '../TimeState';

@Component({
  selector: 'app-time-display',
  templateUrl: './time-display.component.html',
  styleUrls: ['./time-display.component.css']
})
export class TimeDisplayComponent implements OnInit,OnChanges  {

  protected TimeState = TimeState; 

  @Input() realtime : string = "";
  @Input() planned : string = "";
  @Input() stationName : string = "";

  state : TimeState = TimeState.NO_TIME;

  ngOnChanges(changes: SimpleChanges) {
    this.setUp();
  }
  
  
  ngOnInit(): void {
    this.setUp();
  }


  private setUp(){
    this.state = TimeState.NO_TIME;

    if(this.planned != null && this.planned != ""){
      this.state = TimeState.PLANNED_DEPARTURE;
    }
    if(this.realtime != null && this.realtime != this.planned && this.realtime != "" ){
      this.state = TimeState.REALTIME_DEPARTURE;
    }
  }


}