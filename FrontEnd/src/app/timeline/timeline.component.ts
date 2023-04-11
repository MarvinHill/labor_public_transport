import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
  export class TimelineComponent{
    @Input() text: Array<String>[10];
    @Input() imageName: string = "notfound";

}
