import { Injectable } from '@angular/core';
import { ShuttleLine } from '../ShuttleLine';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { LineScheduleEntry } from '../LineScheduleEntry';
import * as L from 'leaflet';
import { Point } from 'leaflet';

@Injectable({
  providedIn: 'root'
})
export class ShuttleLineService {
  private http: HttpClient;
  private layerGroupMarkers: L.LayerGroup = L.layerGroup();
  private lines: ShuttleLine[];

  constructor(http: HttpClient) {
    this.http = http;
  }

  public getShuttleLines(): Observable<ShuttleLine[]> {
    return this.http.get<ShuttleLine[]>('http://localhost:8080/ptl');
  }

  public getShuttleLine(id: number): Observable<ShuttleLine> {
    return this.http.get<ShuttleLine>('http://localhost:8080/ptl/' + id);
  }

  /**
   * 
   * @param map 
   */
  public initShuttleLineViewOnMap(map: L.Map): void {
    this.getShuttleLines().subscribe(
      lines => {
        this.lines = lines;
        this.lines.forEach(line => {
          // draw the real train or shuttle line into the map
          if (line.geoLinePoints.length > 0) {
            this.drawLineToMap(map, line);
          }

          line.lineScheduleEntryList.forEach(entry => {
            // add marker to the layer and add it to the map
            this.addLineStopToMap(map, entry, line);
          });
        });
      });
  }

  /**
   * Add a marker to the map with the line stop
   * 
   * @param map 
   * @param entry 
   * @param line 
   */
  public addLineStopToMap(map: L.Map, entry: LineScheduleEntry, line: ShuttleLine): void {
    //Todo: right icon designation for trains parkingslots and shuttle line view
    var shuttleMarkerIcon = L.icon({
      iconUrl: 'assets/image/shuttle.png',
      iconSize: [60, 60], // size of the icon
      shadowSize: [50, 64], // size of the shadow
      iconAnchor: [30, 60], // point of the icon which will correspond to marker's location
      shadowAnchor: [4, 62],  // the same for the shadow
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });

    var trainMarkerIcon = L.icon({
      iconUrl: 'assets/image/train.png',
      iconSize: [60, 60], // size of the icon
      shadowSize: [50, 64], // size of the shadow
      iconAnchor: [30, 60], // point of the icon which will correspond to marker's location
      shadowAnchor: [4, 62],  // the same for the shadow
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });

    if (line.lineDesignator == "BUGA Shuttlelinie") {
      let marker = new L.Marker(
        [entry.geoLocation.x, entry.geoLocation.y],
        { icon: shuttleMarkerIcon }
      );
      marker.bindPopup("<span>" + entry.stationDesignator + "</span>").openPopup();
      marker.addTo(this.layerGroupMarkers);
    } else {
      let marker = new L.Marker(
        [entry.geoLocation.x, entry.geoLocation.y],
        { icon: trainMarkerIcon }
      );
      marker.bindPopup("<span>" + entry.stationDesignator + "</span>").openPopup();
      marker.addTo(this.layerGroupMarkers);
    }
    map.addLayer(this.layerGroupMarkers);
  }

  /**
   * 
   * @param map 
   * @param line 
   * @returns 
   */
  public drawLineToMap(map: L.Map, line: ShuttleLine): L.Polyline {
    let fpl = this.transformPolyLinePointToLatlng(line.geoLinePoints);
    return L.polyline(fpl, { color: line.colorHexCode, weight: 5, opacity: 1, smoothFactor: 1 }).addTo(map);
  }

  private transformPolyLinePointToLatlng(point: Point[]): L.LatLng[] {
    var tranformedPolyLine: L.LatLng[] = [];
    for (let i = 0; i < point.length; i++) {
      tranformedPolyLine.push(new L.LatLng((point[i]).y, (point[i]).x));
    }
    return tranformedPolyLine;
  }


}
