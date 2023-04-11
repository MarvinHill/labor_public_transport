import { ShuttleLine } from "./ShuttleLine";

export class LineScheduleEntry{   // -> ist ein Punk in der Shuttleline
    id: number;
    arrivalTime: string;         // -> brauchen wir auch
    waitTime: number;
    delay: number;
    stationDesignator: string;    // -> ist der Name
    publicTransportLine: ShuttleLine;
}