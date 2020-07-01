/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Location;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benli
 */
public class LocationDaoImplTest {
    
    
    LocationDao locDao;
    
    public LocationDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx
            = new ClassPathXmlApplicationContext(
                        "test-applicationContext.xml");
        locDao = ctx.getBean("LocationDaoImpl", LocationDao.class);
        
        List<Location> locations = locDao.getAllLocations();
        for (Location currentHero : locations) {
            locDao.removeLocation(currentHero.getLocationId());
        }
    }
    
    @After
    public void tearDown() {
    }
@Test
    public void testAddGetDeleteLocation() {
        
        Location loc = new Location();
        loc.setName("central park");
        loc.setStreet("123 fake street");
        loc.setCity("New York");
        loc.setState("New York");
        loc.setZipCode("12345");
        loc.setLatitude(33.00);
        loc.setLongitude(12.12);
        locDao.addLocation(loc);
        
        Location fromDb = locDao.getLocationById(loc.getLocationId());
        assertEquals(fromDb.getName(), loc.getName());
        
        locDao.removeLocation(loc.getLocationId());
        assertNull(locDao.getLocationById(loc.getLocationId()));
               
    }

    /**
     * Test of updateLocation method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testUpdateLocation() {
        
        Location loc = new Location();
        
        loc.setName("central park");
        loc.setStreet("123 fake street");
        loc.setCity("New York");
        loc.setState("New York");
        loc.setZipCode("12345");
        loc.setLatitude(33.00);
        loc.setLongitude(12.12);
        locDao.addLocation(loc);
        
        loc.setName("West Park");
        locDao.updateLocation(loc);
        assertEquals("West Park", loc.getName());
    }

    /**
     * Test of getAllLocations method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testGetAllLocations() {
        
        Location loc = new Location();
        loc.setName("central park");
        loc.setStreet("123 fake street");
        loc.setCity("New York");
        loc.setState("New York");
        loc.setZipCode("12345");
        loc.setLatitude(33.00);
        loc.setLongitude(12.12);
        locDao.addLocation(loc);
        
         Location loc2 = new Location();
        loc2.setName("central park");
        loc2.setStreet("123 fake street");
        loc2.setCity("New York");
        loc2.setState("New York");
        loc2.setZipCode("12345");
        loc2.setLatitude(33.00);
        loc2.setLongitude(12.12);
        locDao.addLocation(loc2);
        
        List<Location> lList = locDao.getAllLocations();
        assertEquals(lList.size(), 2);
    }

    /**
     * Test of searchLocations method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testSearchLocations() {
        
        Location loc = new Location();
        loc.setName("central park");
        loc.setStreet("123 fake street");
        loc.setCity("New York");
        loc.setState("New York");
        loc.setZipCode("12345");
        loc.setLatitude(33.00);
        loc.setLongitude(12.12);
        locDao.addLocation(loc);
        
         Location loc2 = new Location();
        loc2.setName("west park");
        loc2.setStreet("123 real street");
        loc2.setCity("metropolis");
        loc2.setState("New York");
        loc2.setZipCode("12345");
        loc2.setLatitude(22.00);
        loc2.setLongitude(10.12);
        locDao.addLocation(loc2);
        
        Map<LocationSearchTerm, String> criteria = new HashMap<>();
        
        criteria.put(LocationSearchTerm.NAME, "central Park");
        List<Location> lList = locDao.searchLocations(criteria);
    
        Location fromList = lList.get(0);
        
        assertEquals(1, lList.size());
        assertEquals(loc.getName(), fromList.getName());
    
    }

}
