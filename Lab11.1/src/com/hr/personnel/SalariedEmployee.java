package com.hr.personnel;

import java.time.LocalDate;

//fields
public class SalariedEmployee extends Employee {
    private double salary;
//constructors
    public SalariedEmployee() {
    }
    public SalariedEmployee(String name, LocalDate hireDate) {
        super(name, hireDate);  // delegate to superclass ctor for name, hireDate
                                //register in 401K
    }
    public SalariedEmployee(String name, LocalDate hireDate, double salary){
        this(name, hireDate);   // delegate to neighboring ctor for name, hireDate
        setSalary(salary);      // handle rate myself, by delegating to setter
    }
//business methods
    @Override
    public void pay(){
        System.out.println(getName() + " is payed salary " + getSalary());
    }
    public void payTaxes() {
        System.out.println(getName() + " paid taxes of " + (getSalary() * SALARIED_TAX_RATE));
    }
    public void takeVacation(){
        System.out.println(getName() + " is on vacation ");
    }
//accessor methods: get/set/toString
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString(){
        return super.toString() + " salary= " + getSalary();
    }
}