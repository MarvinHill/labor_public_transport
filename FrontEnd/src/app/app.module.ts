import { NgModule, isDevMode } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ServiceWorkerModule } from '@angular/service-worker';
import { PreisService } from './preis.service';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TransportEntryComponent } from './transport-entry/transport-entry.component';
import { RoutingTopBarComponent } from './routing-top-bar/routing-top-bar.component';
import { ShuttleViewComponent } from './shuttle-view/shuttle-view.component';
import { MainViewComponent } from './main-view/main-view.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TimelineComponent } from './timeline/timeline.component';
import { TravelinfoComponent } from './travelinfo/travelinfo.component';
import { InfoCarouselComponent } from './info-carousel/info-carousel.component';
import { InfoParkingComponent } from './info-parking/info-parking.component';
import { InfoBusComponent } from './info-bus/info-bus.component';
import { InfoBahnComponent } from './info-bahn/info-bahn.component';
import { InfoCardsComponent } from './info-cards/info-cards.component';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MapComponent } from './map/map.component';
import { MapDetailsObserverComponent } from './map-details-observer/map-details-observer.component';
import { ParkingViewComponent } from './parking-view/parking-view.component';
import { ParkingItemCapacityComponent } from "./parking-item-capacity/parking-item-capacity.component";
import { ConnectionTicketComponent } from './connection-ticket/connection-ticket.component';
import { ImpressumComponent } from './impressum/impressum.component';
import { LineLegendComponent } from './line-legend/line-legend.component';
import { TimeDisplayComponent } from './time-display/time-display.component';
import { SearchViewComponent } from './search-view/search-view.component';
import { SearchResultComponent } from './search-result/search-result.component';
import { SearchCategoryComponent } from './search-category/search-category.component';
import { PublicTransportViewComponent } from './public-transport-view/public-transport-view.component';
import { CampsiteParkingItemComponent } from './campsite-parking-item/campsite-parking-item.component';
import { BikeParkingItemComponent } from "./bike-parking-item/bike-parking-item.component";


@NgModule({
  declarations: [
    AppComponent,
    TransportEntryComponent,
    RoutingTopBarComponent,
    ShuttleViewComponent,
    MainViewComponent,
    MapComponent,
    MapDetailsObserverComponent,
    TimelineComponent,
    TravelinfoComponent,
    InfoCarouselComponent,
    InfoParkingComponent,
    InfoBusComponent,
    InfoBahnComponent,
    InfoCardsComponent,
    ParkingItemCapacityComponent,
    ParkingViewComponent,
    ImpressumComponent,
    ConnectionTicketComponent,
    LineLegendComponent,
    TimeDisplayComponent,
    SearchViewComponent,
    SearchResultComponent,
    SearchCategoryComponent,
    LineLegendComponent,
    TimeDisplayComponent,
    PublicTransportViewComponent,
    CampsiteParkingItemComponent,
    BikeParkingItemComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatSnackBarModule,
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: !isDevMode(),
      // Register the ServiceWorker as soon as the application is stable
      // or after 30 seconds (whichever comes first).
      registrationStrategy: 'registerWhenStable:30000'
    }),
  ],
  providers: [PreisService],
  bootstrap: [AppComponent]
})
export class AppModule { }
