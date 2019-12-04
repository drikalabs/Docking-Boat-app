package com.enigma.dao;

import com.enigma.constanta.MessageConstant;
import com.enigma.model.Boat;

import java.util.HashMap;
import java.util.Map;

public class PierMapImplementations implements PierMap {
    private Map<Integer, Boat>pierSlots = new HashMap<Integer, Boat>();
    private Integer capacity;

    public PierMapImplementations(Integer capacity) {
        this.capacity = capacity;
    }

    public String create(){
        if (this.capacity == 0)return String.format(MessageConstant.FAILED_CREATED_PIER_SLOT,this.capacity);
        for (int i = 1; i <= this.capacity ; i++) {
            pierSlots.put(i,null);
        }
        return String.format(MessageConstant.CREATED_PIER_SLOT,this.capacity);
    }
}
