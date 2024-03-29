package de.hhn.se.labswp.buga23publictransport.persistence;

import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import java.util.List;

@Entity
public class CarParkingLot extends ParkingLot {

    boolean charging;
    int maxCapacity;
    boolean employeeParking;

    public CarParkingLot(Point geoLocation, List<Point> area, List<Point> entrance, String name, boolean barrierfree, boolean charging, ParkingType parkingType, String address, int maxCapacity, boolean employeeParking) {
        this.geoLocation = geoLocation;
        this.area = area;
        this.entrance = entrance;
        this.name = name;
        this.barrierfree = barrierfree;
        this.charging = charging;
        this.parkingType = parkingType;
        this.address = address;
        this.maxCapacity = maxCapacity;
        this.employeeParking = employeeParking;
    }

    public CarParkingLot() { }

    public boolean getCharging() {
        return charging;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean getEmployeeParking() {
        return employeeParking;
    }

}
