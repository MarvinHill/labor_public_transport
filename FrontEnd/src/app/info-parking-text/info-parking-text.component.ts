import { Component } from '@angular/core';
import { PreisService } from '../preis.service';

@Component({
  selector: 'app-info-parking-text',
  templateUrl: './info-parking-text.component.html',
  styleUrls: ['./info-parking-text.component.css']
})
export class InfoParkingTextComponent {
  redirectToPage() {
    window.location.href = 'https://www.klimaschutzstiftung-bw.de/de/spenden-landingpage?kssid=buga23&ksstype=event';
  }

  constructor(public preisService : PreisService){}
}
