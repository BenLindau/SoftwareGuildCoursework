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
public class SumDoubleTest {
    
    SumDouble sum = new SumDouble();
    
    public SumDoubleTest() {
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
    public void testSumDouble3() {
        assertEquals(3, sum.sumDouble(1, 2));
    }
    
    @Test
    public void testSumDouble5() {
        assertEquals(5, sum.sumDouble(2, 3));
    }
    
    @Test
    public void testSumDouble8(){
         assertEquals(8, sum.sumDouble(2, 2));
    }
}
