package de.hhn.se.labswp.buga23publictransport.persistence;

import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import java.util.List;

@Entity
public class CaravanParkingLot extends ParkingLot {

    public CaravanParkingLot(Point geoLocation, List<Point> area, List<Point> entrance, String name, boolean barrierfree, boolean charging, ParkingType parkingType, String address, boolean employeeParking, boolean electricity, boolean water, boolean dogsAllowed) {
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

    public CaravanParkingLot() { }
}
