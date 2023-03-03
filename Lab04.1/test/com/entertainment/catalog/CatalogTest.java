/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Test
    public void name() {

    }

    @Test
    public void findByBrands_shouldReturnMapWithEntries_whenBrandFound() {
        Map<String,Collection<Television>> tvMap =Catalog.findByBrands("Sony", "Zenith", "LG");

        assertEquals(3, tvMap.size());
        Collection<Television> sonyTvs = tvMap.get("Sony");
        assertEquals(7, sonyTvs.size());
        for(Television tv : sonyTvs) {
            assertEquals("Sony", tv.getBrand());

        }
        Collection<Television> zenithTvs = tvMap.get("Zenith");
        assertEquals(9, zenithTvs.size());
        for(Television tv : zenithTvs){
            assertEquals("Zenith", tv.getBrand());
        }
        Collection<Television> lgTvs = tvMap.get("LG");
        assertTrue(tvMap.isEmpty());
    }
    @Test
    public void findByBrand_shouldReturnEmptyMap_whenNoBrandsPassed() {
        Map<String,Collection<Television>> tvMap = Catalog.findByBrands();
        assertTrue(tvMap.isEmpty());
    }
    @Test
    public void findByBrand_shouldReturnCollectionWithThatBrand_whenMatchesAreFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");
        assertEquals(7, tvs.size());
        for(Television tv : tvs){
            assertEquals("Sony", tv.getBrand());
        }
    }
    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void testFindByBrand_shouldReturnEmptyCollection_whenNoMatchesAreFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertTrue(tvs.isEmpty());
    }
}