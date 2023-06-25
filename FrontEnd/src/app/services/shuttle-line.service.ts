import { Injectable } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { HttpClient } from '@angular/common/http';
import { LineScheduleEntry } from '../LineScheduleEntry';
import * as L from 'leaflet';
import { Point } from 'leaflet';
import { DataServiceService } from './data-service.service';
import { MapService } from './map.service';
import { MapDetailsObserverService } from './map-details-observer.service';

@Injectable({
  providedIn: 'root'
})
export class ShuttleLineService {
  private http: HttpClient;
  private lines: ShuttleLine[];


  constructor(http: HttpClient, private dataService: DataServiceService, private observerService: MapDetailsObserverService) {
    this.http = http;
  }

  static IconP_R = L.divIcon({
    className: "legend-label",
    html: '<i class="label" border="solid"; style="background-color: #662483; border-color: #662483; color: white; padding: 0.25em;">P+R</i>',
    iconSize: [2, 2],
    iconAnchor: [1, 1] // half of width + height
  });

  static Icon7 = L.divIcon({
    className: "legend-label",
    html: '<i class="label" style="background-color: #ffcc00; border-color: #ffcc00; color: white; padding: 0.25em;">7</i>',
    iconSize: [6, 12],
    iconAnchor: [3, 6] // half of width + height
  });

  static IconBS = L.divIcon({
    className: "legend-label",
    html: '<i class="label" style="background-color: #00b1da; border-color: #00b1da; color: white; padding: 0.25em;">BS</i>',
    iconSize: [6, 12],
    iconAnchor: [3, 6] // half of width + height
  });

  static Icon9 = L.divIcon({
    className: "legend-label",
    html: '<i class="label" style="background-color: #aaca47; border-color: #aaca47; color: white; padding: 0.25em;">9</i>',
    iconSize: [6, 12],
    iconAnchor: [3, 6] // half of width + height
  });

  static IconBL = L.divIcon({
    className: "legend-label",
    html: '<i class="label" style="background-color: #e1416d; border-color: #e1416d; color: white; padding: 0.25em;">BL</i>',
    iconSize: [6, 12],
    iconAnchor: [3, 6] // half of width + height
  });

  static Icon6 = L.divIcon({
    className: "legend-label",
    html: '<i class="label" style="background-color: #956c29; border-color: #956c29; color: white; padding: 0.25em;">6</i>',
    iconSize: [6, 12],
    iconAnchor: [3, 6] // half of width + height
  });

  /**
   *
   * @param map
   */
  public initShuttleLineViewOnMap(layers, service: MapService) {
    this.dataService.getShuttleLines().then(
      (lines: ShuttleLine[]) => {

        this.lines = lines;
        console.warn(lines);
        this.lines?.forEach(line => {
          const layer = [new L.LayerGroup, ""];
          // draw the real train or shuttle line into the map
          if (line.geoLinePoints.length > 0) {
            var pl = this.getPolyLine(line, layer[0] as L.LayerGroup);
            pl.addTo(layer[0] as L.LayerGroup);
            pl.on("click", function (e: any) {
              this.observerService.changeDisplay(line)
            }.bind(this));
          }
          line.lineScheduleEntryList.forEach(entry => {
            this.addLineStopToMap(layer[0] as L.LayerGroup, entry, line);
          });

          layer[1] = line.lineDesignator;
          layers.push(layer);
        });
        service.initMap();
      });
  }

  /**
   * Add a marker to the map with the line stop
   *
   * @param map
   * @param entry
   * @param line
   */
  public addLineStopToMap(layer: L.LayerGroup, entry: LineScheduleEntry, line: ShuttleLine): void {
    //Todo: right icon designation for trains parkingslots and shuttle line view
    const shuttleMarkerIcon = L.icon({
      iconUrl: 'assets/image/ShuttleLineEntry.png',
      iconSize: [20, 20], // size of the icon
      shadowSize: [50, 64], // size of the shadow
      iconAnchor: [10, 10], // point of the icon which will correspond to marker's location
      shadowAnchor: [4, 62],  // the same for the shadow
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });

    const marker = new L.Marker(
      [entry.station.geoLocation.x, entry.station.geoLocation.y],
      { icon: shuttleMarkerIcon }
    );
    marker.on("click", function (e: any) {
      this.observerService.changeDisplay(line)
    }.bind(this));
    marker.bindPopup("<span>" + entry.station.stationDesignator + "</span>").openPopup();
    marker.addTo(layer);
  }

