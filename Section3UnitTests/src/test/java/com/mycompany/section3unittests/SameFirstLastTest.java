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
public class SameFirstLastTest {
    
    private SameFirstLast sameFL = new SameFirstLast();
    
    
    public SameFirstLastTest() {
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
    public void sameFirstLastFalse() {
        
        int[] numbers = {1, 2, 3};
        
        assertFalse(sameFL.sameFirstLast(numbers));
        
    }
    
    @Test
    public void sameFistLastTrue1() {
        int[] numbers = {1, 2, 3, 1};
        
        
        assertTrue(sameFL.sameFirstLast(numbers));
    }

    @Test
    public void sameFistLastTrue2() {
        
        int[] numbers = {1, 2, 1};
        
        assertTrue(sameFL.sameFirstLast(numbers));
    }
}
    

