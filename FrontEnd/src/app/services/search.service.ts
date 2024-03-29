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
import { CampingSearchService } from './camping-search.service';
import { CaravanSearchService } from './caravan-search.service';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  public maximized  = false;
  public loading  = false;

  constructor(
    private parkingSearchProvider : ParkingSearchService,
    private shuttleLineSearchProvider: ShuttleSearchService,
    private infoSearchProvider: InfoSearchService,
    private campingSearchProvider : CampingSearchService,
    private caravanSearchProvider : CaravanSearchService
    ) {}

  async search(searchValue : string) : Promise<Searchable[]> {
    this.loading = true;
    searchValue = searchValue?.toLowerCase();

    if(searchValue == null){
      searchValue = "";
    }

    const searchResult = [];

    const parkingSearch = await this.parkingSearchProvider.search(searchValue,this);
    const shuttleSearch = await this.shuttleLineSearchProvider.search(searchValue,this);
    const infoSearch = await this.infoSearchProvider.search(searchValue,this);
    const campingSearch = await this.campingSearchProvider.search(searchValue,this);
    const caravanSearch = await this.caravanSearchProvider.search(searchValue,this);


    searchResult.push(
      parkingSearch,
      shuttleSearch,
      infoSearch,
      campingSearch,
      caravanSearch
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
