package de.hhn.se.labswp.buga23publictransport.rnv;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = TimeStopInfoDeserializer.class)
public class TimeStopInfo {
    String hasafID;
    List<TimeInfo> timeInfo;

    public TimeStopInfo() {

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
    }
}
