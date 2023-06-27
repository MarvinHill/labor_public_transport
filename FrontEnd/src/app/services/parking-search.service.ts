import { Injectable } from '@angular/core';
import { SearchProvider } from '../SearchProvider';
import { take } from 'rxjs';
import { ParkingLot } from '../ParkingLot';
import { DataServiceService } from './data-service.service';
import { SearchService } from './search.service';
import { MapService } from './map.service';
import { Router } from '@angular/router';
import { ParkingType } from '../ParkingType';

@Injectable({
  providedIn: 'root'
})
export class ParkingSearchService implements SearchProvider{

  public searchService : SearchService;
  constructor(
    private dataService : DataServiceService,
    private mapService : MapService,
    private router : Router
    ) { }
  async search(target: string): Promise<ParkingLot[]> {

    const request = this.dataService.getAllParking();

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
              element.category = "Parkplätze"
              element.displayText = element.name;
              element.searchAction = () => {
                var local = "/parking"
                if(element.parkingType == ParkingType.BIKE){
                  local = "/bike-parking";
                } 
                this.router.navigateByUrl(local);
                this.searchService.minimize();
                this.mapService.minimizeMap();
                setTimeout(() => {
                  const el = document.getElementById(element.displayText);
                  el?.scrollIntoView({ block: "center" });
                  console.warn("ran");
                },2000);
              };
            });
              resolve(data);
       });
      }
    );
  }

}
