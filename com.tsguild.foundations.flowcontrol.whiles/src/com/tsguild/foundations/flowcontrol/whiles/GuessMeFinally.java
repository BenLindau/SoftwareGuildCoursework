/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles;

/**
 *
 * @author benli
 */

import java.util.Scanner;
import java.util.Random;


public class GuessMeFinally {
    
    public static void main(String[] args) {
        
        Scanner scr = new Scanner(System.in);
        
       Random newNum = new Random();
        
       int x;
       int y;
        x = newNum.nextInt(100 + 1 + 100) - 100;
        
        System.out.println("please input your guess: ");
        y = scr.nextInt();
        
        while  (y > x) {
            System.out.println("Too high, try again");
            y = scr.nextInt();
        while (y < x) {
             System.out.println("Too low, try again");
            y = scr.nextInt();
            }  
        if (y == x) {
            System.out.println("Good job you got it!");
        }
        }
    }
}

         
        
   
        
        
    


    
                
        
        
        
        
                
                
            
            
        

        
        
      
     
        

