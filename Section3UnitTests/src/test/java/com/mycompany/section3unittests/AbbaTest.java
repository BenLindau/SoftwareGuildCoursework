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
public class AbbaTest {
    
    private Abba newAbba = new Abba();
    
    public AbbaTest() {
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
     * Test of abba method, of class Abba.
     */
    @Test
    public void testAbba() {
        String a = "Hi";
        String b = "You";
        String newString = a + b + b + a;
        assertEquals(newString, newAbba.abba("Hi", "You"));
    }
    
}
