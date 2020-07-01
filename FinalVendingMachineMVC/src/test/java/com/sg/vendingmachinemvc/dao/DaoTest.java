/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemvc.dao;

import com.sg.vendingmachinemvc.model.Inventory;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benli
 */
public class DaoTest {
    
    private Dao dao;
    
    public DaoTest() {
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
                new ClassPathXmlApplicationContext("test-applicationContext.xml");
            dao = ctx.getBean("Dao", Dao.class);
    }       
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makePurchase method, of class Dao.
     */
    @Test
    public void testMakePurchase() throws Exception {
    }

    /**
     * Test of addInventory method, of class Dao.
     */
    @Test
    public void testAddInventory() throws Exception {
    }

    /**
     * Test of getAllInventory method, of class Dao.
     */
    @Test
    public void testGetAllInventory() throws Exception {
    
          assertEquals(7, dao.getAllInventory().size());
               
        }
    
    
    @Test
    public void makePurchase() throws PersistenceException {
            
            Map<Integer, Inventory> testMap = new HashMap<>();
            
            Inventory testItem = new Inventory();
                 
            testItem.setItemId(1);
            testItem.setSoda("sprite");
            testItem.setPrice(.25);
            testItem.setInventory(2);
            
            dao.makePurchase(1.25, 1);
            
                       
            assertEquals(2, testItem.getInventory());
            
        }
        
      @Test
      public void testGetItemById() throws PersistenceException {
          
          Inventory item = dao.getItemById(1);
          
          String soda = item.getSoda();
          
          assertEquals("sprite", soda);
      }
      
        
    
}
