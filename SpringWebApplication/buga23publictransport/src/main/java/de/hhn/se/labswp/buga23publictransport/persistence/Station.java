package de.hhn.se.labswp.buga23publictransport.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.sound.sampled.Line;
import org.springframework.data.geo.Point;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "station")
public class Station {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long rnvID;
  private Point geoLocation;
  private String stationDesignator;
  public Station() {}

  public Station(double longitude, double latitude, String stationDesignator, long rnvID ) {
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
}
