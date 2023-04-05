import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TransportEntryComponent } from './transport-entry/transport-entry.component';
import { RoutingTopBarComponent } from './routing-top-bar/routing-top-bar.component';
import { ShuttleViewComponent } from './shuttle-view/shuttle-view.component';
import { MainViewComponent } from './main-view/main-view.component';
import { ShuttleLineEntryComponent } from './shuttle-line-entry/shuttle-line-entry.component';
import { MapComponent } from './map/map.component';
import {HttpClientModule} from '@angular/common/http';
import { AddShuttleLineComponent } from './add-shuttle-line/add-shuttle-line.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
