package de.hhn.se.labswp.buga23publictransport.persistence;

import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import java.util.*;

@Entity
@Table(name = "public_transport_line")
public class PublicTransportLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String rnvId;
    private String lineDesignator;
    @Column(length = 500000)
    @Lob
    private List<Point> geoLinePoints = new ArrayList<>();
    private String colorHexCode;

    private TransportType transportType;

    @ManyToMany
    @JoinTable(
            name = "public_transport_line_line_schedule_entry",
            joinColumns = @JoinColumn(name = "public_transport_line_id"),
            inverseJoinColumns = @JoinColumn(name = "line_schedule_entry_id"))
    private List<LineScheduleEntry> lineScheduleEntryList = new ArrayList<>();

    protected PublicTransportLine() {
    }

    public PublicTransportLine(
            String lineDesignator,
            String colorHexCode,
            TransportType transportType) {
        this.lineDesignator = lineDesignator;
        this.colorHexCode = colorHexCode;
        this.transportType = transportType;
    }

    public void addLineScheduleEntryList(LineScheduleEntry lineScheduleEntry) {
        this.lineScheduleEntryList.add(lineScheduleEntry);
        lineScheduleEntry.getPublicTransportLine().add(this);
    }

    public void removeLineScheduleEntryList(long lineScheduleEntryId) {
        var lse = this.lineScheduleEntryList.stream()
                .filter(l -> l.getId() == lineScheduleEntryId).findFirst().orElse(null);
        if (lse != null) {
            this.lineScheduleEntryList.remove(lse);
            lse.getPublicTransportLine().remove(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public String getLineDesignator() {
        return lineDesignator;
    }

    public String getColorHexCode() {
        return this.colorHexCode;
    }

    public List<LineScheduleEntry> getLineScheduleEntryList() {
        return this.lineScheduleEntryList;
    }

    public List<Point> getGeoLinePoints() {
        return this.geoLinePoints;
    }

    public void setGeoLinePoints(List<Point> geoLinePoints) {
        this.geoLinePoints = geoLinePoints;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public TransportType getTransportType() {
        return transportType;
    }
}
