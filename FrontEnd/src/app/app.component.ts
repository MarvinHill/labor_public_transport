import { Component } from '@angular/core';
import { SearchService } from './services/search.service';
import { animate, style, transition, trigger } from '@angular/animations';
import { MapService } from './services/map.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Get2Buga';

  constructor(protected searchService : SearchService, protected mapService : MapService){}

  minimizeMap() {
    this.mapService.minimizeMap();
  }
}
