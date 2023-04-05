package de.hhn.se.labswp.buga23publictransport.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import java.time.LocalTime;

@Entity
public class LineScheduleEntry {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime arrivalTime;
    private int waitTime;
    private int delay;
    private String stationDesignator;
    private Point geoLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "public_transport_line_id", nullable = false)
    @JsonBackReference
    private PublicTransportLine publicTransportLine;

    public LineScheduleEntry() {
    }

    public LineScheduleEntry(
            LocalTime arrivalTime,
            int waitTime,
            int delay,
            String stationDesignator,
            double latitude,
            double longitude) {
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

    public PublicTransportLine getPublicTransportLine() {
        return this.publicTransportLine;
    }

    public Point getGeoLocation() {
        return this.geoLocation;
    }

    public void  setPublicTransportLine(PublicTransportLine publicTransportLine) {
        if (this.publicTransportLine == null) {
            this.publicTransportLine = publicTransportLine;
        }
    }
}
