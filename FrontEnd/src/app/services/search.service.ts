import { Injectable, ElementRef,ViewChild } from '@angular/core';
import { ShuttleSearchService } from './shuttle-search.service';
import { InfoSearchService } from './info-search.service';
import { ParkingSearchService } from './parking-search.service';
import { Searchable } from '../Searchable';
import { ShuttleLine } from '../ShuttleLine';
import { ParkingLot } from '../ParkingLot';
import { SearchProvider } from '../SearchProvider';
@Injectable({
  providedIn: 'root'
})
export class SearchService {

  public maximized : boolean = true;
  public matchingResults : Searchable[];
  public matchingResultsCategorized : Map<string, Searchable[]>;
  private providers : SearchProvider[];
  public loading : boolean = false;

  constructor(
    private parkingSearchProvider: ParkingSearchService, 
    private shuttleLineSearchProvider: ShuttleSearchService, 
    private infoSearchProvider: InfoSearchService,
    ) {
    }

  textSearch(searchValue: string): void {
    searchValue = searchValue?.toLowerCase();
    this.loading = true;
    this.search(searchValue).then(value => {
      this.matchingResults = value.flat();
      this.matchingResultsCategorized =  this.returnWithType();
      console.warn("Matching Results");
      console.warn(this.matchingResults); 
      this.loading = false;
    });
  }

  private async search(searchValue : string) : Promise<Searchable[]> {
    console.warn("Search " + searchValue);
    
    if(searchValue == null){
      searchValue = "";
    }

    var searchResult = [];

    var parkingSearch
    var shuttleSearch
    //var infoSearch

    parkingSearch = await this.parkingSearchProvider.search(searchValue);
    shuttleSearch = await this.shuttleLineSearchProvider.search(searchValue)
    //this.infoSearchProvider.search(searchValue);
    
    
    searchResult.push(
      parkingSearch, 
      shuttleSearch, 
      //infoSearch
      );

      console.warn("Result ");
      console.warn(searchResult);
      return searchResult;
  }

  public maximize(){
      if(this.maximized == false){
        this.maximized = true;
      }
  }

  public minimize(){
    if(this.maximized == true){
      this.maximized = false;
    }
  }

  public flipVisibility(){
    this.maximized = !this.maximized;
  }


  returnWithType() : Map<string, Searchable[]> {
    var searchResults : Map<string, Searchable[]> = new Map<string, Searchable[]>();
    
    this.matchingResults.forEach(element => {
      if(!searchResults.has(element.category)){
        searchResults.set(element.category, []);
      }  
      searchResults.get(element.category)?.push(element);
    });

    return searchResults;
  }

}