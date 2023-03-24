package de.hhn.se.labswp.buga23publictransport.persistence;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PublicTransportLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int type;
    private String lineDesignator;
    private boolean hasDelay;
    @ElementCollection
    private List<LineScheduleEntry> lineScheduleEntryArrayList;

    protected PublicTransportLine() {}

    public PublicTransportLine(int type, String lineDesignator, boolean hasDelay, List<LineScheduleEntry> lineScheduleEntryArrayList) {
        this.type = type;
        this.lineDesignator = lineDesignator;
        this.hasDelay = hasDelay;
        this.lineScheduleEntryArrayList = lineScheduleEntryArrayList;
    }

    public Long getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public boolean getDelay() {
        return hasDelay;
    }

    public String getLineDesignator() {
        return lineDesignator;
    }

    public List<LineScheduleEntry> getLineScheduleEntryArrayList() {
        return lineScheduleEntryArrayList;
    }
}
