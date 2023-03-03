package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp(){
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findSelfTitled_shouldReturnCorrectResult() {
        Collection<MusicItem> items =catalog.findSelfTitled();
        //size should be 2, id should be 6 and 7
        assertEquals(2, items.size());
        //I need to extract(get) the first one and make sure its id is 6, then the 2nd one
        List<MusicItem> itemsList = new ArrayList<>(items);
        itemsList.sort(null);
        //assertEquals(6,itemsList.get(0));
    }

    @Test(expected=UnsupportedOperationException.class)
    public void getAll_shouldReturnReadOnlyCollection() {
        Collection<MusicItem> items = catalog.getAll();
        items.clear(); // should trigger UnsupportedOperationException
    }

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(1000L);
        assertNull(item);
    }

    @Test
    public void findByID_shouldReturnMusicItemWithThatId_whenIdFound() {
        MusicItem item = catalog.findById(12L);
        assertEquals(12L, item.getId().longValue());
        assertTrue(12 == item.getId());

    }
}