package de.hhn.se.labswp.buga23publictransport.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import java.time.LocalTime;
import java.util.*;

@Entity
@Table(name = "line_schedule_entry")
@JsonSerialize(using = LineScheduleEntrySerializer.class)
public class LineScheduleEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @ManyToMany(mappedBy = "lineScheduleEntryList")
    private List<PublicTransportLine> publicTransportLines = new ArrayList<>();
    public LineScheduleEntry() {
    }

    public LineScheduleEntry(
            Station station) {
        this.station = station;
    }

    public Long getId() {
        return this.id;
    }

    public Station getStation() {
        return station;
    }

    public void addPublicTransportLine(PublicTransportLine ptl) {
        this.publicTransportLines.add(ptl);
        ptl.addLineScheduleEntryList(this);
    }

    public List<PublicTransportLine> getPublicTransportLine() {
        return this.publicTransportLines;
    }

    public void setPublicTransportLines(List<PublicTransportLine> publicTransportLines) {
        this.publicTransportLines = publicTransportLines;

    }
    public void setStation(Station station) {
        this.station = station;
    }
}


