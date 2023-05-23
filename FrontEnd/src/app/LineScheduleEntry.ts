import { ShuttleLine } from "./ShuttleLine";
import {Station} from "./Station";

export class LineScheduleEntry{   // -> ist ein Punk in der Shuttleline
    id: number;
    arrivalTime: string;         // -> brauchen wir auch
    waitTime: number;
    delay: number;
    publicTransportLine: ShuttleLine;
    station : Station;
}