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
public class MakeTagsTest {
    
    MakeTags newTags = new MakeTags();
    
    public MakeTagsTest() {
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
    public void testMakeTagsIYay() {
        
        String testString = "<i>Yay</i>";
        
        assertEquals(testString, newTags.makeTags("i", "Yay"));
        
    }
    
    @Test
    public void testMakeTagsIHello() {
        String testString = "<i>Hello</i>";
        
        assertEquals(testString, newTags.makeTags("i", "Hello"));
    }
    
    @Test
    public void testMakeTagsCiteYay() {
        String testString = "<cite>Yay</cite>";
        
        assertEquals(testString, newTags.makeTags("cite", "Yay"));
    }
    
    
}
