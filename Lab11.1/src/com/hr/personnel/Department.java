/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.hr.personnel;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The Department class manages employees.
 *
 * Properties:
 *   String name
 *   String location
 *   Employee[] employees  the Employees in this department.
 *   int currentIndex      internal counter for number of employees in the department.
 *
 * Methods (excluding get/set methods):
 *   void listEmployees()  print info on all employees in the department.
 *   void workEmployees()  make all employees in the department work.
 *   String toString()     self-explanatory.
 */
public class Department {
    // fields
    private String name;
    private String location;
    private Collection<Employee> employees = new ArrayList<>();
    //private Employee[] employees = new Employee[100];
    //private int currentIndex = 0;  // for dealing with the array

    // constructors
    public Department() {
    }

    public Department(String name, String location) {
        setName(name);
        setLocation(location);
    }

    // business methods
    public void listEmployees() {
        // Note: we don't use for-each here because we only want to access the array where employees were added.
        // Question: what is in the array for indices where no Employee was added?  null!
        for (Employee emp : employees) {
            System.out.println(emp);
        //for (int i = 0; i < currentIndex; i++) {
        //    System.out.println(employees[i]);  // toString() automatically called
        }
    }
    public void workEmployees() {
        for (Employee emp : employees) {
            emp.work();
        }
    }
    public void payEmployees() {
        for(Employee emp : employees) {
            emp.pay();
        }
    }
    //forced vacation for all salaried employees
    public void holidayBreak() {
        for (Employee emp : employees) {
            //downcast the Employee reference (employee{i}) to specific type SalariedEmployees.
            //then we can call SalariedEmployee-specific methods (like takeVacation())
            //first, we will ask Employees[i], "are you really a SalariedEmployee?"
            // Note: instanceof does a
            if (emp instanceof SalariedEmployee) {
                SalariedEmployee semp = (SalariedEmployee) emp;
                semp.takeVacation();
            }
        }
    }

    // helper method to add an Employee to the array
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // accessor methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return "Department: name=" + getName() + ", location=" + getLocation();
    }
}