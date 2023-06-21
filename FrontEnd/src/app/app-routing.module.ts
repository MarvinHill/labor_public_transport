import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainViewComponent} from './main-view/main-view.component'
import { ShuttleViewComponent } from './shuttle-view/shuttle-view.component';
import { TravelinfoComponent } from './travelinfo/travelinfo.component';
import { InfoParkingComponent } from './info-parking/info-parking.component';
import { InfoBahnComponent } from './info-bahn/info-bahn.component';
import { InfoBusComponent } from './info-bus/info-bus.component';

import { MapComponent } from "./map/map.component";
import { ParkingViewComponent } from './parking-view/parking-view.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { ImpressumComponent } from './impressum/impressum.component';
import { PreisService } from './preis.service';
import { ConnectionTicketComponent } from './connection-ticket/connection-ticket.component';
import {BikeParkingItemComponent} from "./bike-parking-item/bike-parking-item.component";
import {CampsiteParkingItemComponent} from "./campsite-parking-item/campsite-parking-item.component";
import { PublicTransportViewComponent } from './public-transport-view/public-transport-view.component';


const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  {path:'main', component: MainViewComponent},
  {path:'shuttle', component: ShuttleViewComponent},
  {path:"travelinfo",component: TravelinfoComponent},
  {path:"info-parking",component: InfoParkingComponent},
  {path:"info-bahn", component: InfoBahnComponent},
  {path:"info-bus", component: InfoBusComponent},
  {path:'map', component: MapComponent},
  {path:'parking', component: ParkingViewComponent},
  {path: 'connection-ticket', component: ConnectionTicketComponent},
  {path: 'PreisService', component: PreisService},
  {path:'impressum', component: ImpressumComponent},
  {path:'public-transport', component: PublicTransportViewComponent},
  {path:'bike-parking', component: BikeParkingItemComponent},
  {path:'campsites', component: CampsiteParkingItemComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: "top", useHash: true})],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}],
  exports: [RouterModule]
})
export class AppRoutingModule { }
