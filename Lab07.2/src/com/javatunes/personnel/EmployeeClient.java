package com.javatunes.personnel;
import com.javatunes.personnel.Employee;

public class EmployeeClient {
    public static void main(String[] args) {
        Employee emp = new Employee();
        long begin=System.nanoTime();
        emp.work();
        emp.pay();
        long end=System.nanoTime();
        double elapsedMillis=(end-begin)/1_000_000;
    }
}