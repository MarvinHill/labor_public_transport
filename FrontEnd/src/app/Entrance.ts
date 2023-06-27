import { Point } from "leaflet";


export class Entrance {
    constructor(
        public geoLocation : Point, 
        public entranceDescription : string, 
        public openingHours : string
        ) {}
}