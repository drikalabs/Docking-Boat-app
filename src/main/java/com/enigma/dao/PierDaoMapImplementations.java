package com.enigma.dao;

import com.enigma.constanta.MessageConstant;
import com.enigma.model.Boat;
import com.enigma.model.StatusContainer;

import java.util.HashMap;
import java.util.Map;

public class PierDaoMapImplementations implements PierDao {
    private Map<Integer, StatusContainer>pierSlots = new HashMap<Integer, StatusContainer>();
    private Integer capacity;
    private static final String DOCKED = "Docked";
    private static final String RESERVE = "Reserved";

    public PierDaoMapImplementations(Integer capacity) {
        this.capacity = capacity;
    }

    public PierDaoMapImplementations() {
    }

    @Override
    public String create(){
        if (this.capacity == 0)return String.format(MessageConstant.FAILED_CREATED_PIER_SLOT,this.capacity);
        for (int i = 1; i <= this.capacity ; i++) {
            pierSlots.put(i,null);
        }
        return String.format(MessageConstant.CREATED_PIER_SLOT,this.capacity);
    }
    @Override
    public String dock(Boat boat){
        for (Map.Entry<Integer, StatusContainer> slot :this.pierSlots.entrySet()) {
            if (slot.getValue()== null){
                slot.setValue(new StatusContainer(DOCKED,boat));
                return String.format(MessageConstant.SUCCESS_DOCKING,slot.getKey());
            }else if (slot.getValue().getBoat().equals(boat)){
                slot.setValue(new StatusContainer(DOCKED,boat));
                return String.format(MessageConstant.SUCCESS_DOCKING,slot.getKey());
            }
        }
        return MessageConstant.FAIL_DOCKING;
    }
    @Override
    public String leave(Integer pierNumber){
        for (Map.Entry<Integer,StatusContainer>slot:this.pierSlots.entrySet()) {
            if (slot.getValue()!=null){
                if (slot.getKey().equals(pierNumber)){
                    slot.setValue(null);
                    return String.format(MessageConstant.SUCCESS_LEAVE,slot.getKey());
                }
            }
        }
        return String.format(MessageConstant.BOAT_NOT_FOUND,pierNumber);
    }
    @Override
    public String status(){
        StringBuilder stringStatus =new StringBuilder();
        stringStatus.append(MessageConstant.STATUS_HEADER);
        for (Map.Entry<Integer,StatusContainer>slot:this.pierSlots.entrySet()) {
            if (slot.getValue()== null)continue;
            stringStatus.append(String.format(MessageConstant.STATUS_BODY,slot.getKey(),slot.getValue().getBoat().getBoatCode(),slot.getValue().getStatusDock()));
        }
        return stringStatus.toString();
    }
    @Override
    public String reserve(Boat boat){
        for (Map.Entry<Integer, StatusContainer> slot :this.pierSlots.entrySet()) {
            if (slot.getValue()== null){
                slot.setValue(new StatusContainer(RESERVE,boat));
                return String.format(MessageConstant.SUCCESS_RESERVE,slot.getKey());
            }
        }
        return MessageConstant.FAIL_RESERVE;
    }

    public Integer setCapacity(Integer capacity) {
        return this.capacity = capacity;
    }
}
