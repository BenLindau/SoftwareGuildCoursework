/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.Order;
import Dao.AuditDao;
import Dao.AuditStubImpl;
import Dao.Dao;
import Dao.DaoStubImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benli
 */


public class ServiceLayerImplTest {
    
     ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       Service service = ctx.getBean("serviceLayer", Service.class);   
   
       
    public void ServiceLayerTest() {
        Dao dao = new DaoStubImpl();
        AuditDao auditDao = new AuditStubImpl();
        
        service = new ServiceLayerImpl(dao, auditDao);
    }
    
    
    private List<Order> orderList = new ArrayList<>();
    
    
    public ServiceLayerImplTest() {
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

    
    @Test
    public void testAddOrder() throws Exception {
        
        Order onlyOrder = new Order();
        
        double dubArea = 123.123;
        BigDecimal area = new BigDecimal(dubArea);
        
        onlyOrder.setOrderNum("12345");
        onlyOrder.setName("Joe");
        onlyOrder.setState("WI");
        onlyOrder.setTaxRate(.05);
        onlyOrder.setArea(area);
        onlyOrder.setMaterial("tile");
        
        service.addOrder(onlyOrder);
         
        }
    
    @Test
    public void testAddDuplicateOrder() throws Exception {
        Order onlyOrder = new Order();
        
        onlyOrder.setOrderNum("12345");
        onlyOrder.setName("Joe");
        onlyOrder.setState("WI");
        onlyOrder.setTaxRate(.05);
        onlyOrder.setMaterial("tile");
        /*
        try {
            service.addOrder(onlyOrder);
            fail("Expected DuplicateIdException was not thrown.");
        } catch (DuplicateIdException e) {
            return;
        }   */

    }
    
    @Test
    public void testCreateInvalidOrder() throws Exception {
       
        Order onlyOrder = new Order();
        
        double dubArea = 123.123;
        BigDecimal area = new BigDecimal(dubArea);
        
        onlyOrder.setOrderNum("98765");
        onlyOrder.setName("");
        onlyOrder.setState("WI");
        onlyOrder.setTaxRate(.05);
        onlyOrder.setArea(area);
        onlyOrder.setMaterial("tile");
        try {
            service.addOrder(onlyOrder);
            fail("Expected DataValidationException was not thrown.");
        } catch (DataValidationException e) {
            return;
        }

    }
    
    
    
    
    
    @Test
    public void testGetAllOrders() throws Exception {
                    
        assertEquals(1, service.getOrders().size());
    }

    
    @Test
    public void testGetOrder() throws Exception {
        Order order = service.getOrder("12345");
        assertNull(order);
        
        
    }

    
    @Test
    public void testRemoveOrder() throws Exception {
        Order order = service.removeOrder("12345");
        assertNull(order);
    }
    
}
