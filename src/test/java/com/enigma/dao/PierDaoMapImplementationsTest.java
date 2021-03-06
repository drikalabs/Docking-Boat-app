package com.enigma.dao;

import com.enigma.constanta.MessageConstant;
import com.enigma.model.Boat;
import org.junit.Test;

import static org.junit.Assert.*;

public class PierDaoMapImplementationsTest {
    private static final String boatCode1 = "KA-09-HH-7788";
    private static final String boatCode2 = "KB-09-HH-7657";

    @Test
    public void create_should_be_able_to_create_boating_dock_with_given_capacity() {
        Integer givenCapacity=1;
        Integer expectedCapacity=1;
        PierDao pierDao = new PierDaoMapImplementations(givenCapacity);
        assertEquals(String.format(MessageConstant.CREATED_PIER_SLOT,expectedCapacity), pierDao.create());

    }
    @Test
    public void create_should_not_be_able_to_create_boating_dock_with_zero_capacity() {
        Integer givenCapacity=0;
        PierDao pierDao = new PierDaoMapImplementations(givenCapacity);
        assertEquals(String.format(MessageConstant.FAILED_CREATED_PIER_SLOT,givenCapacity), pierDao.create());
    }
    @Test
    public void dock_should_be_able_to_docking_a_boat(){
        Integer givenCapacity=1;
        Integer expectedPierNumber=1;
        PierDao pierDao = new PierDaoMapImplementations(givenCapacity);
        pierDao.create();
        assertEquals(String.format(MessageConstant.SUCCESS_DOCKING,expectedPierNumber), pierDao.dock(new Boat(boatCode1)));
    }
    @Test
    public void dock_should_not_be_able_to_docking_a_boat_when_dock_is_full(){
        Integer givenCapacity=1;
        PierDao pierDao = new PierDaoMapImplementations(givenCapacity);
        pierDao.create();
        pierDao.dock(new Boat(boatCode2));
        assertEquals(MessageConstant.FAIL_DOCKING, pierDao.dock(new Boat(boatCode1)));
    }
    @Test
    public void leave_should_be_able_leave_a_boat(){
        Integer givenCapacity=1;
        Integer expectedPierNumber=1;
        PierDao pierDao = new PierDaoMapImplementations(givenCapacity);
        pierDao.create();
        pierDao.dock(new Boat(boatCode1));
        assertEquals(String.format(MessageConstant.SUCCESS_LEAVE,expectedPierNumber), pierDao.leave(expectedPierNumber));
    }
    @Test
    public void leave_should_not_be_able_leave_a_boat_when_pier_still_free(){
        Integer givenCapacity=1;
        Integer expectedPierNumber=1;
        PierDao pierDao = new PierDaoMapImplementations(givenCapacity);
        pierDao.create();
        assertEquals(String.format(MessageConstant.BOAT_NOT_FOUND,expectedPierNumber), pierDao.leave(expectedPierNumber));
    }
    @Test
    public void status_should_be_able_return_status_pier(){
        Integer givenCapacity=2;
        Integer expectedSlot1=1;
        Integer expectedSlot2=2;
        String expectedStatusPier= "Docked";
        PierDao pierDao = new PierDaoMapImplementations(givenCapacity);
        pierDao.create();
        pierDao.dock(new Boat(boatCode1));
        pierDao.dock(new Boat(boatCode2));
        String expectedStatus = MessageConstant.STATUS_HEADER +
                String.format(MessageConstant.STATUS_BODY, expectedSlot1, boatCode1, expectedStatusPier) +
                String.format(MessageConstant.STATUS_BODY, expectedSlot2, boatCode2, expectedStatusPier);
        assertEquals(expectedStatus,pierDao.status());
    }
    @Test
    public void reserve_should_be_able_to_docking_a_boat(){
        Integer givenCapacity=1;
        Integer expectedPierNumber=1;
        PierDao pierDao = new PierDaoMapImplementations(givenCapacity);
        pierDao.create();
        assertEquals(String.format(MessageConstant.SUCCESS_RESERVE,expectedPierNumber), pierDao.reserve(new Boat(boatCode1)));
    }
    @Test
    public void reserve_should_not_be_able_to_docking_a_boat_when_dock_is_full(){
        Integer givenCapacity=1;
        PierDao pierDao = new PierDaoMapImplementations(givenCapacity);
        pierDao.create();
        pierDao.dock(new Boat(boatCode2));
        assertEquals(MessageConstant.FAIL_RESERVE, pierDao.reserve(new Boat(boatCode1)));
    }
    @Test
    public void should_be_able_to_dock_a_boat_after_reserve(){
        Integer givenCapacity=1;
        Integer  expectedPierNumber=1;
        PierDao pierDao = new PierDaoMapImplementations(givenCapacity);
        pierDao.create();
        pierDao.reserve(new Boat(boatCode2));
        assertEquals(String.format(MessageConstant.SUCCESS_DOCKING,expectedPierNumber), pierDao.dock(new Boat(boatCode2)));
    }
    @Test
    public void setCapacity_should_be_able_to_return_capacity(){
        Integer givenCapacity=1;
        PierDao pierDao= new PierDaoMapImplementations();
        assertEquals(givenCapacity,pierDao.setCapacity(givenCapacity));
    }
}