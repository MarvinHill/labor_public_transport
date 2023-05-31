import { LineScheduleEntry } from "./LineScheduleEntry";
import { Point } from "leaflet";
import { Searchable } from "./Searchable";

export class ShuttleLine implements Searchable{
    category: string;
    displayText: string;
    routingLocation: string;
    id: number;
    lineDesignator: string;
    hasDelay: boolean;
    lineScheduleEntryList: LineScheduleEntry[];
    geoLinePoints: Point[];
    colorHexCode: string;
}
