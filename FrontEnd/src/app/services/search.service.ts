import { Injectable, ElementRef,ViewChild, Renderer2 } from '@angular/core';
import { ShuttleSearchService } from './shuttle-search.service';
import { InfoSearchService } from './info-search.service';
import { ParkingSearchService } from './parking-search.service';
import { Searchable } from '../Searchable';
import { ShuttleLine } from '../ShuttleLine';
import { ParkingLot } from '../ParkingLot';
import { SearchProvider } from '../SearchProvider';
import { Router } from '@angular/router';
import { MapService } from './map.service';
@Injectable({
  providedIn: 'root'
})
export class SearchService {

  public maximized : boolean = false;
  public loading : boolean = false;

  constructor(
    private parkingSearchProvider: ParkingSearchService, 
    private shuttleLineSearchProvider: ShuttleSearchService, 
    private infoSearchProvider: InfoSearchService,
    private mapService : MapService,
    private router : Router
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

  public switchViewTo(target : Searchable) : void {
      this.router.navigateByUrl(target.routingLocation);
      this.minimize();
      this.mapService.minimizeMap();


      setTimeout(() => {
        var element = document.getElementById(target.displayText);
        element?.scrollIntoView({ block: "center" });
        console.warn("ran");
      },2000);
  }

}