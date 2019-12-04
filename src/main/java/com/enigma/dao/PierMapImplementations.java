package com.enigma.dao;

import com.enigma.constanta.MessageConstant;
import com.enigma.model.Boat;
import com.enigma.model.StatusContainer;

import java.util.HashMap;
import java.util.Map;

public class PierMapImplementations implements PierMap {
    private Map<Integer, StatusContainer>pierSlots = new HashMap<Integer, StatusContainer>();
    private Integer capacity;
    public static final String DOCKED = "Docked";
    public static final String RESERVE = "Reserved";

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
    public String dock(Boat boat){
        for (Map.Entry<Integer, StatusContainer> slot :this.pierSlots.entrySet()) {
            if (slot.getValue()== null){
                slot.setValue(new StatusContainer(DOCKED,boat));
                return String.format(MessageConstant.SUCCESS_DOCKING,slot.getKey());
            }
        }
        return MessageConstant.FAIL_DOCKING;
    }

}
