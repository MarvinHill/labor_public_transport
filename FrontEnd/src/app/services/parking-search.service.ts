import { Injectable } from '@angular/core';
import { SearchProvider } from '../SearchProvider';
import { take } from 'rxjs';
import { ParkingLot } from '../ParkingLot';
import { DataServiceService } from './data-service.service';

@Injectable({
  providedIn: 'root'
})
export class ParkingSearchService implements SearchProvider{

  constructor(private dataService : DataServiceService) { }

  async search(target: string): Promise<ParkingLot[]> {
    
    var request = this.dataService.getAllParking();

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
              element.routingLocation = "/parking"
            });
              resolve(data);
       });
      }
    );
  }
}
