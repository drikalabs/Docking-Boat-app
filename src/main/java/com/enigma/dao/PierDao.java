package com.enigma.dao;

import com.enigma.model.Boat;

public interface PierDao {
    String create();
    String dock(Boat boat);
    String leave(Integer pierNumber);
    String status();
}
