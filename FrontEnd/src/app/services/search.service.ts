import { Injectable, ElementRef,ViewChild, Renderer2 } from '@angular/core';
import { ShuttleSearchService } from './shuttle-search.service';

import { ParkingSearchService } from './parking-search.service';
import { Searchable } from '../Searchable';
import { ShuttleLine } from '../ShuttleLine';
import { ParkingLot } from '../ParkingLot';
import { SearchProvider } from '../SearchProvider';
import { Router } from '@angular/router';
import { MapService } from './map.service';
import {Injector} from "@angular/core";
import { InfoSearchService } from './info-search.service';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  public maximized : boolean = false;
  public loading : boolean = false;

  constructor( 
    private parkingSearchProvider : ParkingSearchService,
    private shuttleLineSearchProvider: ShuttleSearchService,
    private infoSearchProvider: InfoSearchService,
    ) {}

  async search(searchValue : string) : Promise<Searchable[]> {
    this.loading = true;
    searchValue = searchValue?.toLowerCase();
    
    if(searchValue == null){
      searchValue = "";
    }

    var searchResult = [];

    this.parkingSearchProvider.searchService = this;
    var parkingSearch = await this.parkingSearchProvider.search(searchValue);
    this.shuttleLineSearchProvider.searchService = this;
    var shuttleSearch = await this.shuttleLineSearchProvider.search(searchValue);
    this.infoSearchProvider.searchService = this;
    var infoSearch = await this.infoSearchProvider.search(searchValue);
    
    
    searchResult.push(
      parkingSearch, 
      shuttleSearch,  
      infoSearch
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