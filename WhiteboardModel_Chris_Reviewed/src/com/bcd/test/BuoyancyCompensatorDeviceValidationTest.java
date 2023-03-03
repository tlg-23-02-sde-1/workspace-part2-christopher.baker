package com.bcd.test;

import com.bcd.BuoyancyCompensatorDevice;
import com.bcd.DeviceType;

/*
 * JR: incomplete.
 *
 * For 'color' property, need to check:
 *  Red, Black, Blue, Yellow + one invalid one
 *
 * For 'manufacturer' property, need to check:
 *  Scuba Pro, Aqualung, Cressi, Dive Rite + one invalid one
 *
 * For 'tanks' property (range 1-3), need to check:
 *  0, 1  and  3, 4
 *
 * The 'd_rings' property is being tested here, but its setter does no validation.
 * Likewise for 'integratedWeights'.  Boolean properties can only ever be true/false by definition.
 */
public class BuoyancyCompensatorDeviceValidationTest {

    public static void main(String[] args) {
        BuoyancyCompensatorDevice bcd = new BuoyancyCompensatorDevice();

        System.out.println();

        bcd.setColor("Red");
        System.out.println("Color: " + bcd.getColor());
        System.out.println();

        bcd.setManufacturer("Scuba Pro");
        System.out.println("Manufacturer: " + bcd.getManufacturer());
        System.out.println();

        bcd.setDeviceType(DeviceType.JACKET);
        System.out.println("Device Type: " + bcd.getDeviceType());
        System.out.println();

        bcd.setTanks(1);
        System.out.println("Tank Number: " + bcd.getTanks());
        System.out.println();

        bcd.setD_rings(3);
        System.out.println("D Ring Number: " + bcd.getD_rings());
        System.out.println();

        bcd.setIntegratedWeights(true);
        System.out.println("BCD has Integrated Weights: " + bcd.isIntegratedWeights());

    }
}