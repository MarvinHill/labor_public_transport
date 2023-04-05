package de.hhn.se.labswp.buga23publictransport.persistence;

import com.vividsolutions.jts.geom.Polygon;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class ParkingLot {
  @GeneratedValue
  @Id
  private Long id;
  @Convert(converter = PolygonConverter.class)
  private Polygon area;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public Polygon getArea() {
    return area;
  }

  public void setArea(Polygon area) {
    this.area = area;
  }
}