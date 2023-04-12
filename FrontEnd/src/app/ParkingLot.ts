import {Point, Polygon} from "leaflet";
import { ParkingType } from "./ParkingType";

export class ParkingLot {
  id: number;
  geoLocation: Point;
  area: Polygon;
  entrances: Array<Point>
  name: String;
  barrierfree: boolean;
  charging: boolean;
  parkingType: ParkingType;
}
