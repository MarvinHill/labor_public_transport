import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-transport-entry',
  templateUrl: './transport-entry.component.html',
  styleUrls: ['./transport-entry.component.css']
})
export class TransportEntryComponent{

  @Input() text: string = "no name";
  @Input() image_name: string = "notfound";

}
