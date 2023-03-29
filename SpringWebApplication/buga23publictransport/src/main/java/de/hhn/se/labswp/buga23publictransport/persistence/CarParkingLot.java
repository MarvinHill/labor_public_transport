package de.hhn.se.labswp.buga23publictransport.persistence;

import com.vividsolutions.jts.geom.Polygon;
import de.hhn.se.labswp.buga23publictransport.business.AccessRight;
import de.hhn.se.labswp.buga23publictransport.business.ParkingStatus;
import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import jakarta.persistence.*;

@Entity
public class CarParkingLot extends ParkingLot {

    public CarParkingLot(Polygon area, Double longtitude, Double latitude, String name, boolean barrierfree, AccessRight accessRight, boolean charging, ParkingStatus parkingStatus, ParkingType parkingType) {
        super.area = area;
        super.longtitude = longtitude;
        super.latitude = latitude;
        super.name = name;
        super.barrierfree = barrierfree;
        super.accessRight = accessRight;
        super.charging = charging;
        super.parkingStatus = parkingStatus;
        super.parkingType = parkingType;
    }


    public CarParkingLot() { }
}
