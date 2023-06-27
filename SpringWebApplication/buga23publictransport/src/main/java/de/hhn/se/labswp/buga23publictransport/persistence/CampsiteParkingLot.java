package de.hhn.se.labswp.buga23publictransport.persistence;

import de.hhn.se.labswp.buga23publictransport.business.ParkingType;
import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import java.util.List;

@Entity
public class CampsiteParkingLot extends ParkingLot {

    boolean charging;
    boolean electricity;
    boolean water;
    boolean dogsAllowed;

    public CampsiteParkingLot(Point geoLocation, List<Point> area, List<Point> entrance, String name, boolean barrierfree, boolean charging, ParkingType parkingType, String address, boolean electricity, boolean water, boolean dogsAllowed) {
        this.geoLocation = geoLocation;
        this.area = area;
        this.entrance = entrance;
        this.name = name;
        this.barrierfree = barrierfree;
        this.charging = charging;
        this.parkingType = parkingType;
        this.address = address;
        this.electricity = electricity;
        this.water = water;
        this.dogsAllowed = dogsAllowed;
    }

    public CampsiteParkingLot() { }

    public boolean getCharging() {
        return charging;
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
