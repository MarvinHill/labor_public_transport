package de.hhn.se.labswp.buga23publictransport.persistence;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TestDataGenerator {

  public TestDataGenerator(ParkingLotRepository repository) {
    this.repository = repository;
  }

  ParkingLotRepository repository;


  @PostConstruct
  public void init() {

    GeometryFactory geometryFactory = new GeometryFactory();
    Polygon polygon = geometryFactory.createPolygon(geometryFactory.createLinearRing(new Coordinate[]{new Coordinate(0, 0),
        new Coordinate(0, 1),
        new Coordinate(1, 1),
        new Coordinate(1, 0),
        new Coordinate(0, 0)
    }));


    ParkingLot parkingLot = new ParkingLot();
    parkingLot.setArea(polygon);

    repository.save(parkingLot);
  }
}
