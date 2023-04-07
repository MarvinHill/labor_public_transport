package de.hhn.se.labswp.buga23publictransport.persistence;

import de.hhn.se.labswp.buga23publictransport.business.AccessRight;
import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import jakarta.persistence.*;
import com.vividsolutions.jts.geom.Polygon;
import org.springframework.data.geo.Point;
import java.util.List;

@Entity
public class ParkingLot {

    @Id
    @GeneratedValue
    Long id;
    @Convert(converter = PolygonConverter.class)
    @Column(length = 1000)
    @Lob
    Polygon area;
    Point geoLocation;
    @Lob
    List<Point> entrance;
    String name;
    boolean barrierfree;
    AccessRight accessRight;    // 1 = employee, 2 = visitor
    boolean charging;
    ParkingType parkingType;    // 1 = bike, 2 = car, 3 = bus

    public ParkingLot(Point geoLocation, Polygon area, List<Point> entrance, String name, boolean barrierfree, AccessRight accessRight, boolean charging, ParkingType parkingType) {
        this.geoLocation = geoLocation;
        this.area = area;
        this.entrance = entrance;
        this.name = name;
        this.barrierfree = barrierfree;
        this.accessRight = accessRight;
        this.charging = charging;
        this.parkingType = parkingType;
    }

    public ParkingLot() { }

    public void setID(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setArea(Polygon area) {
        this.area = area;
    }

    public Polygon getArea() {
        return area;
    }

    public void setGeoLocation(Point geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Point getGeoLocation() {
        return this.geoLocation;
    }

    public void setEntrance(List<Point> entrance) {
        this.entrance = entrance;
    }

    public List<Point> getEntrance() {
        return this.entrance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBarrierfree(boolean barrierfree) {
        this.barrierfree = barrierfree;
    }

    public boolean getBarrierfree() {
        return barrierfree;
    }

    public void setAccessRight(AccessRight accessRight) {
        this.accessRight = accessRight;
    }

    public AccessRight getAccessRight() {
        return accessRight;
    }

    public void setCharging(boolean charging) {
        this.charging = charging;
    }

    public boolean getCharging() {
        return charging;
    }

    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

}
