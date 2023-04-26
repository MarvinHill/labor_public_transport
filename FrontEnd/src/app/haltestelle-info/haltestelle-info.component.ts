import { Component } from '@angular/core';

@Component({
  selector: 'app-haltestelle-info',
  templateUrl: './haltestelle-info.component.html',
  styleUrls: ['./haltestelle-info.component.css']
})
export class HaltestelleInfoComponent {

  fahrplan = 'true';

  linie = "P20 Luisenpark";

  changeFahrplanValue() {
    this.fahrplan = 'false';
  }


  testNeu() {
    alert("NEUE STATION");
  }

  testStation() {
    alert("STATION");
  }

  testStartZeit() {
    alert("START UHRZEIT");
  }

}
