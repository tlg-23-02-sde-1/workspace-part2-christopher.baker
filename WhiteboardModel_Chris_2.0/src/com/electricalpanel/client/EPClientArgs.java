package com.electricalpanel.client;

import com.electricalpanel.EPBrand;
import com.electricalpanel.ElectricalPanel;

class EPClientArgs {
    public static void main(String[] args) {
        if (args.length < 3) {
            String usage = "Usage: java EPClientArgs <brand> <isOnePhase> <numOfSlots>";
            String example = "Example: java EPClientArgs \"Siemens\" true 40";
            String note1 = "Approved electrical panel brands are";// + ElectricalPanel.EPBrand;
            // EPBrand is private, how do I make it so another package can see it w/out being able to adjust it.
            String note2 = "Panel is only available in One Phase or Three Phase. Do you want a One Phase Panel";
            String note3 = "Number of slots must be an even number between";// + ElectricalPanel.MIN_SLOTS + " slots " + ElectricalPanel.MAX_SLOTS;
            System.out.println(usage + "\n" + example + "\n" + note1 + "\n" + note2 + "\n" + note3);
            return;
        }

        System.out.println("You provided only " + args.length + " inputs.");

        EPBrand brand = EPBrand.valueOf(args[0].toUpperCase());
        boolean isOnePhase = Boolean.parseBoolean(args[1]);
        int numberOfSlots = Integer.parseInt(args[2]);

        ElectricalPanel electricalPanel = new ElectricalPanel(brand, isOnePhase, numberOfSlots);

        System.out.println("Congratulations on ordering your new electrical panel.");
        System.out.println("Your custom electrical panel is on its way.");
    }
}