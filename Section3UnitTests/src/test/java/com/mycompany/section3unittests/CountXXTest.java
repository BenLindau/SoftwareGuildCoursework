/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.section3unittests;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author benli
 */
public class CountXXTest {
    
    private CountXX newCount = new CountXX();
    
    public CountXXTest() {
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
    public void testCountXXOne() {
        assertEquals(1, newCount.countXX("abpxx"));
    }
    
    @Test
    public void testCountXXTwo() {
        assertEquals(2, newCount.countXX("xxx"));
    }
    
    @Test
    public void testCountXXThree() {
        assertEquals(3, newCount.countXX("xxxx"));
    }
    
}
