import { Component } from '@angular/core';

@Component({
  selector: 'app-connection-ticket',
  templateUrl: './connection-ticket.component.html',
  styleUrls: ['./connection-ticket.component.css']
})
export class ConnectionTicketComponent {
  show: boolean = false;

toggleText() {
  this.show = !this.show;
}

hideText() {
  this.show = false;
}

redirectToTicket() {
  window.location.href = 'https://tickets.buga23.de/shop?shopid=103&wes=4140e717103&nextstate=5';
}

}
