package de.hhn.se.labswp.buga23publictransport.rnv.persistence;

public class TimeInfo {
    public String lineGroup;
    public String plannedDeparture;
    public String realtimeDeparture;
    public String destinationLabel;

    public TimeInfo() {
    }

    public TimeInfo(String lineGroup,
                    String plannedDeparture,
                    String realtimeDeparture,
                    String destinationLabel) {
        this.lineGroup = lineGroup;
        this.plannedDeparture = plannedDeparture;
        this.realtimeDeparture = realtimeDeparture;
        this.destinationLabel = destinationLabel;
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
