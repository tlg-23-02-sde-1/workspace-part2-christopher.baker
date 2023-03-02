package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() throws Exception {
        emp1 = new SalariedEmployee("Jack", Date.valueOf("2010-10-10"));
        emp2 = new SalariedEmployee("Jack", Date.valueOf("2010-10-10"));
    }

    @Test
    public void hashCode_shouldBeEqual_whenEqualObjects(){
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate(){
        emp2.setName("BananaPants");

        assertNotEquals(emp1, emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate(){
        emp2.setHireDate(Date.valueOf("2020-10-10"));

        assertNotEquals(emp1, emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame(){
        assertEquals(emp1, emp2);       //for objects, equals() gets called
        assertTrue(emp1.equals(emp2));  //alternative assertion

    }
}