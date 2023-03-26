import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TransportEntryComponent } from './transport-entry/transport-entry.component';
import { RoutingTopBarComponent } from './routing-top-bar/routing-top-bar.component';
import { ShuttleViewComponent } from './shuttle-view/shuttle-view.component';
import { MainViewComponent } from './main-view/main-view.component';
import { RouterModule,Routes } from '@angular/router';
import { ShuttleLineEntryComponent } from './shuttle-line-entry/shuttle-line-entry.component';
import {HttpClientModule} from '@angular/common/http';
import { AddShuttleLineComponent } from './add-shuttle-line/add-shuttle-line.component';
import { PublicTransportLineComponent } from './public.transport.line/public.transport.line.component';

@NgModule({
  declarations: [
    AppComponent,
    TransportEntryComponent,
    RoutingTopBarComponent,
    ShuttleViewComponent,
    MainViewComponent,
    ShuttleLineEntryComponent,
    AddShuttleLineComponent,
    PublicTransportLineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
