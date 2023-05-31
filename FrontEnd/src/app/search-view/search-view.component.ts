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

protected searchQuery : Promise<Searchable[]>;
protected cachedSearchResults : Map<string, Searchable[]>;

searchResults : Searchable[] ;

protected textSearch(searchValue: string): void {
  this.searchService.loading = true;
  this.searchService.search(searchValue).then(value => {
    this.cachedSearchResults =  this.returnWithType(value.flat());
    
    this.searchService.loading = false;
  });
}

returnWithType(search : Searchable[]) : Map<string, Searchable[]> {
  var searchResults : Map<string, Searchable[]> = new Map<string, Searchable[]>();
  
  search.forEach(element => {
    if(!searchResults.has(element.category)){
      searchResults.set(element.category, []);
    }  
    searchResults.get(element.category)?.push(element);
  });

  return searchResults;
}
}
