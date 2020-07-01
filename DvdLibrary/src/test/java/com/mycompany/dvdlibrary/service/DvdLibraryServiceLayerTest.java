/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.service;

import com.mycompany.dvdlibrary.dao.DvdLibraryAuditDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryAuditDaoStubImpl;
import com.mycompany.dvdlibrary.dao.DvdLibraryAuditFileImpl;
import com.mycompany.dvdlibrary.dao.DvdLibraryDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mycompany.dvdlibrary.dao.DvdLibraryDaoStubImpl;
import com.mycompany.dvdlibrary.dto.DVD;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benli
 */
public class DvdLibraryServiceLayerTest {
    
   private DvdLibraryServiceLayer service;
    
    public DvdLibraryServiceLayerTest() {
        DvdLibraryDao dao = new DvdLibraryDaoStubImpl();
        DvdLibraryAuditDao auditDao = new DvdLibraryAuditDaoStubImpl();
       
        service =  new DvdLibraryServiceLayerImpl(dao, auditDao);
    }
    
     DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryAuditDao myAuditDao = new DvdLibraryAuditFileImpl();
       
    
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    
       

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createDvd method, of class DvdLibraryServiceLayer.
     */
    
    /*@Test
    public void testCreateDvd() throws Exception {
        DVD dvd = new DVD("Movie 2");
        
        dvd.setReleaseDate(19L);
        dvd.setDirector("joe");
        dvd.setRating("98");
        dvd.setStudio("Universal");
        dvd.setComments("bad");
        service.createDvd(dvd);       
    }*/
    
    /*@Test
    public void testCreateDvdDuplicate() throws Exception{
        DVD dvd = new DVD("movie1");
        
        dvd.setReleaseDate(19L);
        dvd.setDirector("joe");
        dvd.setRating("98");
        dvd.setStudio("Universal");
        dvd.setComments("bad");
        
        try {
            service.createDvd(dvd);    
            fail("Expected DvdLibraryDuplicateIdException was not thrown");
        } catch (DvdLibraryDuplicateIdException e) {   
            return;
        }
    }*/
    
    /*@Test
    public void testCreateDvdInvalidData() throws Exception {
    DVD dvd = new DVD("Movie 2");
        
        dvd.setReleaseDate(19L);
        dvd.setDirector("joe");
        dvd.setRating("98");
        dvd.setStudio("Universal");
        dvd.setComments("bad");
        
        try {
            service.createDvd(dvd);
           fail("DvdLibraryInvalidDataException was not thrown");
        } catch (DvdLibraryDataValidationException e) {
            return;
        }
        
   }*/
    /**
     * Test of getAllDvds method, of class DvdLibraryServiceLayer.
     */
    /*@Test
    public void testGetAllDvds() throws Exception {
        assertEquals(1, service.getAllDvds().size());
    }*/

    /**
     * Test of getDvd method, of class DvdLibraryServiceLayer.
     */
    /*@Test
    public void testGetDvd() throws Exception {
        DVD dvd = service.getDvd("movie1");
        assertNotNull(dvd);
        dvd = service.getDvd("asdk");
        assertNull(dvd);
    }*/
    
    
    /**
     * Test of removeDvd method, of class DvdLibraryServiceLayer.
     */
    /*@Test
    public void testRemoveDvd() throws Exception {
        DVD dvd = service.removeDvd("movie1");
        assertNotNull(dvd);
        dvd = service.removeDvd("asdk");
        assertNull(dvd);
    }*/

        
}
