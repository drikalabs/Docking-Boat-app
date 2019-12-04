package com.enigma.dao;

import com.enigma.constanta.MessageConstant;
import com.enigma.model.Boat;
import org.junit.Test;

import static org.junit.Assert.*;

public class PierMapImplementationsTest {
    private static final String boatCode1 = "KA-09-HH-7788";
    private static final String boatCode2 = "KB-09-HH-7657";

    @Test
    public void create_should_be_able_to_create_boating_dock_with_given_capacity() {
        Integer givenCapacity=1;
        Integer expectedCapacity=1;
        PierMap pierMap = new PierMapImplementations(givenCapacity);
        assertEquals(String.format(MessageConstant.CREATED_PIER_SLOT,expectedCapacity),pierMap.create());

    }
    @Test
    public void create_should_not_be_able_to_create_boating_dock_with_zero_capacity() {
        Integer givenCapacity=0;
        PierMap pierMap = new PierMapImplementations(givenCapacity);
        assertEquals(String.format(MessageConstant.FAILED_CREATED_PIER_SLOT,givenCapacity),pierMap.create());
    }
    @Test
    public void dock_should_be_able_to_docking_a_boat(){
        Integer givenCapacity=1;
        Integer expectedPierNumber=1;
        PierMap pierMap = new PierMapImplementations(givenCapacity);
        pierMap.create();
        assertEquals(String.format(MessageConstant.SUCCESS_DOCKING,expectedPierNumber),pierMap.dock(new Boat(boatCode1)));
    }
    @Test
    public void dock_should_not_be_able_to_docking_a_boat_when_dock_is_full(){
        Integer givenCapacity=1;
        PierMap pierMap = new PierMapImplementations(givenCapacity);
        pierMap.create();
        pierMap.dock(new Boat(boatCode2));
        assertEquals(MessageConstant.FAIL_DOCKING,pierMap.dock(new Boat(boatCode1)));
    }
}