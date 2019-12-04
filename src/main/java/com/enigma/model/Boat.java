package com.enigma.model;

import java.util.Objects;

public class Boat {
    private String boatCode;

    public Boat(String boatCode) {
        this.boatCode = boatCode;
    }

    public String getBoatCode() {
        return boatCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boat boat = (Boat) o;
        return Objects.equals(boatCode, boat.boatCode);
    }
}
