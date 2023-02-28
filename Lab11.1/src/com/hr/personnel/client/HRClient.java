/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.hr.personnel.client;

import com.hr.personnel.*;

import java.time.LocalDate;

/**
 * Application main-class.
 */
public class HRClient {

    public static void main(String[] args) {
        // create Department object
        Department dept = new Department("Sales", "Seattle");
        System.out.println(dept);

        // add Employees to it
        dept.addEmployee(new SalariedEmployee("Jason", LocalDate.of(1990, 8, 24)));
        dept.addEmployee(new HourlyEmployee("Julie", LocalDate.of(2000, 2, 2)));
        dept.addEmployee(new HourlyEmployee("Nate", LocalDate.of(2002, 10, 12), 60, 56.68));
        dept.addEmployee(new SalariedEmployee("Chris", LocalDate.of(1998, 8, 9), 56.5));
        dept.addEmployee(new Executive("Christopher", LocalDate.of(2008, 10, 15), 75_000.00));


        // list its Employees
        System.out.println("\nList employees:");
        dept.listEmployees();

        // make its Employees work
        System.out.println("\nMake employees work:");
        dept.workEmployees();
        System.out.println("\n Make employees pay");
        dept.payEmployees();

        //pay all employees
        System.out.println("\nPay all employees.");
        dept.payEmployees();

        //holiday break
        System.out.println("\nHoliday break:");
        dept.holidayBreak();
    }
}