import { Component } from '@angular/core';
import { SearchService } from './services/search.service';
import { animate, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Get2Buga';

  constructor(protected searchService : SearchService){}
}
