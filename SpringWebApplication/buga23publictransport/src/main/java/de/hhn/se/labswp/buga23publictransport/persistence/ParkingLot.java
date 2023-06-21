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
    boolean charging;
    ParkingType parkingType;
    String address;
    boolean employeeParking;
    boolean electricity;
    boolean water;
    boolean dogsAllowed;

    int maxCapacity;

    public ParkingLot(Point geoLocation, List<Point> area, List<Point> entrance, String name, boolean barrierfree, boolean charging, ParkingType parkingType, String address, int maxCapacity, boolean employeeParking) {
        this.geoLocation = geoLocation;
        this.area = area;
        this.entrance = entrance;
        this.name = name;
        this.barrierfree = barrierfree;
        this.charging = charging;
        this.parkingType = parkingType;
        this.address = address;
        this.employeeParking = employeeParking;
    }

    public ParkingLot(Point geoLocation, List<Point> area, List<Point> entrance, String name, boolean barrierfree, boolean charging, ParkingType parkingType, String address, int maxCapacity, boolean employeeParking, boolean electricity, boolean water, boolean dogsAllowed) {
        this.geoLocation = geoLocation;
        this.area = area;
        this.entrance = entrance;
        this.name = name;
        this.barrierfree = barrierfree;
        this.charging = charging;
        this.parkingType = parkingType;
        this.address = address;
        this.employeeParking = employeeParking;
        this.electricity = electricity;
        this.water = water;
        this.dogsAllowed = dogsAllowed;
    }

    public ParkingLot() { }

    public void setID(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Point> getArea() {
        return this.area;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setEmployeeParking(boolean employeeParking) {
        this.employeeParking = employeeParking;
    }

    public boolean getEmployeeParking() {
        return employeeParking;
    }

    public boolean getElectricity() {
        return electricity;
    }

    public boolean getWater() {
        return water;
    }

    public boolean getDogsAllowed() {
        return dogsAllowed;
    }
}
