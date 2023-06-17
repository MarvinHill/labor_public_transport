package de.hhn.se.labswp.buga23publictransport.persistence;

import de.hhn.se.labswp.buga23publictransport.rnv.persistence.TimeStopInfo;
import jakarta.persistence.*;

import org.springframework.data.geo.Point;

@Entity
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long rnvID;
    private Point geoLocation;
    private String stationDesignator;
    @Column(length = 10000)
    private String TimeInfoJSON;

    public Station() {
    }

    public Station(double longitude, double latitude, String stationDesignator, long rnvID) {
        this.geoLocation = new Point(longitude, latitude);
        this.stationDesignator = stationDesignator;
        this.rnvID = rnvID;
    }

    public String getStationDesignator() {
        return stationDesignator;
    }

    public Point getGeoLocation() {
        return geoLocation;
    }

    public Long getRnvID() {
        return rnvID;
    }

    public void setGeoLocation(Point geoLocation) {
        this.geoLocation = geoLocation;
    }

    public void setStationDesignator(String stationDesignator) {
        this.stationDesignator = stationDesignator;
    }

    public String getTimeInfoJSON() {
        return TimeInfoJSON;
    }

    public void setTimeInfoJSON(String timeInfoJSON) {
        TimeInfoJSON = timeInfoJSON;
    }
}
