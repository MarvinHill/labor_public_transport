package de.hhn.se.labswp.buga23publictransport.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int freeParkingspaces;

    private String dateTime;

    private String weekday;

    public ParkingCapacity() {}

    public ParkingCapacity(String name, int freeParkingspaces, String dateTime, String weekday) {
        this.name = name;
        this.freeParkingspaces = freeParkingspaces;
        this.dateTime = dateTime;
        this.weekday = weekday;
    }

    public void setId(long id) {this.id = id;}
    public long getId() {return this.id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}
    public void setFreeParkingspaces(int freeParkingspaces) {this.freeParkingspaces = freeParkingspaces;}
    public int getFreeParkingspaces() {return this.freeParkingspaces;}
    public void setDateTime(String dateTime) {this.dateTime = dateTime;}
    public String getDateTime() {return this.dateTime;}
    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }
    public String getWeekday() {
        return weekday;
    }
}
