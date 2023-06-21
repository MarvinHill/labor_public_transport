import { RnvStopEvent } from "./RnvStopEvent";

export interface RnvQuery {
    cursor : string; 
    hasafID : string;
    timeInfo : RnvStopEvent[];
}