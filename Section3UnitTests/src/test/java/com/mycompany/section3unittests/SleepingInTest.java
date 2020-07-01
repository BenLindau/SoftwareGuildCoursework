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
public class SleepingInTest {
    
    private SleepingIn sleepIn = new SleepingIn();
    
    public SleepingInTest() {
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
    public void CanSleepInTrue1() {
        assertTrue(sleepIn.canSleepIn(false, false));
    }
    
    @Test
    public void CanSleepInFalse() {
     assertFalse(sleepIn.canSleepIn(true, false));
    }
    
    @Test
    public void CanSleepInTrue2() {
        assertTrue(sleepIn.canSleepIn(false, true));
    }
}
