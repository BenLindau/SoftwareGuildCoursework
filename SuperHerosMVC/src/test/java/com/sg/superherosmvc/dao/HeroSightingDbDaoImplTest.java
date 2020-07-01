/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosmvc.dao;

import com.sg.superherosmvc.model.Hero;
import com.sg.superherosmvc.model.Location;
import com.sg.superherosmvc.model.Organization;
import com.sg.superherosmvc.model.Sighting;
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
public class HeroSightingDbDaoImplTest {
    
    private HeroSightingDao dao;
    
    public HeroSightingDbDaoImplTest() {
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
        dao = ctx.getBean("DaoDbImpl", HeroSightingDao.class);
        
        List<Hero> heros = dao.getAllHeros();
        for (Hero currentHero : heros) {
            dao.removeHero(currentHero.getHeroId());
        }
        
        List<Sighting> sightings = dao.getAllSightings();
        for (Sighting currentSighting : sightings) {
            dao.removeSighting(currentSighting.getSightingId());
        }
        
        List<Location> locations = dao.getAllLocations();
        for (Location location : locations) {
            dao.removeLocation(location.getLocationId());
        }
        
        List<Organization> orgs = dao.getAllOrganizations();
        for (Organization currentOrg : orgs) {
            dao.removeOrganization(currentOrg.getOrgId());
        }
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testAddGetDeleteHero() {
        Hero hero = new Hero();
        hero.setName("super Stan");
        hero.setDescription("regular guy");
        hero.setPowers("cricket master");
        hero.setLocation(1);
        hero.setOrganization(1);
        
        dao.addHero(hero);
        Hero fromDb = dao.getHeroById(hero.getHeroId());
        assertEquals(fromDb.getName(), hero.getName());
        
        dao.removeHero(hero.getHeroId());
        assertNull(dao.getHeroById(hero.getHeroId()));
        
        
        
    }

      
    @Test
    public void testUpdateHero() {
        
        Hero hero = new Hero();
        hero.setName("super Stan");
        hero.setDescription("regular guy");
        hero.setPowers("cricket master");
        hero.setLocation(1);
        hero.setOrganization(1);
        
        dao.addHero(hero);
        
        hero.setName("regular Stan");
        dao.updateHero(hero);
        assertEquals("regular Stan", hero.getName());
    }

    /**
     * Test of getAllHeros method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testGetAllHeros() {
        Hero hero = new Hero();
        hero.setName("super Stan");
        hero.setDescription("regular guy");
        hero.setPowers("cricket master");
        hero.setLocation(1);
        hero.setOrganization(1);
        dao.addHero(hero);
        Hero hero2 = new Hero();
        hero2.setName("mega paul");
        hero2.setDescription("mega guy");
        hero2.setPowers("coding wiz");
        hero2.setLocation(2);
        hero2.setOrganization(2);
        dao.addHero(hero2);
        
        List<Hero> hList = dao.getAllHeros();
        
        assertEquals(hList.size(), 2);
    }

     /**
     * Test of searchHeros method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testSearchHeros() {
        
        Hero hero = new Hero();
        hero.setName("super Stan");
        hero.setDescription("regular guy");
        hero.setPowers("cricket master");
        hero.setLocation(1);
        hero.setOrganization(1);
        dao.addHero(hero);
        Hero hero2 = new Hero();
        hero2.setName("mega paul");
        hero2.setDescription("mega guy");
        hero2.setPowers("coding wiz");
        hero2.setLocation(2);
        hero2.setOrganization(2);
        dao.addHero(hero2);
        
        Map<HeroSearchTerm, String> criteria = new HashMap<>();
        
        criteria.put(HeroSearchTerm.NAME, "super stan");
        List<Hero> hList = dao.searchHeros(criteria);
        
        Hero fromList = hList.get(0);
        assertEquals(hList.size(), 1);
        assertEquals(hero.getName(), fromList.getName());
    }

    /**
     * Test of addSighting method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testAddGetDeleteSighting() {
        
        Sighting sighting = new Sighting();
        
        sighting.setLocation(1);
        sighting.setDate("01-01-1992");
        sighting.setLatitude(33.33);
        sighting.setLongitude(33.33); 
        dao.addSighting(sighting);
        
        Sighting fromDb = dao.getSightingById(sighting.getSightingId());
        assertEquals(fromDb.getLocation(), sighting.getLocation());
        
        dao.removeSighting(sighting.getSightingId());
        assertNull(dao.getSightingById(sighting.getSightingId()));
        
    }

    public void testUpdateSighting() {
        
        Sighting sighting = new Sighting();
        sighting.setLocation(1);
        sighting.setDate("01-01-1992");
        sighting.setLatitude(33.33);
        sighting.setLongitude(33.33); 
        dao.addSighting(sighting);
        
        sighting.setLocation(2);
        dao.updateSighting(sighting);
        assertEquals("New Jersey", sighting.getLocation());
    }

    /**
     * Test of getAllSightings method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testGetAllSightings() {
        
        Sighting sighting = new Sighting();
        sighting.setLocation(1);
        sighting.setDate("01-01-1992");
        sighting.setLatitude(33.33);
        sighting.setLongitude(33.33); 
        dao.addSighting(sighting);
        
        Sighting sighting2 = new Sighting();
        sighting2.setLocation(2);
        sighting2.setDate("01-01-1992");
        sighting2.setLatitude(12.33);
        sighting2.setLongitude(12.33); 
        dao.addSighting(sighting2);
        
        List<Sighting> sList = dao.getAllSightings();
        assertEquals(sList.size(), 2);
    }

    /**
     * Test of searchSighting method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testSearchSighting() {
        
        Sighting sighting = new Sighting();
        sighting.setLocation(1);
        sighting.setDate("01-01-1992");
        sighting.setLatitude(33.33);
        sighting.setLongitude(33.33); 
        dao.addSighting(sighting);
        
        Sighting sighting2 = new Sighting();
        sighting2.setLocation(2);
        sighting2.setDate("01-01-1992");
        sighting2.setLatitude(12.33);
        sighting2.setLongitude(12.33); 
        dao.addSighting(sighting2);
        
        Map<SightingSearchTerm, String> criteria = new HashMap<>();
        criteria.put(SightingSearchTerm.LOCATION, "1");
        
        List<Sighting> sList = dao.searchSighting(criteria);
        Sighting fromList = sList.get(0);
        
        assertEquals(1, sList.size());
        assertEquals(sighting.getLocation(), fromList.getLocation());
     
    }

    /**
     * Test of addLocation method, of class HeroSightingDbDaoImpl.
     */
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
        dao.addLocation(loc);
        
        Location fromDb = dao.getLocationById(loc.getLocationId());
        assertEquals(fromDb.getName(), loc.getName());
        
        dao.removeLocation(loc.getLocationId());
        assertNull(dao.getLocationById(loc.getLocationId()));
               
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
        dao.addLocation(loc);
        
        loc.setName("West Park");
        dao.updateLocation(loc);
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
        dao.addLocation(loc);
        
         Location loc2 = new Location();
        loc2.setName("central park");
        loc2.setStreet("123 fake street");
        loc2.setCity("New York");
        loc2.setState("New York");
        loc2.setZipCode("12345");
        loc2.setLatitude(33.00);
        loc2.setLongitude(12.12);
        dao.addLocation(loc2);
        
        List<Location> lList = dao.getAllLocations();
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
        dao.addLocation(loc);
        
         Location loc2 = new Location();
        loc2.setName("west park");
        loc2.setStreet("123 real street");
        loc2.setCity("metropolis");
        loc2.setState("New York");
        loc2.setZipCode("12345");
        loc2.setLatitude(22.00);
        loc2.setLongitude(10.12);
        dao.addLocation(loc2);
        
        Map<LocationSearchTerm, String> criteria = new HashMap<>();
        
        criteria.put(LocationSearchTerm.NAME, "central Park");
        List<Location> lList = dao.searchLocations(criteria);
    
        Location fromList = lList.get(0);
        
        assertEquals(1, lList.size());
        assertEquals(loc.getName(), fromList.getName());
    
    }

