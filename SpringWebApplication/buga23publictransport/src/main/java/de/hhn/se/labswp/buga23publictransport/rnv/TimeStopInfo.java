package de.hhn.se.labswp.buga23publictransport.rnv;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = TimeStopInfoDeserializer.class)
public class TimeStopInfo {
    String cursor;
    String hasafID;
    List<TimeInfo> timeInfo = new ArrayList<>();

    public TimeStopInfo() {

    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public String getHasafID() {
        return hasafID;
    }

    public void setHasafID(String hasafID) {
        this.hasafID = hasafID;
    }

    public void setTimeInfo(List<TimeInfo> timeInfo) {
        this.timeInfo = timeInfo;
    }

    public List<TimeInfo> getTimeInfo() {
        return timeInfo;
    }

    public static class TimeInfo {

        String lineGroup;
        String plannedDeparture;
        String realtimeDeparture;
        String destinationLabel;

        public TimeInfo() {
        }


        public void setLineGroup(String lineGroup) {
            this.lineGroup = lineGroup;
        }

        public String getLineGroup() {
            return lineGroup;
        }

        public void setPlannedDeparture(String plannedDeparture) {
            this.plannedDeparture = plannedDeparture;
        }

        public String getPlannedDeparture() {
            return plannedDeparture;
        }

        public void setRealtimeDeparture(String realtimeDeparture) {
            this.realtimeDeparture = realtimeDeparture;
        }

        public String getRealtimeDeparture() {
            return realtimeDeparture;
        }

        public String getDestinationLabel() {
            return destinationLabel;
        }

        public void setDestinationLabel(String destinationLabel) {
            this.destinationLabel = destinationLabel;
        }
    }
}
