import { Component } from '@angular/core';
import {PreisService} from "../preis.service";

@Component({
  selector: 'app-info-bahn',
  templateUrl: './info-bahn.component.html',
  styleUrls: ['./info-bahn.component.css']
})
export class InfoBahnComponent {
  redirectToTicketPage() {
    window.location.href = 'https://www.rnv-online.de/fahrtinfo/buga23/';
  }

  constructor(public preisService : PreisService){}
}
