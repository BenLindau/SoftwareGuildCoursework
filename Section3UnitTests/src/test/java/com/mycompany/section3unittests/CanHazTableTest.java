/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.section3unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author benli
 */
public class CanHazTableTest {
    
    private CanHazTable hazTable = new CanHazTable();
    
    public CanHazTableTest() {
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
    public void testYourNoTable() {
        assertEquals(0, hazTable.canHazTable(2, 5));
    }
    
    @Test
    public void testYourMaybeTable() {
        assertEquals(1, hazTable.canHazTable(5, 5));
    }
    
    @Test
    public void tesYourtHazTable() {
        assertEquals(2, hazTable.canHazTable(8, 5));
    }
    
    @Test
    public void testDateNoTable() {
        assertEquals(0, hazTable.canHazTable(5, 2));
    }
    
    @Test
    public void testDateMaybeTable() {
        assertEquals(1, hazTable.canHazTable(5, 5));
    }
    
    @Test
    public void testDateHazTable() {
        assertEquals(2, hazTable.canHazTable(5, 8));
    }
}
