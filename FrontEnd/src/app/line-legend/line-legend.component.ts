import { Component } from '@angular/core';
import * as L from 'leaflet';

@Component({
  selector: 'app-line-legend',
  templateUrl: './line-legend.component.html',
  styleUrls: ['./line-legend.component.css']
})
export class LineLegendComponent {
  private static legend: L.Control;

  public addToMap(map: L.Map) {
    LineLegendComponent.legend = new L.Control({ position: "bottomleft" });
    LineLegendComponent.legend.onAdd = function (map) {
      var div = L.DomUtil.create("div", "legend-info legend");
      div.innerHTML += '<i class="legend-entry" style="background-color: #662483; border-color: #662483;"> P+R </i>' + '<br>'; // P+R
      div.innerHTML += '<i class="legend-entry" style="background-color: #ffcc00; border-color: #ffcc00;"> 7 </i>' + '<br>';   // line 7
      div.innerHTML += '<i class="legend-entry" style="background-color: #00b1da; border-color: #00b1da;"> BS </i' + '<br>';   // BS
      div.innerHTML += '<i class="legend-entry" style="background-color: #aaca47; border-color: #aaca47;"> 9 </i>' + '<br>';   // 9
      div.innerHTML += '<i class="legend-entry" style="background-color: #e1416d; border-color: #e1416d;"> BL </i>' + '<br>';  // BL
      div.innerHTML += '<i class="legend-entry" style="background-color: #956c29; border-color: #956c29;"> 6 </i>' + '<br>';   // 6
      return div;
    };
    LineLegendComponent.legend.addTo(map);
  }
}
