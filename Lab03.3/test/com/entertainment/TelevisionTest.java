package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() throws Exception {
        tv1 = new Television("Sony", 52);
        tv2 = new Television("Sony", 52);
    }

    @Test
    public void hashCode_shouldBeEqual_whenEqualObjects() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }



    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() {
        try{Television tv = new Television();
            tv.changeChannel(0);    //should trigger exception

            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws Exception {
        Television tv = new Television();
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws Exception{
        Television tv = new Television();
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenInvalid_upperBound() {
        try {
            Television tv = new Television();
            tv.changeChannel(1000);

            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e){
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        Television tv = new Television();
        tv.setVolume(-1); //should trigger an exception and doesn't get caught
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        Television tv = new Television();
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        Television tv = new Television();
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        Television tv = new Television();
        tv.setVolume(101);
    }


}