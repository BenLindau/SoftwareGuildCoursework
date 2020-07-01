/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.test;

/**
 *
 * @author benli
 */


public class test {
   
    public static boolean isPalindrome(String word) {
       
        boolean x;
        String string = "";
        
        for (int i = word.length() - 1; i >= 0; i--){
            string = string + word.charAt(i);
        }
          
        if (word == string) {
            x = true;
        } else {
            x = false;
        }
        System.out.println(string);
        return x;
        
    }
    
    public static void main(String[] args) {
        System.out.println(test.isPalindrome("Deleveled"));
    }
}



