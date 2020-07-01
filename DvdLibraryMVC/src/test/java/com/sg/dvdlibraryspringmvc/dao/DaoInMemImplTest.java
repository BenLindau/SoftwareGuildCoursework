/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibrarymvc.dao.DvdDao;
import com.sg.dvdlibrarymvc.dao.SearchTerm;
import com.sg.dvdlibrarymvc.model.Dvd;
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
public class DaoInMemImplTest {
    
    private DvdDao dao;
    
    public DaoInMemImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext(
                        "test-applicationContext.xml");
                dao = ctx.getBean("dvdDao", DvdDao.class);
        
                List<Dvd> dvds = dao.getAllDvds();
                for (Dvd currentDvd : dvds) {
                    dao.removeDvd(currentDvd.getDvdId());
                }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DaoInMemImpl.
     */
    @Test
    public void testAddGetDeleteDvd() {
        Dvd nd = new Dvd();
        nd.setTitle("Bridge");
        nd.setReleaseDate("20190101");
        nd.setDirector("Stan Lee");
        nd.setStudio("Universal");
        nd.setRating("79");
        nd.setComments("it was ok");
        dao.addDvd(nd);
        Dvd fromDb = dao.getDvdById(nd.getDvdId());
        
        assertEquals(fromDb.getTitle(), nd.getTitle());
        dao.removeDvd(nd.getDvdId());
        assertNull(dao.getDvdById(nd.getDvdId()));
        
    }

    /**
     * Test of updateDvd method, of class DaoInMemImpl.
     */
    @Test
    public void testUpdateDvd() {
        Dvd nd = new Dvd();
        nd.setTitle("Bridge");
        nd.setReleaseDate("20190101");
        nd.setDirector("Stan Lee");
        nd.setStudio("Universal");
        nd.setRating("79");
        nd.setComments("it was ok");
        dao.addDvd(nd);
        
        nd.setComments("It was great!");
        dao.updateDvd(nd);
        Dvd fromDb = dao.getDvdById(nd.getDvdId());
        assertEquals(fromDb.getTitle(), nd.getTitle());
        
    }

    /**
     * Test of getAllDvds method, of class DaoInMemImpl.
     */
    @Test
    public void testGetAllDvds() {
        Dvd nd = new Dvd();
        nd.setTitle("Bridge");
        nd.setReleaseDate("20190101");
        nd.setDirector("Stan Lee");
        nd.setStudio("Universal");
        nd.setRating("79");
        nd.setComments("it was ok");
        dao.addDvd(nd);
        Dvd nd2 = new Dvd();
        nd2.setTitle("sisterhood");
        nd2.setReleaseDate("20190101");
        nd2.setDirector("Stan Lee");
        nd2.setStudio("marvel");
        nd2.setRating("12");
        nd2.setComments("it was ok");
        dao.addDvd(nd2);
        
        List<Dvd> dList = dao.getAllDvds();
        assertEquals(dList.size(), 2);
        
    }
    /**
     * Test of searchDvd method, of class DaoInMemImpl.
     */
    @Test
    public void testSearchDvd() {
        Dvd nd = new Dvd();
        nd.setTitle("Bridge");
        nd.setReleaseDate("20190101");
        nd.setDirector("Stan Lee");
        nd.setStudio("Universal");
        nd.setRating("79");
        nd.setComments("it was ok");
        dao.addDvd(nd);
        
        Dvd nd2 = new Dvd();
        nd2.setTitle("sisterhood");
        nd2.setReleaseDate("20190101");
        nd2.setDirector("Stan Lee");
        nd2.setStudio("marvel");
        nd2.setRating("12");
        nd2.setComments("it was ok");
        dao.addDvd(nd2);
        
        Dvd nd3 = new Dvd();
        nd3.setTitle("bladerunner");
        nd3.setReleaseDate("20190101");
        nd3.setDirector("michael bay");
        nd3.setStudio("paramount");
        nd3.setRating("50");
        nd3.setComments("not good");
        dao.addDvd(nd3);
        
        Map<SearchTerm, String> criteria = new HashMap<>();
        
        criteria.put(SearchTerm.TITLE, "bladerunner");
        List<Dvd> dList = dao.searchDvd(criteria);
        
        Dvd fromList = dList.get(0);
               
        assertEquals(1, dList.size());
        assertEquals(nd3.getTitle(), fromList.getTitle());
        
        
    }
    
}
