/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Organization;
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
public class OrganizationDaoImplTest {
    
    OrganizationDao orgDao;
    
    
    public OrganizationDaoImplTest() {
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
        orgDao = ctx.getBean("OrganizationDaoImpl", OrganizationDao.class);
        
        List<Organization> organizations = orgDao.getAllOrganizations();
        for (Organization currentOrg : organizations) {
            orgDao.removeOrganization(currentOrg.getOrgId());
        }
    }
    
   @Test
    public void testAddGetDeleteOrganization() {
        
        Organization org = new Organization();
        org.setName("Supergroup");
        org.setLocationId(2);
        org.setPhone("1234567890");
        org.setEmail("supergroup@super.com");
        orgDao.addOrganization(org);
        
        Organization fromDb = orgDao.getOrganizationById(org.getOrgId());
        assertEquals(fromDb.getName(), org.getName());
        
        orgDao.removeOrganization(org.getOrgId());
        assertNull(orgDao.getOrganizationById(org.getOrgId()));
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
        orgDao.addOrganization(org);
        
        org.setName("UltraGroup");
        orgDao.updateOrganization(org);
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
        orgDao.addOrganization(org);
        
        Organization org2 = new Organization();
        org2.setName("betterGroup");
        org2.setLocationId(1);
        org2.setPhone("1234567890");
        org2.setEmail("betterGroup@better.com");
        orgDao.addOrganization(org2);
        
        List<Organization> oList = orgDao.getAllOrganizations();
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
        orgDao.addOrganization(org);
        
        Organization org2 = new Organization();
        org2.setName("betterGroup");
        org2.setLocationId(3);
        org2.setPhone("1234567890");
        org2.setEmail("betterGroup@better.com");
        orgDao.addOrganization(org2);
        
        Map<OrgSearchTerm, String> criteria = new HashMap<>();
        criteria.put(OrgSearchTerm.NAME, "Supergroup");
        List<Organization> oList = orgDao.searchOrganizations(criteria);
        
        Organization fromList = oList.get(0);
        
        assertEquals(1, oList.size());
        assertEquals(org.getName(), fromList.getName());
    }
        
    
    
}
