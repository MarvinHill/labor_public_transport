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

}
