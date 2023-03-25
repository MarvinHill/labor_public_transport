import { LineScheduleEntry } from "./LineScheduleEntry";

export class ShuttleLine{
    id : number;
    type : number;
    lineDesignator: string;
    hasDelay: boolean;
    lineScheduleEntryList: LineScheduleEntry[]
}