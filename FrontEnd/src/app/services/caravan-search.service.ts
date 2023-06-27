import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ParkingLot } from '../ParkingLot';
import { ParkingType } from '../ParkingType';
import { SearchProvider } from '../SearchProvider';
import { DataServiceService } from './data-service.service';
import { MapService } from './map.service';
import { SearchService } from './search.service';

@Injectable({
  providedIn: 'root'
})
export class CaravanSearchService implements SearchProvider{

  constructor(
    private dataService : DataServiceService,
    private mapService : MapService,
    private router : Router
    ) { }
  async search(target: string, searchService : SearchService): Promise<ParkingLot[]> {

    const request = this.dataService.getAllCaravanParkingRequest();

    return new Promise<ParkingLot[]>(
      resolve => {
        request.then(
          (data:ParkingLot[]) => {
            data = data.filter(value => {
              if(value?.name?.toLowerCase().includes(target)){
                return true;
              }
              if(value?.address?.toLowerCase().includes(target)){
                return true;
              }
              return false;
            });
            data.forEach(element => {
              element.category = "Wohnmobilstellplätze"
              element.displayText = element.name;
              element.searchAction = () => {
                var local = "/campsites"
                this.router.navigateByUrl(local);
                searchService.minimize();
                this.mapService.minimizeMap();
                setTimeout(() => {
                  const el = document.getElementById(element.displayText);
                  el?.scrollIntoView({ block: "center" });
                },2000);
              };
            });
              resolve(data);
       });
      }
    );
  }

}
