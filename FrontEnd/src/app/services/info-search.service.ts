import { ComponentFactoryResolver, Injectable, ViewChild, ViewContainerRef } from '@angular/core';
import { SearchProvider } from '../SearchProvider';
import { Router } from '@angular/router';
import { InfoBahnComponent } from '../info-bahn/info-bahn.component';

@Injectable({
  providedIn: 'root'
})
export class InfoSearchService implements SearchProvider{

  constructor() { }
  search(target: string): void {}
}
