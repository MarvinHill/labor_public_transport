import { Injectable } from '@angular/core';
import { SearchProvider } from '../SearchProvider';
import { DataServiceService } from './data-service.service';
import { ShuttleLine } from '../ShuttleLine';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ShuttleSearchService implements SearchProvider{

  constructor(private dataService : DataServiceService) { }
  async search(target: string): Promise<ShuttleLine[]> {
    
    var request = this.dataService.getShuttleLines();

    return new Promise<ShuttleLine[]>(
      resolve => {
        request.then(
          (data:ShuttleLine[]) => {
            data = data.filter(value => {
              if(data == null){
                return false;
              }
              if(value.lineDesignator?.toLowerCase().includes(target)){
                return true;
              }
              var childMatched = false;
              value.lineScheduleEntryList.forEach(element => {
                if(element?.station?.stationDesignator?.toLowerCase().includes(target)){
                  childMatched = true;
                }
              });
              if(childMatched){
                return true;
              }

              return false;
            });
            data.forEach(element => {
              element.category = "Shuttle-Linien"
              element.displayText = element.lineDesignator;
              element.routingLocation = "/shuttle"
            });
              resolve(data);
       });
      }
    );
  }
}
