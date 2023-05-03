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
            var pl = this.getPolyLine(line);
            pl.addTo(this.layerGroupMarkers);
          }

          line.lineScheduleEntryList.forEach(entry => {
            this.addLineStopToMap(entry);
          });
        });
      });
    map.addLayer(this.layerGroupMarkers);
  }

  /**
   * Add a marker to the map with the line stop
   * 
   * @param map 
   * @param entry 
   * @param line 
   */
  public addLineStopToMap(entry: LineScheduleEntry): void {
    //Todo: right icon designation for trains parkingslots and shuttle line view
    var shuttleMarkerIcon = L.icon({
      iconUrl: 'assets/image/ShuttleLineEntry.png',
      iconSize: [20, 20], // size of the icon
      shadowSize: [50, 64], // size of the shadow
      iconAnchor: [10, 10], // point of the icon which will correspond to marker's location
      shadowAnchor: [4, 62],  // the same for the shadow
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });

    let marker = new L.Marker(
      [entry.geoLocation.x, entry.geoLocation.y],
      { icon: shuttleMarkerIcon }
    );
    marker.bindPopup("<span>" + entry.stationDesignator + "</span>").openPopup();
    marker.addTo(this.layerGroupMarkers);
  }

  /**
   * 
   * @param map 
   * @param line 
   * @returns 
   */
  public getPolyLine(line: ShuttleLine): L.Polyline {
    let tpl = this.transformPolyLinePointToLatlng(line.geoLinePoints);
    var options;
    if (line.lineDesignator == "BUGA Shuttlelinie") {
      
      options =
      {
        color: line.colorHexCode, 
        weight: 5, 
        opacity: 1, 
        smoothFactor: 1,
       //  dashArray: "25 20"
      };
    } else {
      options =
      {
        color: line.colorHexCode, 
        weight: 5, 
        opacity: 1, 
        moothFactor: 1
      };

    }
    return L.polyline(tpl, options);
  }

  private transformPolyLinePointToLatlng(point: Point[]): L.LatLng[] {
    var tranformedPolyLine: L.LatLng[] = [];
    for (let i = 0; i < point.length; i++) {
      tranformedPolyLine.push(new L.LatLng((point[i]).x, (point[i]).y));
    }
    return tranformedPolyLine;
  }

}
