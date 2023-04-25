import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TransportEntryComponent } from './transport-entry/transport-entry.component';
import { RoutingTopBarComponent } from './routing-top-bar/routing-top-bar.component';
import { ShuttleViewComponent } from './shuttle-view/shuttle-view.component';
import { MainViewComponent } from './main-view/main-view.component';
import { ShuttleLineEntryComponent } from './shuttle-line-entry/shuttle-line-entry.component';
import { HttpClientModule} from '@angular/common/http';
import { AddShuttleLineComponent } from './add-shuttle-line/add-shuttle-line.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TimelineComponent } from './timeline/timeline.component';
import { TravelinfoComponent } from './travelinfo/travelinfo.component';
import { InfoCarouselComponent } from './info-carousel/info-carousel.component';
import { InfoParkingComponent } from './info-parking/info-parking.component';
import { InfoBusComponent } from './info-bus/info-bus.component';
import { InfoBahnComponent } from './info-bahn/info-bahn.component';


import { MapComponent } from './map/map.component';
import { MapDetailsObserverComponent } from './map-details-observer/map-details-observer.component';
import { ParkingViewComponent } from './parking-view/parking-view.component';
import { ParkingItemComponent } from './parking-item/parking-item.component';
import { BikeViewComponent } from './bike-view/bike-view.component';


@NgModule({
  declarations: [
    AppComponent,
    TransportEntryComponent,
    RoutingTopBarComponent,
    ShuttleViewComponent,
    MainViewComponent,
    ShuttleLineEntryComponent,
    MapComponent,
    ShuttleLineEntryComponent,
    AddShuttleLineComponent,
    MapDetailsObserverComponent,
    TimelineComponent,
    TravelinfoComponent,
    InfoCarouselComponent,
    InfoParkingComponent,
    InfoBusComponent,
    InfoBahnComponent,
    BikeViewComponent,

    ParkingViewComponent,
    ParkingItemComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
