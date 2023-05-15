package de.hhn.se.labswp.buga23publictransport.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import javax.sound.sampled.Line;
import org.springframework.data.geo.Point;

@Entity
@Table(name = "station")
public class Station {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Point geoLocation;
  private String stationDesignator;

  @OneToMany
  private ArrayList<LineScheduleEntry> lineScheduleEntries;

  public Station() {}

  public Station(double longitude, double latitude, String stationDesignator ) {
    this.geoLocation = new Point(longitude, latitude);
    this.stationDesignator = stationDesignator;
  }

  public String getStationDesignator() {
    return stationDesignator;
  }
  public Point getGeoLocation() {
    return geoLocation;
  }

  public ArrayList<LineScheduleEntry> getLineScheduleEntries() {
    return lineScheduleEntries;
  }

  public void setGeoLocation(Point geoLocation) {
    this.geoLocation = geoLocation;
  }

  public void setStationDesignator(String stationDesignator) {
    this.stationDesignator = stationDesignator;
  }

  public void setLineScheduleEntries(
      ArrayList<LineScheduleEntry> lineScheduleEntries) {
    this.lineScheduleEntries = lineScheduleEntries;
  }
}
