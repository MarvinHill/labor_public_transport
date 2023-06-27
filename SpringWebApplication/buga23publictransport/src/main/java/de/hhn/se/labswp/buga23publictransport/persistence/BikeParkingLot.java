package de.hhn.se.labswp.buga23publictransport.persistence;

import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import java.util.List;

@Entity
public class BikeParkingLot extends ParkingLot {

    public BikeParkingLot(Point geoLocation, List<Point> area, List<Point> entrance, String name, ParkingType parkingType, String address) {
        this.geoLocation = geoLocation;
        this.area = area;
        this.entrance = entrance;
        this.name = name;
        this.parkingType = parkingType;
        this.address = address;
    }

    public BikeParkingLot() { }

}
