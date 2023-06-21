export class TimeStopInfo {
    hasafID: String;
    timeInfo: Array<TimeInfo>;
};

export class TimeInfo {
    lineGroup: String;
    plannedDeparture: String;
    realtimeDeparture: String;
    destinationLabel: String;
}