import {Point} from "leaflet";
import { ParkingType } from "./ParkingType";

export interface ParkingLot {
  id: number;
  geoLocation: Point;
  area: Array<Point>;
  entrance: Array<Point>;
  name: String;
  barrierfree: boolean;
  charging: boolean;
  parkingType: ParkingType;
  address: String;
  maxCapacity: number;
}
