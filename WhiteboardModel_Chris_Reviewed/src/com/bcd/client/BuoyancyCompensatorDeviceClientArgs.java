package com.bcd.client;

import com.bcd.BuoyancyCompensatorDevice;
import com.bcd.DeviceType;

import java.util.Arrays;

/*
 * JR: severely flawed.
 *
 * Example does not work, results in unhandled exception.
 *
 * args[1] is inappropriately processed multiple times in the data conversion code,
 * and the other arguments are simply ignored.
 *
 * Without spending significant time on this, I believe there is no way to get this to
 * work properly, even with reading the code - which an end user is not privy to.
 */
public class BuoyancyCompensatorDeviceClientArgs {
    public static void main(String[] args) {
        if (args.length < 6){
            String usage = "Usage: java BuoyancyCompensatorDeviceClientArgs <Color> " +
                    "<Manufacturer> <Type> <Tanks> <D Rings> <Integrated Weights>";
            String example = "Example: java BuoyancyCompensatorDeviceClientArgs Red Cressi Jacket 1 3 True";
            String note1 = "Supported colors are: Red, Black, Blue, Yellow";
            String note2 = "Supported manufacturers are: Scuba Pro, Aqualung, Cressi, Dive Rite";
            String note3 = "Supported device types are: " + Arrays.toString(DeviceType.values());
            System.out.println(usage + "\n" + example + "\n" + note1 + "\n" + note2 + "\n" + note3);
            return;
        }
        System.out.println("You provided " + args.length + " arguments");
        String color = args[1];
        String manufacturer = args[1];
        DeviceType deviceType = DeviceType.valueOf(args[3].toUpperCase());
        int tanks = Integer.parseInt(args[1]);
        int d_rings = Integer.parseInt(args[1]);
        boolean integratedWeights = false;
        System.out.println();

        BuoyancyCompensatorDevice bcd =new BuoyancyCompensatorDevice(color, manufacturer, deviceType, tanks, d_rings, integratedWeights);
        System.out.println();

        System.out.println("Congrats on your purchase");
        System.out.println("Your custom BCD is on its way to you");
        System.out.println(bcd);
    }
}