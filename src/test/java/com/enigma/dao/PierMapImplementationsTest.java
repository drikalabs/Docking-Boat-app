package com.enigma.dao;

import com.enigma.constanta.MessageConstant;
import org.junit.Test;

import static org.junit.Assert.*;

public class PierMapImplementationsTest {

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
}