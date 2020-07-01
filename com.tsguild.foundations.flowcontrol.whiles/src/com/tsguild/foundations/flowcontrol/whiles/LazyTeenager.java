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

public class LazyTeenager {
    public static void main(String[] args) {
        
       Random newRand = new Random();
       Scanner scr = new Scanner(System.in);
        
        int x;
        int y;
                
        y = 1;
        
        x = newRand.nextInt(15 + 1);
                       
        do { 
        System.out.println("Clean your room! x" + y );
        y++;
            if (y == 15) {
                System.out.println("Your grounded and no xbox for a week!");
                break;
            
            }
            } while (y < x);
        
                     
        }
        }
    
    
        


        
        


        
                    
            



            
            

        


        
        
    
            
    
    


                     