/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Hero;
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
public class HeroDaoImplTest {
    
    HeroDao heroDao;
    
   
    
    public HeroDaoImplTest() {
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
        heroDao = ctx.getBean("HeroDaoImpl", HeroDao.class);
        
        List<Hero> heros = heroDao.getAllHeros();
        for (Hero currentHero : heros) {
            heroDao.removeHero(currentHero.getHeroId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setJdbcTemplate method, of class HeroDaoImpl.
     */
    @Test
    public void testSetJdbcTemplate() {
    }

    /**
     * Test of addHero method, of class HeroDaoImpl.
     */
     @Test
    public void testAddGetDeleteHero() {
        Hero hero = new Hero();
        hero.setName("super Stan");
        hero.setDescription("regular guy");
        hero.setPowers("cricket master");
        hero.setLocationId(1);
        hero.setOrganizationId(1);
        
        heroDao.addHero(hero);
        Hero fromDb = heroDao.getHeroById(hero.getHeroId());
        assertEquals(fromDb.getName(), hero.getName());
        
        heroDao.removeHero(hero.getHeroId());
        assertNull(heroDao.getHeroById(hero.getHeroId()));
        
    }

    /**
     * Test of updateHero method, of class HeroDaoImpl.
     */
   @Test
    public void testUpdateHero() {
        
        Hero hero = new Hero();
        hero.setName("super Stan");
        hero.setDescription("regular guy");
        hero.setPowers("cricket master");
        hero.setLocationId(1);
        hero.setOrganizationId(1);
        
        heroDao.addHero(hero);
        
        hero.setName("regular Stan");
        heroDao.updateHero(hero);
        assertEquals("regular Stan", hero.getName());
    }

    /**
     * Test of getAllHeros method, of class HeroDaoImpl.
     */
    @Test
    public void testGetAllHeros() {
        Hero hero = new Hero();
        hero.setName("super Stan");
        hero.setDescription("regular guy");
        hero.setPowers("cricket master");
        hero.setLocationId(1);
        hero.setOrganizationId(1);
        heroDao.addHero(hero);
        Hero hero2 = new Hero();
        hero2.setName("mega paul");
        hero2.setDescription("mega guy");
        hero2.setPowers("coding wiz");
        hero2.setLocationId(2);
        hero2.setOrganizationId(2);
        heroDao.addHero(hero2);
        
        List<Hero> hList = heroDao.getAllHeros();
        
        assertEquals(hList.size(), 2);
    }

    /**
     * Test of searchHeros method, of class HeroDaoImpl.
     */
    @Test
    public void testSearchHeros() {
        
        Hero hero = new Hero();
        hero.setName("super Stan");
        hero.setDescription("regular guy");
        hero.setPowers("cricket master");
        hero.setLocationId(1);
        hero.setOrganizationId(1);
        heroDao.addHero(hero);
        Hero hero2 = new Hero();
        hero2.setName("mega paul");
        hero2.setDescription("mega guy");
        hero2.setPowers("coding wiz");
        hero2.setLocationId(2);
        hero2.setOrganizationId(2);
        heroDao.addHero(hero2);
        
        Map<HeroSearchTerm, String> criteria = new HashMap<>();
        
        criteria.put(HeroSearchTerm.NAME, "super stan");
        List<Hero> hList = heroDao.searchHeros(criteria);
        
        Hero fromList = hList.get(0);
        assertEquals(hList.size(), 1);
        assertEquals(hero.getName(), fromList.getName());
    }
    
}