  /**
   *
   * @param map
   * @param line
   * @returns
   */
  public getPolyLine(line: ShuttleLine, layer: L.LayerGroup): L.Polyline {
    let tpl = this.transformPolyLinePointToLatlng(line.geoLinePoints);
    var options =
    {
      bubblingMouseEvents: false,
      color: line.colorHexCode,
      weight: 5,
      opacity: 1,
      smoothFactor: 1,
    };

    // here new function for line points
    var lineSections = [];
    // saves every magnitude in the lineSections array
    for (var i = 0; i < tpl.length - 1; i++) {
      // first point
      var x1 = tpl[i].lat;
      var y1 = tpl[i].lng;

      // next point
      var x2 = tpl[i + 1].lat;
      var y2 = tpl[i + 1].lng;

      // subtracted new vector 
      var newX = x2 - x1;
      var newY = y2 - y1;

      // magnitude of the new vector
      var mag = Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2));
      lineSections[i] = mag;
    }

    // setting for the distance for each label on the map
    const maxDistance = 0.006;
    var currentDistance = 0;

    // iterate over all sections
    for (let i = 0; i < lineSections.length; i++) {
      // accumulate the current distance
      currentDistance += lineSections[i];

      // when we overstep the max Distance
      if (currentDistance > maxDistance) {
        // current point
        var x1 = tpl[i].lat;
        var y1 = tpl[i].lng;

        // next point
        var x2 = tpl[i + 1].lat;
        var y2 = tpl[i + 1].lng;

        // subtracted new vector
        var newX = x2 - x1;
        var newY = y2 - y1;

        // magnitude of the vector
        var mag = Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2));

        // normalize vector
        var newXnormalized = newX / mag;
        var newYnormalized = newY / mag;

        // go further with the remaining distance
        var overhead = currentDistance - maxDistance;

        // go back to the origin of the vector
        var endPosX = x1 + newXnormalized * overhead;
        var endPosY = y1 + newYnormalized * overhead;

        this.setLabelAt(line, [endPosX, endPosY] as L.LatLngTuple, layer);

        // var remainingMagnitude = Math.sqrt(Math.pow(overhead, 2) + Math.pow(overhead, 2));
        currentDistance = 0;
      }
    }

    return L.polyline(tpl, options);
  }

  private transformPolyLinePointToLatlng(point: Point[]): L.LatLng[] {
    const tranformedPolyLine: L.LatLng[] = [];
    for (let i = 0; i < point.length; i++) {
      tranformedPolyLine.push(new L.LatLng((point[i]).x, (point[i]).y));
    }
    return tranformedPolyLine;
  }

  private setLabelAt(line: ShuttleLine, pos: L.LatLngTuple, layer: L.LayerGroup) {
    switch (line.lineDesignator) {
      case ("P+R"):
        L.marker(pos, { icon: ShuttleLineService.IconP_R }).on("click",() => {
          this.observerService.changeDisplay(line)
        } ).addTo(layer);
        break;

      case ("7"):
        L.marker(pos, { icon: ShuttleLineService.Icon7 }).on("click",() => {
          this.observerService.changeDisplay(line)
        } ).addTo(layer);
        break;

      case ("BS"):
        L.marker(pos, { icon: ShuttleLineService.IconBS }).on("click",() => {
          this.observerService.changeDisplay(line)
        } ).addTo(layer);
        break;

      case ("9"):
        L.marker(pos, { icon: ShuttleLineService.Icon9 }).on("click",() => {
          this.observerService.changeDisplay(line)
        } ).addTo(layer);
        break;

      case ("BL"):
        L.marker(pos, { icon: ShuttleLineService.IconBL }).on("click",() => {
          this.observerService.changeDisplay(line)
        } ).addTo(layer);
        break;

      case ("6"):
        L.marker(pos, { icon: ShuttleLineService.Icon6 }).on("click",() => {
          this.observerService.changeDisplay(line)
        } ).addTo(layer);
        break;
    }

  }
}
