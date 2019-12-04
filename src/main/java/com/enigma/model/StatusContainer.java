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

    public void setStatusDock(String statusDock) {
        this.statusDock = statusDock;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}
