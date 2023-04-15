package de.hhn.se.labswp.buga23publictransport.persistence;

import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import java.util.List;

@Entity
public class CarParkingLot extends ParkingLot {

    public CarParkingLot(Point geoLocation, List<Point> area, List<Point> entrance, String name, boolean barrierfree, boolean charging, ParkingType parkingType) {
        super.geoLocation = geoLocation;
        super.area = area;
        super.entrance = entrance;
        super.name = name;
        super.barrierfree = barrierfree;
        super.charging = charging;
        super.parkingType = parkingType;
    }


    public CarParkingLot() { }
}
