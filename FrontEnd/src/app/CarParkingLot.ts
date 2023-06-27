import {ParkingLot} from "./ParkingLot";

export interface CarParkingLot extends ParkingLot {
  charging: boolean;
  maxCapacity: number;
  employeeParking: boolean;
}
