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
public class MakePiTest {
    
    private MakePi newPi = new MakePi();
    
    public MakePiTest() {
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
    public void testPiValues3() {
        assertEquals("3, 1, 4", newPi.makePi(3));
    }
    
    @Test
    public void testPiValues4() {
        assertEquals("3, 1, 4, 1", newPi.makePi(4));
    }
    
    @Test
    public void testPiValues5() {
    assertEquals("3, 1, 4, 1, 5", newPi.makePi(5));
    }
    
}