    /**
     * Test of addOrganization method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testAddGetDeleteOrganization() {
        
        Organization org = new Organization();
        org.setName("Supergroup");
        org.setLocationId(2);
        org.setPhone("1234567890");
        org.setEmail("supergroup@super.com");
        dao.addOrganization(org);
        
        Organization fromDb = dao.getOrganizationById(org.getOrgId());
        assertEquals(fromDb.getName(), org.getName());
        
        dao.removeOrganization(org.getOrgId());
        assertNull(dao.getOrganizationById(org.getOrgId()));
    }

    
    /**
     * Test of updateOrganization method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testUpdateOrganization() {
        
        Organization org = new Organization();
        org.setName("Supergroup");
        org.setLocationId(2);
        org.setPhone("1234567890");
        org.setEmail("supergroup@super.com");
        dao.addOrganization(org);
        
        org.setName("UltraGroup");
        dao.updateOrganization(org);
        assertEquals("UltraGroup", org.getName());
        
    }

    /**
     * Test of getAllOrganizations method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testGetAllOrganizations() {
        
        Organization org = new Organization();
        org.setName("Supergroup");
        org.setLocationId(2);
        org.setPhone("1234567890");
        org.setEmail("supergroup@super.com");
        dao.addOrganization(org);
        
        Organization org2 = new Organization();
        org2.setName("betterGroup");
        org2.setLocationId(1);
        org2.setPhone("1234567890");
        org2.setEmail("betterGroup@better.com");
        dao.addOrganization(org2);
        
        List<Organization> oList = dao.getAllOrganizations();
        assertEquals(oList.size(), 2);
    }

     /**
     * Test of searchOrganizations method, of class HeroSightingDbDaoImpl.
     */
    @Test
    public void testSearchOrganizations() {
        
        Organization org = new Organization();
        org.setName("Supergroup");
        org.setLocationId(2);
        org.setPhone("1234567890");
        org.setEmail("supergroup@super.com");
        dao.addOrganization(org);
        
        Organization org2 = new Organization();
        org2.setName("betterGroup");
        org2.setLocationId(3);
        org2.setPhone("1234567890");
        org2.setEmail("betterGroup@better.com");
        dao.addOrganization(org2);
        
        Map<OrgSearchTerm, String> criteria = new HashMap<>();
        criteria.put(OrgSearchTerm.NAME, "Supergroup");
        List<Organization> oList = dao.searchOrganizations(criteria);
        
        Organization fromList = oList.get(0);
        
        assertEquals(1, oList.size());
        assertEquals(org.getName(), fromList.getName());
    }
        
    
}
