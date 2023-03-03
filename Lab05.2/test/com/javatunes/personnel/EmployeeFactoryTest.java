package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class EmployeeFactoryTest {
  private Map<String,String> seMap;
  private Map<String,String> heMap;
  
  /**
   * client input request is a Map<String,String>, here's a sample
   * key        value
   * ---        -----
   * type       HE or SE
   * name       Jackie
   * hireDate   1990-08-24
   * 
   * salary     50000.00
   *        OR
   * rate       50.0
   * hours      40.0
   * 
   * NOTES:
   * 1. yes, we have redundant setup code, and even some redundant test code (to keep it simple)
   * 2. this is representative of how UIs send user input data to an application:
   *    - Java Swing UI components all return their input data as strings
   *    - in webapps, HTTP requests from browsers (e.g., a form submission) carry all values as strings
   */
  @Before
  public void init() {
    seMap = new HashMap<>();
    seMap.put("type",     "SE");
    seMap.put("name",     "Jackie");
    seMap.put("hireDate", "1990-08-24");
    seMap.put("salary",   "50000.0");
    
    heMap = new HashMap<>();
    heMap.put("type",     "HE");
    heMap.put("name",     "Jackie");
    heMap.put("hireDate", "1990-08-24");
    heMap.put("rate",     "50.0");
    heMap.put("hours",    "40.0");
  }
  
  @Test
  public void createEmployee_shouldReturnSalariedEmployee_whenTypeIsSE() {
    Employee emp = EmployeeFactory.createEmployee(seMap);
    //emp has to be EXACTLY a SalariedEmployee object
    assertEquals(SalariedEmployee.class, emp.getClass());
    //check that name, hireDate and salary are correct
    checkNameHireDate(emp);
    //downcast 'emp' reference to more specific type SalariedEmployee
    SalariedEmployee semp = (SalariedEmployee) emp;
    assertEquals("50000.0", semp.getSalary().toString());
    //assertEquals("50000.0", String.valueOf(semp.getSalary()));
  }

  private void checkNameHireDate(Employee emp) {
    assertEquals("Jackie", emp.getName());
    assertEquals("1990-08-24", emp.getHireDate().toString());
  }

  /**
   * TASK: verify that passing heMap into your factory returns a HourlyEmployee, with all properties set.
   */
  @Test
  public void createEmployee_shouldReturnHourlyEmployee_whenTypeIsHE() {
    Employee emp = EmployeeFactory.createEmployee(heMap);
    assertEquals(HourlyEmployee.class, emp.getClass());
    checkNameHireDate(emp);

    HourlyEmployee hemp = (HourlyEmployee) emp;
    assertEquals(50.0, hemp.getRate(), .001); //expected, actual, delta
    assertEquals(40.0, hemp.getHours(), .001);

//    assertEquals("50", hemp.getRate().toString());
//    assertEquals("40", hemp.getHours().toString());

  }
  
  @Test(expected=IllegalArgumentException.class)
  public void createEmployee_shouldThrowIllegalArgumentException_whenInvalidEntryCreated_expectedAttribute(){
    seMap.put("type", "INVALID-TYPE");
    EmployeeFactory.createEmployee(seMap); //should trigger the exception
    }

  @Test
  public void createEmployee_shouldThrowIllegalArgumentException_whenInvalidEntryCreated_tryCatchFail() {
    seMap.put("type", "INVALID-TYPE");
    try {
      EmployeeFactory.createEmployee(seMap);
      fail("Should have thrown IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid type: INVALID-TYPE", e.getMessage());
    }
  }

}