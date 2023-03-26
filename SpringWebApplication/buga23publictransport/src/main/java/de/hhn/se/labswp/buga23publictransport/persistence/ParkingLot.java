package de.hhn.se.labswp.buga23publictransport.persistence;

import de.hhn.se.labswp.buga23publictransport.business.AccessRight;
import de.hhn.se.labswp.buga23publictransport.business.ParkingStatus;
import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import jakarta.persistence.*;
import com.vividsolutions.jts.geom.Polygon;

@Entity
public class ParkingLot {

    @Id
    @GeneratedValue
    private Integer id;
    @Convert(converter = PolygonConverter.class)
    @Column( length = 100000 )
    private Polygon area;
    private Double longtitude, latitude;
    private String name;
    private boolean barrierfree;
    private AccessRight accessRight;    // 1 = employee, 2 = visitor
    private boolean charging;
    private ParkingStatus parkingStatus;  // 1 = available, 2 = full, 3 = closed
    private ParkingType parkingType;    // 1 = bike, 2 = car, 3 = bus

    public ParkingLot(Polygon area, Double longtitude, Double latitude, String name, boolean barrierfree, AccessRight accessRight, boolean charging, ParkingStatus parkingStatus, ParkingType parkingType) {
        this.area = area;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.name = name;
        this.barrierfree = barrierfree;
        this.accessRight = accessRight;
        this.charging = charging;
        this.parkingStatus = parkingStatus;
        this.parkingType = parkingType;
    }

    public ParkingLot() { }

    public void setID(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setArea(Polygon area) {
        this.area = area;
    }

    public Polygon getArea() {
        return area;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return latitude;
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

    public void setParkingStatus(ParkingStatus parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public ParkingStatus getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

}
