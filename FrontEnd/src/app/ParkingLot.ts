import {Point} from "leaflet";
import { ParkingType } from "./ParkingType";
import { Searchable } from "./Searchable";

export interface ParkingLot extends Searchable {
  id: number;
  geoLocation: Point;
  area: Array<Point>;
  entrance: Array<Point>;
  name: string;
  barrierfree: boolean;
  charging: boolean;
  parkingType: ParkingType;
  address: string;
  employeeParking: boolean;
  electricity: boolean;
  water: boolean;
  dogsAllowed: boolean;
}
