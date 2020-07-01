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
public class StringTimesTest {
    
    StringTimes strtms = new StringTimes();
    
    public StringTimesTest() {
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
    public void testStringTimes1() {
        String X = "Hi";
        assertEquals(X, strtms.stringTimes("Hi", 1));
    }
    public void testStringTimes2() {
        String X = "HiHi";
        assertEquals(X, strtms.stringTimes("Hi", 2));
    }
    public void testStringTimes3() {
        String X = "HiHiHi";
        assertEquals(X, strtms.stringTimes("Hi", 3));
    }
}
