package com.electricalpanel.client;

import com.electricalpanel.*;
import static com.electricalpanel.EPBrand.*;

class EPClient {
    public static void main(String[] args) {
        ElectricalPanel ep1 = new ElectricalPanel(EPBrand.GE, true, 24);
        ElectricalPanel ep2 = new ElectricalPanel(EPBrand.SIEMENS, true, 60);
        ElectricalPanel ep3 = new ElectricalPanel(EPBrand.SQUARE_E, false, 40);
    }
}