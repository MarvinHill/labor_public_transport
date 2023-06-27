import { Component, Inject } from '@angular/core';
import { PreisService } from '../preis.service';

@Component({
  selector: 'app-travelinfo',
  templateUrl: './travelinfo.component.html',
  styleUrls: ['./travelinfo.component.css']
})
export class TravelinfoComponent {
  redirectToParkOrdnung() {
    window.location.href = 'https://www.buga23.de/parkordnung/';
  }

  redirectToTicketShop() {
    window.location.href = 'https://tickets.buga23.de/shop/103';
  }

  redirectToBarrierefreiheit () {
    window.location.href = 'https://www.buga23.de/besuch-service/barrierefreiheit-mobilitaetsverleih/';
  } 

  redirectToMoreContact(){
    window.location.href = 'https://www.buga23.de/kontakt/';
  }

  constructor(@Inject(PreisService) public preisService : PreisService){}
}
