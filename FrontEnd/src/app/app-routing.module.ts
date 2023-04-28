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
import {MapComponent} from "./map/map.component";
import { ShuttleLineEntryComponent } from './shuttle-line-entry/shuttle-line-entry.component';


const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  {path:'main', component: MainViewComponent},
  {path:'shuttle', component: ShuttleViewComponent},
  {path:"travelinfo",component: TravelinfoComponent},
  {path:"info-parking",component: InfoParkingComponent},
  {path:"info-bahn", component: InfoBahnComponent},
  {path:"info-bus", component: InfoBusComponent},
  {path:'map', component: MapComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
