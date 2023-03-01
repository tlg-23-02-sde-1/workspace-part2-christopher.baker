/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    private Calculator calc;

    @BeforeClass
    public static void initializeEntireTestRun() {
        System.out.println("initializeEntireTestRun");
    }

    @AfterClass
    public static void finalizeTestRun() {
        System.out.println("finalizeTestRun");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        System.out.println("testAdd");
        Calculator calc = new Calculator();
        // int result = calc.add(1,4);
        // assertEquals(5, result);   Last two lines can be written as.....>
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");
        Calculator calc = new Calculator();
        assertEquals(2.5, calc.divide(5, 2), .001); //see notes for delta

    }

    @Test
    public void testIsEven() {
        System.out.println("testIsEven");
        Calculator calc = new Calculator();
        assertTrue(calc.isEven(10));
    }
}