import { LineScheduleEntry } from "./LineScheduleEntry";
import { Point } from "leaflet";
import { Searchable } from "./Searchable";

export class ShuttleLine implements Searchable{
    searchAction: Function;
    category: string;
    displayText: string;
    id: number;
    lineDesignator: string;
    hasDelay: boolean;
    lineScheduleEntryList: LineScheduleEntry[];
    geoLinePoints: Point[];
    colorHexCode: string;
}
