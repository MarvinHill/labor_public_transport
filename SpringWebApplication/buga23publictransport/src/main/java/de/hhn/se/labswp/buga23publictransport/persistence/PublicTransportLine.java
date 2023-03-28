package de.hhn.se.labswp.buga23publictransport.persistence;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PublicTransportLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lineDesignator;
    private boolean hasDelay;

    @OneToMany(
            mappedBy = "publicTransportLine",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<LineScheduleEntry> lineScheduleEntryList = new ArrayList<>();

    protected PublicTransportLine() {
    }
    public PublicTransportLine(String lineDesignator, boolean hasDelay, List<LineScheduleEntry> lineScheduleEntryList) {
        this.lineDesignator = lineDesignator;
        this.hasDelay = hasDelay;
        if (lineScheduleEntryList != null) {
            for (var entry : lineScheduleEntryList) {
                addLineScheduleEntry(entry);
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public boolean getDelay() {
        return hasDelay;
    }

    public String getLineDesignator() {
        return lineDesignator;
    }

    public List<LineScheduleEntry> getlineScheduleEntryList() {
        return lineScheduleEntryList;
    }

    public void addLineScheduleEntry(LineScheduleEntry lineScheduleEntry) {
        this.lineScheduleEntryList.add(lineScheduleEntry);
        lineScheduleEntry.setPublicTransportLine(this);
    }
}
