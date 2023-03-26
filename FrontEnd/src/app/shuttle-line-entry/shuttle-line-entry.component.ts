import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-shuttle-line-entry',
  templateUrl: './shuttle-line-entry.component.html',
  styleUrls: ['./shuttle-line-entry.component.css']
})
export class ShuttleLineEntryComponent implements OnInit {
  ngOnInit(): void {
    this.fromTo = this.fromStation + " - " + this.toStation
  }

  @Input() lineName : string = "no linename";
  @Input() fromStation: string = "station1";
  @Input() toStation: string = "station2";
  fromTo: string = "";

  

}