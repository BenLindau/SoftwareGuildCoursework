/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author benli
 */
public class DvdLibraryDaoTest {
    
     private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
    
    public DvdLibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<DVD>dvdList = dao.getAllDVDs();
        for (DVD dvd : dvdList) {
            dao.removeDvd(dvd.getTitle());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdLibraryDao.
     */
    /*@Test
    public void testAddGetDvd() throws Exception {
        DVD dvd = new DVD("Bridge by the river quay");
        dvd.setDirector("Mike");
        dvd.setRating("98");
       
        dvd.setComments("not good");
        dvd.setStudio("Pixar");
        
        dao.addDvd(dvd.getTitle(), dvd);
        
        DVD fromDao = dao.getDvd(dvd.getTitle());
        
        assertEquals(dvd, fromDao);
    }*/

    /**
     * Test of getAllDVDs method, of class DvdLibraryDao.
     */
    @Test
    public void testGetAllDVDs() throws Exception {
        DVD dvd1 = new DVD("Movie 1");
        
        dvd1.setDirector("Mike");
        dvd1.setRating("98");
        dvd1.setStudio("Pixar");
        dvd1.setComments("Good");
        
        dao.addDvd(dvd1.getTitle(), dvd1);
        
        DVD dvd2 = new DVD("Movie 2");
        
        dvd2.setDirector("todd");
        dvd2.setRating("97");
        dvd2.setStudio("universal");
        dvd2.setComments("ok");
        
        dao.addDvd(dvd2.getTitle(), dvd2);  
        
        assertEquals(0, dao.getAllDVDs().size());
        
    }

    /**
     * Test of getDvd method, of class DvdLibraryDao.
     */
    /*@Test
    public void testGetDvd() throws Exception {
    }*/

    /**
     * Test of removeDvd method, of class DvdLibraryDao.
     */
    /*@Test
    public void testRemoveDvd() throws Exception {
          DVD dvd1 = new DVD("Movie 1");
        
        dvd1.setDirector("Mike");
        dvd1.setRating("98");
        dvd1.setStudio("Pixar");
        dvd1.setComments("Good");
        
        dao.addDvd(dvd1.getTitle(), dvd1);
        
        DVD dvd2 = new DVD("Movie 2");
       
        dvd2.setDirector("todd");
        dvd2.setRating("97");
        dvd2.setStudio("universal");
        dvd2.setComments("ok");
        
        dao.addDvd(dvd2.getTitle(), dvd2);  
        
        dao.removeDvd(dvd1.getTitle());
        assertEquals(1, dao.getAllDVDs().size());
        assertNull(dao.getDvd(dvd1.getTitle()));
        
         dao.removeDvd(dvd2.getTitle());
        assertEquals(0, dao.getAllDVDs().size());
        assertNull(dao.getDvd(dvd2.getTitle()));
    }*/

   
    
}
