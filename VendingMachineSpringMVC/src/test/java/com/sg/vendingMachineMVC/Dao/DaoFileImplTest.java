/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachineMVC.Dao;

import com.sg.vendingMachineMVC.model.Inventory;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benli
 */
public class DaoFileImplTest {
    
     private Dao dao;
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext cxt = new ClassPathXmlApplicationContext
                ("test-applicationContext.xml");
            dao = cxt.getBean("Dao", Dao.class);
    
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makePurchase method, of class Dao.
     */
    @Test
    public void testMakePurchase() {
    }

    /**
     * Test of addInventory method, of class Dao.
     */
    @Test
    public void testAddInventory() {
    }

    /**
     * Test of getInventory method, of class Dao.
     */
    @Test
    public void testGetInventory() throws Exception {
    }

    /**
     * Test of removeItem method, of class Dao.
     */
    @Test
    public void testRemoveItem() throws Exception {
    }

    public abstract class DaoImpl implements Dao {

        public void makePurchaseChangeCount() throws PersistenceException {
            
            Inventory testItem = new Inventory();
                 
            Map<String, Inventory> testMap = new HashMap<>();
            
            testItem.setSoda("sprite");
            BigDecimal price = new BigDecimal(.25);
            testItem.setPrice(price);
            testItem.setInventory(2);
            
            testMap.put(testItem.getSoda(), testItem);
            
            dao.makePurchase();
            
            
            
            
            
        }
        
        public void makePurchaseInventoryCounter() throws PersistenceException {
            
            Map<String, Inventory> testMap = new HashMap<>();
            
            Inventory testItem = new Inventory();
                 
            
            testItem.setSoda("sprite");
            BigDecimal price = new BigDecimal(.25);
            testItem.setPrice(price);
            testItem.setInventory(2);
            
            dao.makePurchase();
            
            
            
            assertEquals(1, testItem.getInventory());
            
        }
        
        public Inventory addInventory(String soda, Inventory inventory) {
            
            Map<String, Inventory> testMap = new HashMap<>();
            
            Inventory testItem = new Inventory();
            
            testItem.setSoda("sprite");
            BigDecimal price = new BigDecimal(.25);
            testItem.setPrice(price);
            testItem.setInventory(2);
            
            testMap.put(testItem.getSoda(), testItem); 
            
            assertEquals(1, testMap.size());
            
            return testItem;
        }

        
        public Inventory removeItem(String soda) throws PersistenceException {
            Map<String, Inventory> testMap = new HashMap<>();
            
            Inventory testItem = new Inventory();
            Inventory testItem2 = new Inventory();
            
            testItem.setSoda("sprite");
            BigDecimal price = new BigDecimal(.25);
            testItem.setPrice(price);
            testItem.setInventory(2);
            
             testMap.put(testItem.getSoda(), testItem); 
            
            testItem.setSoda("coke");
            BigDecimal price2 = new BigDecimal(.50);
            testItem.setPrice(price2);
            testItem.setInventory(3);
            
            testMap.put(testItem.getSoda(), testItem2); 
            
            
            dao.removeItem("sprite");
            
            assertEquals(1, testMap.size());
            
            return testItem;
         
        }
        
        public List<Inventory> getAllInventoryTest() throws PersistenceException {        
            
            assertEquals(7, dao.getAllInventory().size());
            
            return dao.getAllInventory();
            
        }
    }
    
}
