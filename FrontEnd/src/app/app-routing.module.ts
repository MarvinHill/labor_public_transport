import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MainViewComponent} from './main-view/main-view.component'
import { ShuttleViewComponent } from './shuttle-view/shuttle-view.component';
import { TravelinfoComponent } from './travelinfo/travelinfo.component';
import { InfoParkingComponent } from './info-parking/info-parking.component';
import { InfoBahnComponent } from './info-bahn/info-bahn.component';
import { InfoBusComponent } from './info-bus/info-bus.component';
import {MapComponent} from "./map/map.component";

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
