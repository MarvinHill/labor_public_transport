import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainViewComponent} from './main-view/main-view.component'
import { ShuttleViewComponent } from './shuttle-view/shuttle-view.component';
import { TravelinfoComponent } from './travelinfo/travelinfo.component';
import { InfoParkingComponent } from './info-parking/info-parking.component';
import { InfoBahnComponent } from './info-bahn/info-bahn.component';
import { InfoBusComponent } from './info-bus/info-bus.component';
import { InfoCardsComponent } from './info-cards/info-cards.component';
import { InfoBahnTextComponent } from './info-bahn-text/info-bahn-text.component';
import { InfoBusTextComponent } from './info-bus-text/info-bus-text.component';
import { InfoCarouselComponent } from './info-carousel/info-carousel.component';
import { InfoParkingTextComponent } from './info-parking-text/info-parking-text.component';
import { ShuttleLineEntryComponent } from './shuttle-line-entry/shuttle-line-entry.component';
import { MapComponent } from "./map/map.component";
import { ParkingViewComponent } from './parking-view/parking-view.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { ConnectionTicketComponent } from './connection-ticket/connection-ticket.component';
import { PreisService } from './preis.service';

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
  {path: 'PreisService', component: PreisService}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}],
  exports: [RouterModule]
})
export class AppRoutingModule { }
