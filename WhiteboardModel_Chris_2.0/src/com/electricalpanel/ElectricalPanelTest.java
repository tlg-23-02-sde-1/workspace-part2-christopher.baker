
package com.electricalpanel;

import com.electricalpanel.EPBrand;
import com.electricalpanel.ElectricalPanel;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ElectricalPanelTest {

    @Test
    public void testElectricalPanelBrand(){
        ElectricalPanel panel3 = new ElectricalPanel(EPBrand.SIEMENS, true, 24);
        ElectricalPanel panel4 = new ElectricalPanel(EPBrand.GE, true, 40);

        assertEquals(EPBrand.SIEMENS, panel3.getBrand());
        assertEquals(EPBrand.GE, panel4.getBrand());

        assertEquals("SIEMENS", panel3.getBrand());
        assertEquals("GE", panel4.getBrand());
    }
}