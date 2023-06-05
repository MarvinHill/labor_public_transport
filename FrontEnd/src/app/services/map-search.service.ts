import { Injectable } from '@angular/core';
import { SearchProvider } from '../SearchProvider';
import { MapLocation } from '../MapLocation';
import { DataServiceService } from './data-service.service';

@Injectable({
  providedIn: 'root'
})
export class MapSearchService implements SearchProvider{

  constructor(private dataService : DataServiceService) { }

  search(target: string): Promise<MapLocation[]> {
    return this.dataService.getMapLocations(target);
  }
  
}
