package com.enigma.model;

public class StatusContainer {
    private String statusDock;
    private Boat boat;

    public StatusContainer(String statusDock, Boat boat) {
        this.statusDock = statusDock;
        this.boat = boat;
    }

    public String getStatusDock() {
        return statusDock;
    }
    public Boat getBoat() {
        return boat;
    }
}
