/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.section3unittests;

import java.util.List;
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
public class FirstLast6Test {
    
    private FirstLast6 first = new FirstLast6();
    
    public FirstLast6Test() {
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
    public void testFirstLastLast() {
        int[] numbers = {1, 2, 6};
       
                
        assertTrue(first.firstLast6(numbers));
        
    }
    
    @Test
    public void testFirstLastFirst() {
        
        int[] numbers = {6, 1, 2};
        
       assertTrue(first.firstLast6(numbers));
    
    }
    
    @Test
    public void testFirstLastFalse() {
        
        int[] numbers = {1, 2, 3};
        
        assertFalse(first.firstLast6(numbers));
    }
    
}
