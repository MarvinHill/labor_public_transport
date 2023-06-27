import { ComponentFactoryResolver, Injectable, ViewChild, ViewContainerRef } from '@angular/core';
import { SearchProvider } from '../SearchProvider';
import { Router } from '@angular/router';
import { InfoBahnComponent } from '../info-bahn/info-bahn.component';
import { Searchable } from '../Searchable';
import { InfoSearchResult } from '../InfoSearchResult';
import { SearchService } from './search.service';
import { MapService } from './map.service';

@Injectable({
  providedIn: 'root'
})
export class InfoSearchService implements SearchProvider{

  // Intended to be set from another component
  public travel : string;
  public parking : string;
  public bus : string;
  public publicTransport : string;

  constructor(private router : Router, private mapService : MapService ) { }
  search(target: string, searchService : SearchService): Searchable[] {
    if(
      this.checkNotInitialized(this.travel)||
      this.checkNotInitialized(this.parking)||
      this.checkNotInitialized(this.bus)||
      this.checkNotInitialized(this.publicTransport)
      )
      {
        return [];
      }

      const results : Searchable[] = [];
      if(this.travel.toLowerCase().includes(target)){
        this.travel.split(" ").forEach(value => {
          if(value.toLowerCase().includes(target)){
            this.initializeValues("Allgemeine Informationen",value,target,"/travelinfo",results, searchService);
          }
        });

      }
      if(this.parking.toLowerCase().includes(target)){
        this.parking.split(" ").forEach(value => {
          if(value.toLowerCase().includes(target)){
            this.initializeValues("Parken Informationen",value,target,"/info-parking",results, searchService);
          }
        })

      }
      if(this.bus.toLowerCase().includes(target)){
        this.bus.split(" ").forEach(value => {
          if(value.toLowerCase().includes(target)){
            this.initializeValues("Bus Informationen",value,target,"/info-bus",results, searchService);
          }
        })
      }
      if(this.publicTransport.toLowerCase().includes(target)){
        this.publicTransport.split(" ").forEach(value => {
          if(value.toLowerCase().includes(target)){
            this.initializeValues("Bahn Informationen",value,target,"/info-bahn",results, searchService);
          }
        })
      }

      return results;
  }

  private initializeValues(category : string, foundIn : string, displayText : string, url : string, results : Searchable[], searchService : SearchService){
    const searchResult : InfoSearchResult = new InfoSearchResult();
    const LENGTH  = 50
    if(foundIn.length > LENGTH){
      foundIn = foundIn.substring(0,LENGTH-1);
    }
    searchResult.category = category;
    searchResult.displayText = `"${displayText}" in "${foundIn}" gefunden`;
    searchResult.searchAction = () => {
        this.router.navigateByUrl(url);
        searchService.minimize();
        this.mapService.minimizeMap();
    };
    results.push(searchResult);
  }
  private checkNotInitialized(val : any) : boolean{
    if(val == null){
      return true;
    }
    return false;
  }
}
