import { ElementRef, HostListener, Injectable, OnInit, ViewChild } from '@angular/core';
import * as L from 'leaflet';
import { LatLng } from 'leaflet';
import { interval } from 'rxjs';
import { ParkingLot } from '../ParkingLot';
import { DataServiceService } from '../services/data-service.service';
import { MapDetailsObserverService } from '../services/map-details-observer.service';
import { UserLoginServiceService } from '../services/user-login-service.service';
import { ShuttleLineService } from '../services/shuttle-line.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import 'bootstrap/dist/js/bootstrap.min.js';
import { SearchService } from './search.service';
import { LineLegendComponent } from '../line-legend/line-legend.component';

@Injectable({
  providedIn: 'root'
})
export class MapService {

  private map: L.Map;
  public centroid: L.LatLngExpression = [49.485, 8.5];

  public minimized: boolean = true;

  public mapContainerClass: string = "map-container-small-desktop";
  public resizeButtonClass: string = "button-min";
  public locateButtonClass: string = "button-min";
  public bugaBackButtonClass: string = "button-min";
  public speechBubbleClass: string = "speech-bubble-min";

  private userService: UserLoginServiceService;

  public isLoggedIn: boolean = true;
  public mapHeight: string = "10em";

  userLocation = new L.LayerGroup;
  carParkingLots = new L.LayerGroup;
  carParkingLotEntrances = new L.LayerGroup;
  campsiteParkingLot = new L.LayerGroup;
  publicTransportLines = [];
  bugaArea = new L.LayerGroup;
  bikeParkingLots = new L.LayerGroup;
  entrances = new L.LayerGroup;
  exits = new L.LayerGroup;
  layerOptions: L.Control.LayersOptions = {
    position: "bottomright",
  }
  layerControl = L.control.layers(null, null, this.layerOptions);


  @ViewChild('container', { static: false }) container: ElementRef;
  @ViewChild('bugaBackButton', { static: false }) bugaBackButton: ElementRef;


  windowHeight: number;
  windowWidth: number;
  topBarHeight: number;
  public innerWidth: number = 1000;
  breakPoint: number = 720;

  constructor(userService: UserLoginServiceService, private dataService: DataServiceService, protected observerService: MapDetailsObserverService
    ,  private shuttleLineService: ShuttleLineService, private snackbar: MatSnackBar) {
    this.userService = userService;
    this.userService.isLoggedIn.subscribe(value => {
      this.isLoggedIn = value;
    });
  }

  makeLayerControls() {
    this.layerControl.addOverlay(this.userLocation, "Position");
    this.layerControl.addOverlay(this.carParkingLots, "Autoparkplätze");
    this.layerControl.addOverlay(this.bikeParkingLots, "Fahrradparkplätze");
    this.layerControl.addOverlay(this.campsiteParkingLot, "Wohnmobilstellplätze");
    this.layerControl.addOverlay(this.entrances, "Eingänge");
    this.layerControl.addOverlay(this.exits, "Ausgänge")
    this.publicTransportLines.forEach(entry => {
      this.layerControl.addOverlay(entry[0], entry[1]);
    });
    this.layerControl.addTo(this.map);
  }

  public initMap(): void {


    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 10,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);

    this.locateUser();

    this.makeLayerControls();

    this.dataService.carParking.subscribe(values => {

      values.forEach(element => {
        this.makeCarParking(element);
      });
    })
    this.dataService.bikeParking.subscribe(values => {

      values.forEach(element => {
        this.makeBikeParking(element);
      });
    })
    this.dataService.campsiteParking.subscribe(values => {

      values.forEach(element => {
        this.makeCampsiteParking(element);
      });
    })

    this.dataService.getAllCarParking();

    this.dataService.getAllBikeParking();

    this.dataService.getAllCampsiteParking();

    this.map.addLayer(this.userLocation);

    this.map.addLayer(this.carParkingLots);

    this.map.addLayer(this.bikeParkingLots);

