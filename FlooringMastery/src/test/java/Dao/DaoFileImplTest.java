/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.Order;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author benli
 */
public class DaoFileImplTest {
    
    Dao dao = new DaoFileImpl();
    
    public DaoFileImplTest() {
    }
    
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
     * Test of addOrder method, of class DaoFileImpl.
     */
    @Test
    public void testAddOrder() throws Exception {
        Map<String, Order> orderList = new HashMap<>();
        
        setUp();
        
        Order testOrder = new Order();
        
        double area = 123.123;
        BigDecimal newArea = new BigDecimal(area);
        
        testOrder.setOrderNum("ABC123");
        testOrder.setName("Joe");
        testOrder.setState("MN");
        testOrder.setTaxRate(.05);
        testOrder.setArea(newArea);
        testOrder.setMaterial("ABC123");
        
               
        orderList.put("ABC123", testOrder);
        
        assertEquals(1, orderList.size());
        
    }

    /**
     * Test of getOrders method, of class DaoFileImpl.
     */
    @Test
    public void testGetOrders() throws Exception {
        Map<String, Order> orderList = new HashMap<>();
        
        setUp();
        
        Order testOrder = new Order();
        
        double area = 123.123;
        BigDecimal newArea = new BigDecimal(area);
        
        testOrder.setOrderNum("ABC123");
        testOrder.setName("Joe");
        testOrder.setState("MN");
        testOrder.setTaxRate(.05);
        testOrder.setArea(newArea);
        testOrder.setMaterial("ABC123");
        
               
        dao.addOrder("ABC123", testOrder);
        
        dao.getOrders();
        
        
    }

    /**
     * Test of editOrder method, of class DaoFileImpl.
     */
    @Test
    public void testEditOrder() throws Exception {
        Map<String, Order> orderList = new HashMap<>();
        
        setUp();
        
        Order testOrder = new Order();
        
        double area = 123.123;
        BigDecimal newArea = new BigDecimal(area);
        
        testOrder.setOrderNum("ABC123");
        testOrder.setName("Joe");
        testOrder.setState("MN");
        testOrder.setTaxRate(.05);
        testOrder.setArea(newArea);
        testOrder.setMaterial("ABC123");
        
               
        dao.addOrder("ABC123", testOrder);
        
        dao.editOrder(testOrder);
    }

    /**
     * Test of getOrder method, of class DaoFileImpl.
     */
    @Test
    public void testGetOrder() throws Exception {
        
        Map<String, Order> orderList = new HashMap<>();
        
        setUp();
        
        Order testOrder = new Order();
        
        double area = 123.123;
        BigDecimal newArea = new BigDecimal(area);
        
        testOrder.setOrderNum("ABC123");
        testOrder.setName("Joe");
        testOrder.setState("MN");
        testOrder.setTaxRate(.05);
        testOrder.setArea(newArea);
        testOrder.setMaterial("ABC123");
        
               
        dao.addOrder("ABC123", testOrder);
        
        dao.getOrder(testOrder.getOrderNum());
    }

    /**
     * Test of removeOrder method, of class DaoFileImpl.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        
        Map<String, Order> orderList = new HashMap<>();
        
        setUp();
        
        Order testOrder = new Order();
        
        double area = 123.123;
        BigDecimal newArea = new BigDecimal(area);
        
        testOrder.setOrderNum("ABC123");
        testOrder.setName("Joe");
        testOrder.setState("MN");
        testOrder.setTaxRate(.05);
        testOrder.setArea(newArea);
        testOrder.setMaterial("ABC123");
        
               
        dao.addOrder("ABC123", testOrder);
        
        dao.removeOrder(testOrder.getOrderNum());
        
        dao.getOrders();
        
        assertEquals(0, orderList.size());
        
    }
    
}
