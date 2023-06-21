package de.hhn.se.labswp.buga23publictransport.rnv.persistence;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.hhn.se.labswp.buga23publictransport.rnv.TimeStopInfoDeserializer;
import de.hhn.se.labswp.buga23publictransport.rnv.persistence.TimeInfo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = TimeStopInfoDeserializer.class)
public class TimeStopInfo {
    String cursor;
    String hasafID;
    List<TimeInfo> timeInfo = new ArrayList<>();

    public TimeStopInfo() {

    }

    public TimeStopInfo(String cursor, String hasafID, List<TimeInfo> timeInfo) {

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
}
