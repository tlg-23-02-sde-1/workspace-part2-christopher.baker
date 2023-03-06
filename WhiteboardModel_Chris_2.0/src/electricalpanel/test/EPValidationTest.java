package electricalpanel.test;

import electricalpanel.EPBrand;
import electricalpanel.ElectricalPanel;

class EPValidationTest {
    public static void main(String[] args) {
        System.out.println("Total number of Electrical Panels ordered: " + ElectricalPanel.getSerialNumber());

        ElectricalPanel electricalPanel = new ElectricalPanel(EPBrand.SQUARE_D, true, 24);
        System.out.println(electricalPanel + "\n");

        ElectricalPanel electricalPanel1 = new ElectricalPanel(EPBrand.SIEMENS, false, 2);
        System.out.println(electricalPanel1 + "\n");

        ElectricalPanel electricalPanel2 = new ElectricalPanel(EPBrand.GE, true, 10);
        System.out.println(electricalPanel2 + "\n");

        System.out.println("Total number of Electrical Panels Ordered: " + ElectricalPanel.getSerialNumber());
    }
}