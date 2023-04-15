import {Point} from "leaflet";
import { ParkingType } from "./ParkingType";

export interface ParkingLot {
  id: number;
  geoLocation: Point;
  area: Array<Point>;
  entrances: Array<Point>;
  name: String;
  barrierfree: boolean;
  charging: boolean;
  parkingType: ParkingType;
}
