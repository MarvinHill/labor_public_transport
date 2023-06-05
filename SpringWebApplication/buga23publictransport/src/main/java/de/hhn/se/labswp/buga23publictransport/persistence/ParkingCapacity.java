package de.hhn.se.labswp.buga23publictransport.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class ParkingCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int freeParkingspaces;

    private String dateTime;

    public ParkingCapacity() {}

    public ParkingCapacity(String name, int freeParkingspaces, String dateTime) {
        this.name = name;
        this.freeParkingspaces = freeParkingspaces;
        this.dateTime = dateTime;
    }

    public void setId(long id) {this.id = id;}
    public long getId() {return this.id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}

    public void setFreeParkingspaces(int freeParkingspaces) {this.freeParkingspaces = freeParkingspaces;}
    public int getFreeParkingspaces() {return this.freeParkingspaces;}

    public void setTime(String dateTime) {this.dateTime = dateTime;}
    public String getTime() {return this.dateTime;}
}
