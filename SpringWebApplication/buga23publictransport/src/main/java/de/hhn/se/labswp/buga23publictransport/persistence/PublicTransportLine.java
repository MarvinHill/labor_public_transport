package de.hhn.se.labswp.buga23publictransport.persistence;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "public_transport_line")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class PublicTransportLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lineDesignator;
    private boolean hasDelay;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "ptl_lse",
            joinColumns = {@JoinColumn(name = "public_schedule_line_id")},
            inverseJoinColumns = {@JoinColumn(name = "line_schedule_line_id")})
    @JsonManagedReference
    private Set<LineScheduleEntry> lineScheduleEntryList = new HashSet<>();

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

    protected PublicTransportLine() {
    }

    public PublicTransportLine(String lineDesignator, boolean hasDelay) {
        this.lineDesignator = lineDesignator;
        this.hasDelay = hasDelay;
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

    public Set<LineScheduleEntry> getLineScheduleEntryList() {
        return this.lineScheduleEntryList;
    }

}
