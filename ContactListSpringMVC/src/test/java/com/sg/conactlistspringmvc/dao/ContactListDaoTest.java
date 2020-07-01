/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.conactlistspringmvc.dao;

import com.sg.contactlistspringmvc.dao.ContactListDao;
import com.sg.contactlistspringmvc.dao.SearchTerm;
import com.sg.contactlistspringmvc.model.Contact;
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
public class ContactListDaoTest {
    
    private ContactListDao dao;
    
    public ContactListDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext cxt =
                new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = cxt.getBean("contactListDao", ContactListDao.class);
        
        List<Contact> contacts = dao.getAllContacts();
        for (Contact currentContact : contacts) {
            dao.removeContact(currentContact.getContactId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addContact method, of class ContactListDao.
     */
    @Test
    public void addGetDeleteContact() {
        Contact nc = new Contact();
        nc.setFirstName("John");
        nc.setLastName("Doe");
        nc.setCompany("Oracle");
        nc.setEmail("john@doe.com");
        nc.setPhone("1234445678");
        dao.addContact(nc);
        Contact fromDb = dao.getContactById(nc.getContactId());
        assertEquals(fromDb, nc);
        dao.removeContact(nc.getContactId());
        assertNull(dao.getContactById(nc.getContactId()));
    }

    /**
     * Test of removeContact method, of class ContactListDao.
     */
    @Test
    public void testRemoveContact() {
    }

    /**
     * Test of updateContact method, of class ContactListDao.
     */
    @Test
    public void addUpdateContact() {
        
        Contact nc = new Contact();
        nc.setFirstName("Jim");
        nc.setLastName("Smith");
        nc.setCompany("Sun");
        nc.setPhone("1234567890");
        nc.setEmail("Jim@sun.com");
        
        dao.addContact(nc);
        dao.updateContact(nc);
        Contact fromDb = dao.getContactById(nc.getContactId());
        assertEquals(fromDb, nc);
        
    }

    /**
     * Test of getAllContacts method, of class ContactListDao.
     */
    @Test
    public void getAllContacts() {
        Contact nc = new Contact();
        nc.setFirstName("Jim");
        nc.setLastName("Smith");
        nc.setCompany("Sun");
        nc.setPhone("1234567890");
        nc.setEmail("Jim@sun.com");
        
        Contact nc2 = new Contact();
        nc2.setFirstName("Jim");
        nc2.setLastName("Smith");
        nc2.setCompany("Sun");
        nc2.setPhone("1234567890");
        nc2.setEmail("Jim@sun.com");
        
        
        List<Contact> cList = dao.getAllContacts();
        assertEquals(0, cList.size());
    }

    /**
     * Test of getContactById method, of class ContactListDao.
     */
    @Test
    public void testGetContactById() {
    }

    /**
     * Test of searchContacts method, of class ContactListDao.
     */
    @Test
    public void searchContacts() {
        
        Contact nc = new Contact();
        nc.setFirstName("Jim");
        nc.setLastName("Smith");
        nc.setCompany("Apple");
        nc.setPhone("1234567890");
        nc.setEmail("Jim@apple.com");
        
        Contact nc2 = new Contact();
        nc2.setFirstName("Joe");
        nc2.setLastName("Dunn");
        nc2.setCompany("Micro");
        nc2.setPhone("1234567890");
        nc2.setEmail("Joe@micro.com");
        
        Contact nc3 = new Contact();
        nc3.setFirstName("Steve");
        nc3.setLastName("Smith");
        nc3.setCompany("Sun");
        nc3.setPhone("1234567890");
        nc3.setEmail("Steve@sun.com");
        
        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.LAST_NAME, "Jones");
        List<Contact> cList = dao.searchContacts(criteria);
        /*
        assertEquals(1, cList.size());
        assertEquals(nc2, cList.get(0));
       
        criteria.put(SearchTerm.LAST_NAME, "Smith");
        cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc, cList.get(0));
        
        criteria.put(SearchTerm.COMPANY, "Micro");
        cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc2, cList.get(0));
        
        criteria.put(SearchTerm.COMPANY, "Apple");
        cList = dao.searchContacts(criteria);
        assertEquals(0, cList.size());
        */
    }

    public class ContactListDaoImpl implements ContactListDao {

        public Contact addContact(Contact contact) {
            return null;
        }

        public void removeContact(Long contactId) {
        }

        public void updateContact(Contact contact) {
        }

        public List<Contact> getAllContacts() {
            return null;
        }

        public Contact getContactById(long contactId) {
            return null;
        }

        public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
            return null;
        }
    }
    
}
