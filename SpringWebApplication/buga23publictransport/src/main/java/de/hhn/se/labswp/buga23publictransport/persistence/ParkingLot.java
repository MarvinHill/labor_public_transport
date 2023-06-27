package de.hhn.se.labswp.buga23publictransport.persistence;

import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import jakarta.persistence.*;
import org.springframework.data.geo.Point;
import java.util.List;

@Entity
public class ParkingLot {

    @Id
    @GeneratedValue
    Long id;
    @Column(length = 100000)
    @Lob
    List<Point> area;
    Point geoLocation;
    @Lob
    List<Point> entrance;
    String name;
    boolean barrierfree;
    ParkingType parkingType;
    String address;

    public ParkingLot(Point geoLocation, List<Point> area, List<Point> entrance, String name, ParkingType parkingType, String address) {
        this.geoLocation = geoLocation;
        this.area = area;
        this.entrance = entrance;
        this.name = name;
        this.parkingType = parkingType;
        this.address = address;
    }

    public ParkingLot() { }

    public Long getId() {
        return id;
    }

    public List<Point> getArea() {
        return area;
    }

    public Point getGeoLocation() {
        return geoLocation;
    }

    public List<Point> getEntrance() {
        return entrance;
    }

    public String getName() {
        return name;
    }

    public boolean isBarrierfree() {
        return barrierfree;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public String getAddress() {
        return address;
    }

}