    this.map.addLayer(this.campsiteParkingLot);

    this.map.addLayer(this.bugaArea);

    this.map.addLayer(this.entrances)

    this.map.addLayer(this.exits);
    this.map.removeLayer(this.exits); // Default = wird nicht angezeigt

    this.publicTransportLines.forEach(entry => {
      this.map.addLayer(entry[0]);
    });

    this.map.addEventListener("click", function (e: any) {
      this.observerService.changeVisibility(false);
    }.bind(this));

    this.detectMapMovement();
  }

  makeCarParking(parkinglot: ParkingLot) {
    var parkingIcon = L.icon({
      iconUrl: 'assets/icon/parking/MarkerCar.png',
      iconSize: [45, 72], // size of the icon
      iconAnchor: [22.5, 70], // point of the icon which will correspond to marker's location
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });
    if (parkinglot.charging === true) {
      parkingIcon = L.icon({
        iconUrl: 'assets/icon/parking/MarkerECar.png',
        iconSize: [45, 72], // size of the icon
        iconAnchor: [22.5, 70], // point of the icon which will correspond to marker's location
        popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
      });
    }
    if (parkinglot.area.length > 0) {
      var arr = [];
      for (var i = 0; i < parkinglot.area.length; i++) {
        arr.push([parkinglot.area.at(i).x, parkinglot.area.at(i).y]);
      }
      var poly = L.polygon(arr, { color: '#0677e0' }).addTo(this.carParkingLots);
      var marker = L.marker(poly.getCenter(), { icon: parkingIcon });
    }
    else {
      var marker = L.marker([parkinglot.geoLocation.x, parkinglot.geoLocation.y], { icon: parkingIcon });
    }

    marker.on("click", function (e: any) {
      this.observerService.changeDisplay(parkinglot)
    }.bind(this));
    marker.addTo(this.carParkingLots);

    var entranceIcon = L.icon({
      iconUrl: 'assets/icon/parking/Entrance.png',
      iconSize: [15, 15], // size of the icon
      iconAnchor: [7.5, 7.5], // point of the icon which will correspond to marker's location
      popupAnchor: [7.5, 15] // point from which the popup should open relative to the iconAnchor
    });

    if (parkinglot.entrance.length > 0) {
      for (var i = 0; i < parkinglot.entrance.length; i++) {
        L.marker([parkinglot.entrance.at(i).x, parkinglot.entrance.at(i).y], { icon: entranceIcon }).addTo(this.carParkingLotEntrances);
      }
    }

    this.map.on("zoomend", function (e) {
      if (this.map.getZoom() < 16) {
        this.carParkingLotEntrances.remove();
      }
      else {
        if (this.map.hasLayer(this.carParkingLots)) {
          this.carParkingLotEntrances.addTo(this.map);
        }
      }
    }.bind(this));
  }

  makeBikeParking(bikeparking: ParkingLot) {
    var parkingIcon = L.icon({
      iconUrl: 'assets/icon/parking/MarkerBike.png',
      iconSize: [45, 72], // size of the icon
      iconAnchor: [22.5, 70], // point of the icon which will correspond to marker's location
      popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
    });
    if (bikeparking.area.length > 0) {
      var arr = [];
      for (var i = 0; i < bikeparking.area.length; i++) {
        arr.push([bikeparking.area.at(i).x, bikeparking.area.at(i).y]);
      }
      var poly = L.polygon(arr, { color: '#0677e0' }).addTo(this.bikeParkingLots);
      var marker = L.marker(poly.getCenter(), { icon: parkingIcon }).addTo(this.bikeParkingLots);
    }
    else {
      var marker = L.marker([bikeparking.geoLocation.x, bikeparking.geoLocation.y], { icon: parkingIcon }).addTo(this.bikeParkingLots);
    }
    marker.on("click", function (e: any) {
      this.observerService.changeDisplay(bikeparking)
    }.bind(this));
  }

  makeCampsiteParking(campsite: ParkingLot) {
    if (campsite.area.length > 0) {
      var arr = [];
      for (var i = 0; i < campsite.area.length; i++) {
        arr.push([campsite.area.at(i).x, campsite.area.at(i).y]);
      }
      var markerLat;
      var markerLon;
      var poly;
      var parkingIcon;
      if(campsite.name.includes("P6") || campsite.name.includes("P7") || campsite.name.includes("P8")) {
        poly = L.polygon(arr, { color: '#0677e0' }).addTo(this.campsiteParkingLot);
        markerLat = poly.getCenter().lat;
        markerLon = poly.getCenter().lng + 0.00050;
        parkingIcon = L.icon({
          iconUrl: 'assets/icon/parking/Caravan.svg',
          iconSize: [45, 72], // size of the icon
          iconAnchor: [22.5, 70], // point of the icon which will correspond to marker's location
          popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
        });
      }
      else {
        poly = L.polygon(arr, { color: '#C830EE' }).addTo(this.campsiteParkingLot);
        markerLat = poly.getCenter().lat;
        markerLon = poly.getCenter().lng;
        parkingIcon = L.icon({
          iconUrl: 'assets/icon/parking/Camping.svg',
          iconSize: [45, 72], // size of the icon
          iconAnchor: [22.5, 70], // point of the icon which will correspond to marker's location
          popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
        });
      }
      var marker = L.marker([markerLat, markerLon], { icon: parkingIcon }).addTo(this.campsiteParkingLot);
    }
    else {
      var marker = L.marker([campsite.geoLocation.x, campsite.geoLocation.y], { icon: parkingIcon }).addTo(this.campsiteParkingLot);
    }

    var entranceIcon = L.icon({
      iconUrl: 'assets/icon/parking/Entrance.png',
      iconSize: [15, 15], // size of the icon
      iconAnchor: [7.5, 7.5], // point of the icon which will correspond to marker's location
      popupAnchor: [7.5, 15] // point from which the popup should open relative to the iconAnchor
    });

    if (campsite.entrance.length > 0) {
      for (var i = 0; i < campsite.entrance.length; i++) {
        L.marker([campsite.entrance.at(i).x, campsite.entrance.at(i).y], { icon: entranceIcon }).addTo(this.carParkingLotEntrances);
      }
    }
    marker.on("click", function (e: any) {
      this.observerService.changeDisplay(campsite)
    }.bind(this));
  }

  drawBugaArea() {
    var luisenParkPoly: [number, number][] = [
      [49.48034150000, 8.49376110000],
      [49.48033310000, 8.49376800000],
      [49.48028010000, 8.49381850000],
      [49.48025650000, 8.49380680000],
      [49.48023670000, 8.49380590000],
      [49.48021090000, 8.49381420000],
      [49.48018930000, 8.49382990000],
      [49.48017010000, 8.49385760000],
      [49.48016050000, 8.49388620000],
      [49.48015150000, 8.49392590000],
      [49.48000700000, 8.49406620000],
      [49.47997580000, 8.49412980000],
      [49.47980980000, 8.49443170000],
      [49.47957490000, 8.49493370000],
      [49.47932080000, 8.49556160000],
      [49.47935560000, 8.49581230000],
      [49.47936960000, 8.49582740000],
      [49.47917240000, 8.49634750000],
      [49.47918610000, 8.49636210000],
      [49.47927540000, 8.49632530000],
      [49.47942930000, 8.49645750000],
      [49.47977070000, 8.49642090000],
      [49.47983860000, 8.49642980000],
      [49.48006760000, 8.49661650000],
      [49.48023880000, 8.49664520000],
      [49.48050570000, 8.49683720000],
      [49.48036660000, 8.49720100000],
      [49.48046200000, 8.49727160000],
      [49.48005180000, 8.49857510000],
      [49.48000180000, 8.49873480000],
      [49.47997540000, 8.49881850000],
      [49.48005030000, 8.49899740000],
      [49.48012110000, 8.49908380000],
      [49.48023400000, 8.49920570000],
      [49.48078970000, 8.49937750000],
      [49.48084540000, 8.49892010000],
      [49.48093520000, 8.49897270000],
      [49.48105110000, 8.49903600000],
      [49.48098300000, 8.49947840000],
      [49.48107370000, 8.49968200000],
      [49.48136970000, 8.49974780000],
      [49.48155140000, 8.50037360000],
      [49.48187820000, 8.50046100000],
      [49.48208060000, 8.50051080000],
      [49.48219080000, 8.50042210000],
      [49.48274250000, 8.50058210000],
      [49.48274610000, 8.50056100000],
      [49.48281010000, 8.50060580000],
      [49.48334080000, 8.50076100000],
      [49.48337090000, 8.50082590000],
      [49.48335960000, 8.50095330000],
      [49.48340550000, 8.50106420000],
      [49.48386650000, 8.50060210000],
      [49.48389040000, 8.50057930000],
      [49.48427510000, 8.50064340000],
      [49.48439450000, 8.50072850000],
      [49.48449830000, 8.50079420000],
      [49.48457750000, 8.50054140000],
      [49.48467190000, 8.50048140000],
      [49.48483240000, 8.49993770000],
      [49.48477710000, 8.49978970000],
      [49.48539890000, 8.49766080000],
      [49.48507210000, 8.49775420000],
      [49.48477260000, 8.49756640000],
      [49.48423240000, 8.49651230000],
      [49.48447690000, 8.49561860000],
      [49.48433780000, 8.49503580000],
      [49.48478520000, 8.49348850000],
      [49.48577570000, 8.49315830000],
      [49.48624190000, 8.49357730000],
      [49.48646790000, 8.49280900000],
      [49.48652140000, 8.49262720000],
      [49.48641900000, 8.49227930000],
      [49.48648620000, 8.49217620000],
      [49.48666670000, 8.49190890000],
      [49.48671290000, 8.49174280000],
      [49.48683460000, 8.49132740000],
      [49.48677690000, 8.49110920000],
      [49.48709290000, 8.49088580000],
      [49.48730360000, 8.49074820000],
      [49.48755690000, 8.49058290000],
      [49.48754080000, 8.48992910000],
      [49.48731410000, 8.48993710000],
      [49.48710200000, 8.48975910000],
      [49.48705540000, 8.48982750000],
      [49.48698830000, 8.48978070000],
      [49.48680900000, 8.48952360000],
      [49.48678340000, 8.48931510000],
      [49.48674620000, 8.48923840000],
      [49.48669120000, 8.48919860000],
      [49.48683300000, 8.48869550000],
      [49.48683480000, 8.48868890000],
      [49.48684920000, 8.48869890000],
      [49.48695470000, 8.48833590000],
      [49.48680540000, 8.48822690000],
      [49.48675140000, 8.48818950000],
      [49.48662120000, 8.48822760000],
      [49.48655340000, 8.48848830000],
      [49.48658990000, 8.48851840000],
      [49.48658240000, 8.48854260000],
      [49.48643130000, 8.48904620000],
      [49.48488190000, 8.48791220000],
      [49.48479000000, 8.48828850000],
      [49.48411220000, 8.48967540000],
      [49.48380300000, 8.49043660000],
      [49.48373010000, 8.49077890000],
      [49.48344890000, 8.49145420000],
      [49.48301780000, 8.49107510000],
      [49.48297120000, 8.49118800000],
      [49.48288780000, 8.49136780000],
      [49.48333320000, 8.49176370000],
      [49.48306590000, 8.49227740000],
      [49.48267030000, 8.49266740000],
      [49.48230710000, 8.49291400000],
      [49.48191000000, 8.49316050000],
      [49.48177730000, 8.49273370000],
      [49.48161330000, 8.49285740000],
      [49.48172520000, 8.49321940000],
      [49.48113840000, 8.49365490000],
      [49.48093700000, 8.49380440000],
      [49.48073480000, 8.49395440000],
      [49.48067720000, 8.49399720000],
      [49.48045330000, 8.49416330000],
      [49.48034150000, 8.49376110000]
    ];
    L.polygon(luisenParkPoly, { color: '#e1416d' }).addTo(this.bugaArea);

    var spinelliParkPoly: [number, number][] = [
      [49.49853330000, 8.51280300000],
      [49.49808640000, 8.51285800000],
      [49.49801330000, 8.51335820000],
      [49.49794900000, 8.51335450000],
      [49.49777520000, 8.51450710000],
      [49.49760490000, 8.51537000000],
      [49.49742280000, 8.51611560000],
      [49.49727310000, 8.51662190000],
      [49.49705940000, 8.51717800000],
      [49.49680920000, 8.51769580000],
      [49.49664360000, 8.51801950000],
      [49.49589110000, 8.51927430000],
      [49.49565650000, 8.51962340000],
      [49.49532380000, 8.52014260000],
      [49.49526260000, 8.52025650000],
      [49.49516920000, 8.52050030000],
      [49.49520470000, 8.52091460000],
      [49.49576960000, 8.52079330000],
      [49.49582040000, 8.52123230000],
      [49.49611870000, 8.52118280000],
      [49.49672990000, 8.52103920000],
      [49.49706390000, 8.52094200000],
      [49.49771920000, 8.52078650000],
      [49.49772800000, 8.52097100000],
      [49.49773550000, 8.52111030000],
      [49.49779410000, 8.52168910000],
      [49.49780890000, 8.52183540000],
      [49.49783360000, 8.52207720000],
      [49.49786910000, 8.52243160000],
      [49.49787750000, 8.52253300000],
      [49.49788380000, 8.52260810000],
      [49.49794370000, 8.52284580000],
      [49.49794930000, 8.52290110000],
      [49.49807610000, 8.52414240000],
      [49.49808200000, 8.52419990000],
      [49.49842440000, 8.52483510000],
      [49.49839110000, 8.52496860000],
      [49.50073880000, 8.52592620000],
      [49.50078610000, 8.52594530000],
      [49.50148900000, 8.52623070000],
      [49.50258980000, 8.52667270000],
      [49.50280030000, 8.52538510000],
      [49.50282690000, 8.52522150000],
      [49.50314380000, 8.52325700000],
      [49.50347050000, 8.52338210000],
      [49.50360100000, 8.52256740000],
      [49.50287700000, 8.52163950000],
      [49.50296230000, 8.52032890000],
      [49.50306180000, 8.51879980000],
      [49.50324560000, 8.51597370000],
      [49.50325370000, 8.51584870000],
      [49.50282020000, 8.51581510000],
      [49.50243870000, 8.51509360000],
      [49.50301290000, 8.51447960000],
      [49.50285170000, 8.51400520000],
      [49.50217090000, 8.51471370000],
      [49.50197640000, 8.51491610000],
      [49.50031180000, 8.51216730000],
      [49.49980490000, 8.51130610000],
      [49.49959520000, 8.51128530000],
      [49.49914230000, 8.51176870000],
      [49.49876240000, 8.51216730000],
      [49.49855330000, 8.51219010000],
      [49.49850190000, 8.51232290000],
      [49.49853330000, 8.51280300000]
    ];
    L.polygon(spinelliParkPoly, { color: '#e1416d' }).addTo(this.bugaArea);

    var cableCarLine: [number, number][] = [
      [49.4827573, 8.4998941],
      [49.4829827, 8.5002318],
      [49.4837367, 8.5013620],
      [49.4840907, 8.5018928],
      [49.4865189, 8.5055329],
      [49.4888884, 8.5090850],
      [49.4909743, 8.5122122],
      [49.4929656, 8.5151976],
      [49.4951028, 8.5184020],
      [49.4958370, 8.5195028],
      [49.4960904, 8.5198828],
      [49.4962948, 8.5201892]
    ];
    L.polyline(cableCarLine, { color: '#e1416d' }).addTo(this.bugaArea);

  }
  makeEntrances(){
    var entranceIcon = L.icon({
      iconUrl: 'assets/icon/Entrance.png',
      iconSize:     [45, 72], // size of the icon
      iconAnchor:   [22.5, 70], // point of the icon which will correspond to marker's location
      popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
    });
  var haupteingangLuisenpark = L.marker([49.47938, 8.49609], {icon: entranceIcon}).addTo(this.entrances);
  var eingangFernmeldeturm = L.marker([49.48643, 8.49230], {icon: entranceIcon}).addTo(this.entrances);
  var haupteingangSpinellipark = L.marker([49.49772, 8.52095], {icon: entranceIcon}).addTo(this.entrances);
  var eingangParkschale = L.marker([49.502722, 8.518795], {icon: entranceIcon}).addTo(this.entrances);

  haupteingangLuisenpark.bindPopup("<b>Haupteingang Luisenpark</b> <br> Einlass: 9 - 19 Uhr").openPopup();
  eingangFernmeldeturm.bindPopup("<b>Eingang Fernmeldeturm</b> <br> Einlass: 9 - 19 Uhr");
  haupteingangSpinellipark.bindPopup("<b>Haupteingang Spinellipark</b> <br> Einlass: 9 - 19 Uhr");
  eingangParkschale.bindPopup("<b>Eingang Parkschale</b> <br> Einlass: 9 - 19 Uhr");


  }

  makeExits(){
    var exitIcon = L.icon({
      iconUrl: 'assets/icon/Exit.png',
      iconSize:     [45, 72], // size of the icon
      iconAnchor:   [22.5, 70], // point of the icon which will correspond to marker's location
      popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
    });
  var ausgangOttoBeckStraße = L.marker([49.484908, 8.488246], {icon: exitIcon}).addTo(this.exits);
  var ausgangFichtestraße = L.marker([49.483051, 8.491305], {icon: exitIcon}).addTo(this.exits);
  var ausgangAmOberenLuisenpark = L.marker([49.479891, 8.494275], {icon: exitIcon}).addTo(this.exits);
  var ausgangPaulMartinUfer = L.marker([49.483305, 8.501183], {icon: exitIcon}).addTo(this.exits);
  var ausgangSpinelliPark = L.marker([49.497048, 8.520173], {icon: exitIcon}).addTo(this.exits);
  //var ausgangKantineIris = L.marker([49.497885, 8.520818], {icon: exitIcon}).addTo(this.exits);
  var ausgangNeuerBugaWeg = L.marker([49.498066, 8.522661], {icon: exitIcon}).addTo(this.exits);
  var ausgangWachenheimerStraße = L.marker([49.502006, 8.515099], {icon: exitIcon}).addTo(this.exits);

  }

  init(map: L.Map): void {
    this.map = map;
    var inter = interval(100);
    inter.subscribe(v => {
      this.map.invalidateSize();
    })
    this.shuttleLineService.initShuttleLineViewOnMap(this.publicTransportLines, this);
    new LineLegendComponent().addToMap(map);
    this.innerWidth = window.innerWidth;
    this.updateHeight();
    this.updateWidth();
    this.updateMobileDesktopMap();
    this.drawBugaArea();
    this.makeEntrances();
    this.makeExits();
  }

  maximizeMap(): void {
    if (this.minimized) {
      this.minimized = false;

      this.layerControl.addTo(this.map);
      this.mapContainerClass = "map-container-large shadow";
      this.resizeButtonClass = "resize-button-max shadow";
      this.locateButtonClass = "locate-button-max shadow";
      this.bugaBackButtonClass = "buga-back-button-max shadow";
      this.speechBubbleClass = "speech-bubble pright acenter";
      this.updateHeight()
      this.updateWidth();
    }
    this.map.invalidateSize();
  }

  minimizeMap(): void {
    if (!this.minimized) {
      this.minimized = true;

      this.map.removeControl(this.layerControl);
      this.updateMobileDesktopMap();
      this.resizeButtonClass = "button-min";
      this.locateButtonClass = "button-min";
      this.bugaBackButtonClass = "button-min";
      this.speechBubbleClass = "speech-bubble-min button-min";
      this.updateHeight()
      this.updateWidth();
    }
    this.map.invalidateSize();
  }

  resizeMap(): void {
    if (this.minimized) {
      this.maximizeMap();
    } else {
      this.minimizeMap();
    }
    this.map.invalidateSize();
  }

  public updateMobileDesktopMap() {
    if ((this.innerWidth < this.breakPoint) && this.minimized) {
      this.mapContainerClass = "map-container-small-mobile shadow";
    } else if (this.minimized) {
      this.mapContainerClass = "map-container-small-desktop shadow";
    }
  }

  public updateHeight() {
    this.computeMaxHeight();
    document.getElementById("map-container").style.height = this.mapHeight;
  }
  public updateWidth() {
    this.windowWidth = window.innerWidth
  }

  public computeMaxHeight() {
    this.windowHeight = window.innerHeight;
    this.topBarHeight = document.getElementById("top-bar").offsetHeight;
    if (this.minimized) {
      if (this.innerWidth < this.breakPoint) {
        this.mapHeight = "5em";
      }
      else {
        this.mapHeight = "10em";
      }
    }
    else {
      this.mapHeight = (this.windowHeight - this.topBarHeight).toString() + "px";
    }
  }

  locateUser(): any {
    const userLocationGroup = this.userLocation;
    this.map.locate({ setView: true }).on('locationfound', function (e) {

      var locationIcon = L.icon({
        iconUrl: 'assets/icon/wavingPerson.gif',
        iconSize: [60, 72], // size of the icon
        iconAnchor: [22.5, 70], // point of the icon which will correspond to marker's location
        popupAnchor: [-3, -76] // point from which the popup should open relative to the iconAnchor
      });

      const location = e.latlng;

      userLocationGroup.clearLayers();
      var marker = L.marker(location, { icon: locationIcon }).addTo(userLocationGroup);
      marker.on("click", function (e) {
        marker.bindPopup("You are Here!").openPopup();
      })
    });
    this.userLocation = userLocationGroup;
  }

  moveToBuga() : any {
    /* visual output for the user, letting him know that he is already at the Buga */
    if(this.map.getCenter().lat >= 49.49021061654624 && this.map.getCenter().lat <= 49.49127559245556 && this.map.getCenter().lng >= 8.508478545177866 && this.map.getCenter().lng <= 8.510290295871553) {
      this.snackbar.open("Du bist bereits an der Buga", 'Schließen', {
        verticalPosition: 'bottom',
      });
    }
    /* move to the Buga */
    else {
      this.map.setView(new LatLng(49.4906602, 8.5092189), 14);
    }
  }

  /* boolean value for the button to hide the speech-bubble */
  xPressed: boolean = false;

  detectMapMovement(): void {
    this.map.on('move', () => {
      /* check if the user is near the Buga */
      if(this.map.getCenter().lat >= 49.36289598710729 && this.map.getCenter().lat <= 49.615075626689 && this.map.getCenter().lng >= 8.299441337585451 && this.map.getCenter().lng <= 8.695807456970217) {
        /* hide speech-bubble */
        document.getElementById('speech-bubble-id').style.display = 'none';
        this.xPressed = false;
      }
      /* show speech-bubble */
      else if(!this.xPressed) {
        document.getElementById('speech-bubble-id').style.display = 'block';
      }
    });
  }

  hideContainer() {
      document.getElementById('speech-bubble-id').style.display = 'none';
      this.xPressed = true;
  }

  public openAndFlyTo(pos: LatLng): void {
    this.maximizeMap();
    //this.observerService.changeVisibility(false);
    this.map.flyTo(pos, 18);
  }
}


