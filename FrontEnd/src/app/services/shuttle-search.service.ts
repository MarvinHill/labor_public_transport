import { Injectable } from '@angular/core';
import { SearchProvider } from '../SearchProvider';
import { DataServiceService } from './data-service.service';
import { ShuttleLine } from '../ShuttleLine';
import { take } from 'rxjs/operators';
import { SearchService } from './search.service';
import { Router } from '@angular/router';
import { MapService } from './map.service';
import { TransportType } from '../TransportType';

@Injectable({
  providedIn: 'root'
})
export class ShuttleSearchService implements SearchProvider {

  public searchService : SearchService;

  constructor(private dataService: DataServiceService, private router : Router, private mapService : MapService) { }
  async search(target: string): Promise<ShuttleLine[]> {

    var request = this.dataService.getShuttleLines();

    return new Promise<ShuttleLine[]>(
      resolve => {
        request.then(
          (data: ShuttleLine[]) => {
            data = data.filter(value => {
              if (data == null) {
                return false;
              }
              if (value.lineDesignator?.toLowerCase().includes(target)) {
                return true;
              }
              var childMatched = false;
              value.lineScheduleEntryList.forEach(element => {
                if (element?.station?.stationDesignator?.toLowerCase().includes(target)) {
                  childMatched = true;
                }
              });
              if (childMatched) {
                return true;
              }

              return false;
            });
            data.forEach(element => {
              element.category = "Shutte Linien und ÖPNV"
              element.displayText = element.lineDesignator;
              element.searchAction = () => {
                var local = ""
                if(element.transportType == TransportType[TransportType.Train]){
                  local = "/public-transport"
                }
                if(element.transportType == TransportType[TransportType.Shuttle]){
                  local = "/shuttle"
                }
                this.router.navigateByUrl(local);
                this.searchService.minimize();
                this.mapService.minimizeMap();
                setTimeout(() => {
                  var el = document.getElementById(element.displayText);
                  el?.scrollIntoView({ block: "center" });
                  console.warn("ran");
                }, 2000);
              };
            });
            resolve(data);
          });
      }
    );
  }
}
