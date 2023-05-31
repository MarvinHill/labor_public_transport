import { Component } from '@angular/core';
import { SearchService } from '../services/search.service';
import { Searchable } from '../Searchable';

@Component({
  selector: 'app-search-view',
  templateUrl: './search-view.component.html',
  styleUrls: ['./search-view.component.css']
})
export class SearchViewComponent{
constructor(protected searchService : SearchService){}

protected cachedSearchResults : Map<string, Searchable[]>;

searchResults : Searchable[] ;
}
