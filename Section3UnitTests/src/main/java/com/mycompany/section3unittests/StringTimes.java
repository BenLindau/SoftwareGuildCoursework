package com.mycompany.section3unittests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benli
 */
public class StringTimes {
        // Given a String and a non-negative int n, return a larger String 
    // that is n copies of the original String. 
    //
    // stringTimes("Hi", 2) -> "HiHi"
    // stringTimes("Hi", 3) -> "HiHiHi"
    // stringTimes("Hi", 1) -> "Hi"
    public String stringTimes(String str, int n) {
        str = "Hi";
        String newStr = "";
        for (int i = 0; i < n; i++) {
           newStr = newStr + str; 
        }
        return newStr;
    
    }
}
    

        
    


