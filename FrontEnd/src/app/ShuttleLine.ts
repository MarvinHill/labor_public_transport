import { LineScheduleEntry } from "./LineScheduleEntry";

export class ShuttleLine {
    id: number;
    lineDesignator: string;
    hasDelay: boolean;
    lineScheduleEntryList: LineScheduleEntry[]
    length: number;
    
}