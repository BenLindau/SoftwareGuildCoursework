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
public class Diff21Test {
    
    Diff21 diff = new Diff21();
    
    public Diff21Test() {
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
    public void testValue23() {
        
        assertEquals(4, diff.diff21(23));
    }
    
    @Test
    public void testValue10() {
        
        assertEquals(11, diff.diff21(10));
    }
    
    @Test
    public void testValue21() {
    
        assertEquals(0, diff.diff21(21));
    }
    
}
