package com.hr.personnel;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {
    private double rate;
    private double hours;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, LocalDate hireDate) {
        super(name, hireDate);
    }

    public HourlyEmployee(String name, LocalDate hireDate, double rate){
        super(name, hireDate);
        setRate(rate);
    }
    public HourlyEmployee(String name, LocalDate hireDate, double rate, double hours){
        this(name, hireDate, rate); // delegate to neighboring ctor for name, hours
        setHours(hours);            // handle rate myself, by delegating to setter
    }
    @Override
    public void pay(){
        System.out.println(getName() + " is paid hourly " + (getRate() * getHours()));
    }
    public void payTaxes(){
        System.out.println(getName() + " paid taxes of " + (getRate() * getHours() * HOURLY_TAX_RATE));
    }
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    @Override
    public String toString(){
        return super.toString() + " hour=" + getHours() + " rate=" + getRate();
    }
}