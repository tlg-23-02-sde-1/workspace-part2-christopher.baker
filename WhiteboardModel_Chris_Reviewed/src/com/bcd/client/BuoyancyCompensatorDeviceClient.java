package com.bcd.client;

import com.bcd.BuoyancyCompensatorDevice;
import com.bcd.DeviceType;

/*
 * JR: Inappropriately setting field values, vs. calling setter methods.
 * This only works because fields are inappropriately declared as public in the business class.
 */
public class BuoyancyCompensatorDeviceClient {

    public static void main(String[] args) {

        System.out.println();

        BuoyancyCompensatorDevice bcd1 =  new BuoyancyCompensatorDevice();
        bcd1.color = "Red";
        bcd1.manufacturer ="Aqualung";
        bcd1.setDeviceType(DeviceType.JACKET);
        bcd1.tanks = 1;
        bcd1.d_rings = 4;
        bcd1.integratedWeights = true;
        System.out.println(bcd1);
        System.out.println();

        BuoyancyCompensatorDevice bcd2 = new BuoyancyCompensatorDevice();
        bcd2.color = "Black ";
        bcd2.manufacturer = "Dive Rite";
        bcd2.setDeviceType(DeviceType.SEMI_WING);
        bcd2.tanks = 4;
        bcd2.d_rings = 4;
        bcd2.integratedWeights = true;
        System.out.println(bcd2);
        System.out.println();

        BuoyancyCompensatorDevice bcd3 = new BuoyancyCompensatorDevice("Red", "Cressi", DeviceType.JACKET, 1, 2, true);
        System.out.println(bcd3);
        System.out.println();

        BuoyancyCompensatorDevice bcd4 = new BuoyancyCompensatorDevice("Yellow");
        System.out.println(bcd4);
        System.out.println();

        // JR: this client should be test-driving "valid" instances
        // Validation testing should be done in the ValidationTest class.
        BuoyancyCompensatorDevice bcd5 = new BuoyancyCompensatorDevice("adc", "efg", DeviceType.BACKPLATE_WING, 2, 4, false);
        System.out.println(bcd5);
        System.out.println();

    }
}