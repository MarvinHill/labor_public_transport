import { Point } from "leaflet"
import { RnvQuery } from "./RnvQuery";

export interface Station {
    geoLocation : Point;
    stationDesignator : string;
    timeInfoJSON : string;
}