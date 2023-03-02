package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    // object under test
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("Mark", Date.valueOf("2015-09-09"), 25.0, 40.0);
    }

    @Test
    public void testPay() {
        // To be able to test if the pay() function works, we need to do two things:
        // First: hard code the RIGHT ANSWER
        // Secondly: code in the calculated answer.
        // If those two things are equal to each other, then our method was designed correctly.
        assertEquals(1000.0, emp.pay(), .001);
    }

    @Test
    public void testTaxes() {
        emp.payTaxes();
        assertEquals(250.0, emp.payTaxes(), .001);
    }
}