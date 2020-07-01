/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Sighting;
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
public class SightingDaoImplTest {
    
    
    SightingDao sightingDao;
    
    public SightingDaoImplTest() {
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
        sightingDao = ctx.getBean("SightingDaoImpl", SightingDao.class);
        
        List<Sighting> sightings = sightingDao.getAllSightings();
        for (Sighting currentSighting : sightings) {
            sightingDao.removeSighting(currentSighting.getSightingId());
        }
    }
    
    /**
     * Test of addSighting method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testAddGetDeleteSighting() {
        
        Sighting sighting = new Sighting();
       
        sighting.setHeroId(1);
        sighting.setLocationId(1);
        sighting.setDate("01-01-1992");
        
        sightingDao.addSighting(sighting);
        
        Sighting fromDb = sightingDao.getSightingById(sighting.getSightingId());
        assertEquals(fromDb.getSightingId(), sighting.getSightingId());
        
        sightingDao.removeSighting(sighting.getSightingId());
        assertNull(sightingDao.getSightingById(sighting.getSightingId()));
        
    }

    public void testUpdateSighting() {
        
        Sighting sighting = new Sighting();
        sighting.setHeroId(1);
        sighting.setLocationId(1);
        sighting.setDate("01-01-1992"); 
        sightingDao.addSighting(sighting);
        
        sighting.setLocationId(2);
        sightingDao.updateSighting(sighting);
        assertEquals("New Jersey", sighting.getLocationId());
    }

    /**
     * Test of getAllSightings method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testGetAllSightings() {
        
        Sighting sighting = new Sighting();
        sighting.setHeroId(1);
        sighting.setLocationId(1);
        sighting.setDate("01-01-1992"); 
        sightingDao.addSighting(sighting);
        
        Sighting sighting2 = new Sighting();
        sighting.setHeroId(2);
        sighting.setLocationId(2);
        sighting.setDate("01-01-1992");
        sightingDao.addSighting(sighting2);
        
        List<Sighting> sList = sightingDao.getAllSightings();
        assertEquals(sList.size(), 2);
    }

    /**
     * Test of searchSighting method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testSearchSighting() {
        
        Sighting sighting = new Sighting();
        sighting.setHeroId(1);
        sighting.setLocationId(1);
        sighting.setDate("01-01-1992"); 
        sightingDao.addSighting(sighting);
        
        Sighting sighting2 = new Sighting();
        sighting.setHeroId(2);
        sighting.setLocationId(1);
        sighting.setDate("01-01-1992");
        sightingDao.addSighting(sighting2);
        
        Map<SightingSearchTerm, String> criteria = new HashMap<>();
        criteria.put(SightingSearchTerm.LOCATIONID, "1");
        
        List<Sighting> sList = sightingDao.searchSighting(criteria);
        Sighting fromList = sList.get(0);
        
        assertEquals(1, sList.size());
        assertEquals(sighting.getLocationId(), fromList.getLocationId());
     
    }

}
