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
import {HttpClientModule} from '@angular/common/http';
import { AddShuttleLineComponent } from './add-shuttle-line/add-shuttle-line.component';
import { PublicTransportLineComponent } from './public.transport.line/public.transport.line.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TravelinfoComponent } from './travelinfo/travelinfo.component';
import { InfoCarouselComponent } from './info-carousel/info-carousel.component';
import { InfoParkingComponent } from './info-parking/info-parking.component';
import { InfoBusComponent } from './info-bus/info-bus.component';
import { InfoBahnComponent } from './info-bahn/info-bahn.component';
import { InfoCardsComponent } from './info-cards/info-cards.component';
import { InfoParkingTextComponent } from './info-parking-text/info-parking-text.component';
import { InfoBusTextComponent } from './info-bus-text/info-bus-text.component';
import { InfoBahnTextComponent } from './info-bahn-text/info-bahn-text.component';



@NgModule({
  declarations: [
    AppComponent,
    TransportEntryComponent,
    RoutingTopBarComponent,
    ShuttleViewComponent,
    MainViewComponent,
    ShuttleLineEntryComponent,
    AddShuttleLineComponent,
    PublicTransportLineComponent,
    TravelinfoComponent,
    InfoCarouselComponent,
    InfoParkingComponent,
    InfoBusComponent,
    InfoBahnComponent,
    InfoCardsComponent,
    InfoParkingTextComponent,
    InfoBusTextComponent,
    InfoBahnTextComponent,
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
