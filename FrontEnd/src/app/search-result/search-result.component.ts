import { Component, Input } from '@angular/core';
import { Searchable } from '../Searchable';
import { SearchService } from '../services/search.service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent {
  @Input() item : Searchable;

  constructor(protected searchService : SearchService){}
}
