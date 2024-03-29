import { AfterViewInit, Component, ElementRef } from '@angular/core';
import { SearchService } from '../services/search.service';
import { Searchable } from '../Searchable';
import { InfoSearchService } from '../services/info-search.service';

@Component({
  selector: 'app-search-view',
  templateUrl: './search-view.component.html',
  styleUrls: ['./search-view.component.css']
})
export class SearchViewComponent implements AfterViewInit{
constructor(protected searchService : SearchService, private infoSearchProvider : InfoSearchService){}

protected searchQuery : Promise<Searchable[]>;
protected cachedSearchResults : Map<string, Searchable[]>;

protected notLoaded = true;

searchResults : Searchable[] ;

ngAfterViewInit(): void {
  this.infoSearchProvider.travel = document.getElementById("searchTravelinfo").innerText;
  this.infoSearchProvider.parking = document.getElementById("searchParking").innerText;
  this.infoSearchProvider.bus = document.getElementById("searchBus").innerText;
  this.infoSearchProvider.publicTransport = document.getElementById("searchPublicTransport").innerText;

}

protected textSearch(searchValue: string): void {
  this.searchService.loading = true;
  this.searchService.search(searchValue).then(value => {
    this.cachedSearchResults =  this.returnWithType(value.flat());

    this.searchService.loading = false;
  });
}

returnWithType(search : Searchable[]) : Map<string, Searchable[]> {
  const searchResults : Map<string, Searchable[]> = new Map<string, Searchable[]>();

  search.forEach(element => {
    if(!searchResults.has(element.category)){
      searchResults.set(element.category, []);
    }
    searchResults.get(element.category)?.push(element);
  });

  return searchResults;
}
}
