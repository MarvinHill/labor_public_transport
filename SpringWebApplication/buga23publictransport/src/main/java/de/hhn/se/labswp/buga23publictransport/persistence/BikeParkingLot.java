package de.hhn.se.labswp.buga23publictransport.persistence;

import com.vividsolutions.jts.geom.Polygon;
import de.hhn.se.labswp.buga23publictransport.business.AccessRight;
import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import java.util.List;

@Entity
public class BikeParkingLot extends ParkingLot {

    public BikeParkingLot(Point geoLocation, Polygon area, List<Point> entrance, String name, boolean barrierfree, AccessRight accessRight, boolean charging, ParkingType parkingType) {
        super.geoLocation = geoLocation;
        super.area = area;
        super.entrance = entrance;
        super.name = name;
        super.barrierfree = barrierfree;
        super.accessRight = accessRight;
        super.charging = charging;
        super.parkingType = parkingType;
    }

    public BikeParkingLot() { }
}
