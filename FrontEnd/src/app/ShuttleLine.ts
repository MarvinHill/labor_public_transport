import { LineScheduleEntry } from "./LineScheduleEntry";
import { Point } from "leaflet";

export class ShuttleLine {
    id: number;
    lineDesignator: string;
    hasDelay: boolean;
    lineScheduleEntryList: LineScheduleEntry[];
    geoLinePoints: Object[];
}
