import {ParkingLot} from "./ParkingLot";

export interface CampsiteParkingLot extends ParkingLot {
  charging: boolean;
  electricity: boolean;
  water: boolean;
  dogsAllowed: boolean;
}
