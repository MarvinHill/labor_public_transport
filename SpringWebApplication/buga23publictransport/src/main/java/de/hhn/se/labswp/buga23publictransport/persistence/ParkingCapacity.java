package de.hhn.se.labswp.buga23publictransport.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class ParkingCapacity {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int freeParkingspaces;

    private LocalDateTime time;

    public ParkingCapacity() {}

    public ParkingCapacity(String name, int freeParkingspaces, LocalDateTime time) {
        this.name = name;
        this.freeParkingspaces = freeParkingspaces;
        this.time = time;
    }

    public void setId(int id) {this.id = id;}
    public long getId() {return this.id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}

    public void setFreeParkingspaces(int freeParkingspaces) {this.freeParkingspaces = freeParkingspaces;}
    public int getFreeParkingspaces() {return this.freeParkingspaces;}

    public void setTime(LocalDateTime time) {this.time = time;}
    public LocalDateTime getTime() {return this.time;}
}
