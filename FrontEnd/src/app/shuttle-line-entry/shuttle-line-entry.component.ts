import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-shuttle-line-entry',
  templateUrl: './shuttle-line-entry.component.html',
  styleUrls: ['./shuttle-line-entry.component.css']
})
export class ShuttleLineEntryComponent implements OnInit {
  ngOnInit(): void {
    this.from_to = this.from_station + " - " + this.to_station
  }

  @Input() line_name : string = "no linename";
  @Input() from_station: string = "station1";
  @Input() to_station: string = "station2";
  from_to:string = "";

  

}