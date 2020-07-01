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
public class MischeviousChildrenTest {
    
    MischeviousChildren miscChild = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
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
    public void testBothTrue() {
        assertTrue(miscChild.areWeInTrouble(true, true));
    }
    
    @Test
    public void testBothFalse() {
        assertTrue(miscChild.areWeInTrouble(false, false));
    }
    
    @Test
    public void testATrueBFalse() {
        assertFalse(miscChild.areWeInTrouble(true, false));
    }
    @Test
    public void testBTrueAFalse() {
        assertFalse(miscChild.areWeInTrouble(false, true));
    }
}
