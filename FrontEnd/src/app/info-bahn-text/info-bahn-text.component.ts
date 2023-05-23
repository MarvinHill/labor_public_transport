import { Component } from '@angular/core';
import { PreisService } from '../preis.service';

@Component({
  selector: 'app-info-bahn-text',
  templateUrl: './info-bahn-text.component.html',
  styleUrls: ['./info-bahn-text.component.css']
})
export class InfoBahnTextComponent {
  redirectToTicketPage() {
    window.location.href = 'https://www.rnv-online.de/fahrtinfo/buga23/';
  }

  constructor(public preisService : PreisService){}
}
