package de.hhn.se.labswp.buga23publictransport.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import java.time.LocalTime;
import java.util.*;

@Entity
@Table(name = "line_schedule_entry")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class LineScheduleEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime arrivalTime;
    private int waitTime;
    private int delay;
    private String stationDesignator;
    private Point geoLocation;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "lineScheduleEntryList", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<PublicTransportLine> publicTransportLines = new HashSet<>();

    public LineScheduleEntry() {
    }

    public LineScheduleEntry(
            LocalTime arrivalTime,
            int waitTime,
            int delay,
            String stationDesignator,
            double longitude,
            double latitude) {
        this.arrivalTime = arrivalTime;
        this.waitTime = waitTime;
        this.delay = delay;
        this.stationDesignator = stationDesignator;
        this.geoLocation = new Point(longitude, latitude);
    }

    public Long getId() {
        return this.id;
    }

    public int getDelay() {
        return this.delay;
    }

    public int getWaitTime() {
        return this.waitTime;
    }

    public LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    public String getStationDesignator() {
        return this.stationDesignator;
    }

    public void addPublicTransportLine(PublicTransportLine ptl) {
        this.publicTransportLines.add(ptl);
        ptl.addLineScheduleEntryList(this);
    }

    public Set<PublicTransportLine> getPublicTransportLine() {
        return this.publicTransportLines;
    }

    public void setPublicTransportLines(Set<PublicTransportLine> publicTransportLines) {
        this.publicTransportLines = publicTransportLines;

    }
    public Point getGeoLocation() {
        return this.geoLocation;
    }
}
