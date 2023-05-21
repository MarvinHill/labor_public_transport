import { Component } from '@angular/core';

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
}
