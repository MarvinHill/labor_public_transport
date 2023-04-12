import { Point } from "leaflet";
import { ShuttleLine } from "./ShuttleLine";

export class LineScheduleEntry{
    id: number;
    arrivalTime: string;
    waitTime: number;
    delay: number;
    stationDesignator: string;
    publicTransportLine: ShuttleLine;
    geoLocation: Point;
}