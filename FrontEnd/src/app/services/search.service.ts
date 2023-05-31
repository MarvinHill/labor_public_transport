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
  public loading : boolean = false;

  constructor(
    private parkingSearchProvider: ParkingSearchService, 
    private shuttleLineSearchProvider: ShuttleSearchService, 
    private infoSearchProvider: InfoSearchService,
    ) {
    }

  async search(searchValue : string) : Promise<Searchable[]> {
    this.loading = true;
    searchValue = searchValue?.toLowerCase();
    
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

}