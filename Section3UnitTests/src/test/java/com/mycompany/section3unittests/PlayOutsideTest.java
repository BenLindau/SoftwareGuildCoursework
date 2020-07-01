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
public class PlayOutsideTest {
    
    PlayOutside  play = new PlayOutside();
    
    public PlayOutsideTest() {
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
     * Test of playOutside method, of class PlayOutside.
     */
    @Test
    public void testPlayOutside59() {
        assertFalse(play.playOutside(59, false));
    }
    
    @Test
    public void testPlayOutside60() {
        assertTrue(play.playOutside(60, false));
    }
    
    @Test
    public void testPlayOutside90() {
        assertTrue(play.playOutside(90, false));
    }
    
    @Test
    public void testPlayOutside91() {
        assertFalse(play.playOutside(91, false));
    }
    
    @Test
    public void testPlayOutsideSummer100() {
        assertTrue(play.playOutside(100, true));
    }
    
    @Test
    public void testPlayOutside101() {
    }
}
