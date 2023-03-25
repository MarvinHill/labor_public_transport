package de.hhn.se.labswp.buga23publictransport.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;

@Entity
public class LineScheduleEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalTime arrivalTime;
    private int waitTime;
    private int delay;
    private String stationDesignator;

    protected LineScheduleEntry() {}

    public LineScheduleEntry(LocalTime arrivalTime, int waitTime, int delay, String stationDesignator) {
        this.arrivalTime = arrivalTime;
        this.waitTime = waitTime;
        this.delay = delay;
        this.stationDesignator = stationDesignator;
    }



    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setStationDesignator(String stationDesignator) {
        this.stationDesignator = stationDesignator;
    }

    public Long getId() {
        return id;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public int getDelay() {
        return delay;
    }

    public String getStationDesignator() {
        return stationDesignator;
    }
}
