import { Component } from '@angular/core';
import {PreisService} from "../preis.service";

@Component({
  selector: 'app-info-parking',
  templateUrl: './info-parking.component.html',
  styleUrls: ['./info-parking.component.css']
})
export class InfoParkingComponent {
  redirectToPage() {
    window.location.href = 'https://www.klimaschutzstiftung-bw.de/de/spenden-landingpage?kssid=buga23&ksstype=event';
  }

  constructor(public preisService : PreisService){}
}
