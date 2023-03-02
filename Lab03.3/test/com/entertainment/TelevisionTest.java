package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() throws Exception {
        tv1 = new Television("Sony", 52, DisplayType.LED);
        tv2 = new Television("Sony", 52, DisplayType.LED);
    }

    @Test
    public void hashCode_shouldBeEqual_whenObjectsAreTheSame() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void hashCode_shouldNotBeEqual_whenSameBrand_whenSameVolume_whenDifferentDisplayType() {
        tv2.setDisplay(DisplayType.CRT);
        assertNotEquals(tv1.hashCode(),tv2.hashCode());
    }

    @Test
    public void hashCode_shouldNotBeEqual_whenSameBrand_whenDifferentVolume_whenSameDisplayType() {
        tv2.setVolume(99);
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void hashCode_shouldNotBeEqual_whenDifferentBrand_whenSameVolume_whenSameDisplayType() {
        tv2.setBrand("notATV");
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test   // Do not understand
    public void compare_shouldEqualZero_sameChannel() {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();
        assertEquals(0, compares.compare(tv1, tv2));
    }

    @Test   // Do not understand
    public void compare_shouldReturnPositive_differentChannel() throws InvalidChannelException {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();
        tv1.changeChannel(400);
        assertTrue(compares.compare(tv1, tv2) > 0);
    }

    @Test   // Do not understand
    public void compare_shouldReturnNegativeInt_differentChannel() throws InvalidChannelException {
        TelevisionChannelComparator compares = new TelevisionChannelComparator();
        tv2.changeChannel(400);
        assertTrue(compares.compare(tv1, tv2) < 0);
    }

    @Test   // Do not understand
    public void compare_shouldEqualZero_sameBrand_sameCurrentChannel() {
        TelevisionBrandChannelComparator compares = new TelevisionBrandChannelComparator();
        assertEquals(0, compares.compare(tv1, tv2));
    }

    @Test   // Do not understand
    public void compare_shouldReturnPositiveInt_sameCurrentChannel_differentBrand() {
        TelevisionBrandChannelComparator compares = new TelevisionBrandChannelComparator();
        tv2.setBrand("RCA");
        assertTrue(compares.compare(tv1, tv2) > 0);
    }

    @Test   // Do not understand
    public void compare_shouldReturnNegativeInt_sameBrand_differentCurrentChannel() throws Exception {
        TelevisionBrandChannelComparator compares = new TelevisionBrandChannelComparator();
        tv2.changeChannel(500);
        assertTrue(compares.compare(tv1, tv2) < 0);
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() {
        try{tv1.changeChannel(0);    //should trigger exception
            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws Exception {
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws Exception{
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenInvalid_upperBound() {
        try {tv1.changeChannel(1000);
            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e){
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv1.setVolume(-1); //should trigger an exception and doesn't get caught
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tv1.setVolume(100);
        assertEquals(100, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        tv1.setVolume(101);
    }
}