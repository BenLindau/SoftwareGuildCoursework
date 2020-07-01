/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1;

/**
 *
 * @author benli
 */
public class SummativeSums {
    
    public static void main(String[] args) {
        arrays();
        
        
        
    }
    
    public static void arrays() {
        
        int[] firstSet = { 1, 90, -33, -55, 
        67, -16, 28, -55, 15 };
        
        int[] secondSet = {999, -60, -77, 14
        , 160, 301 };
        
        int[] thirdSet = { 10, 20, 30, 40, 50, 60, 
        70, 80, 90, 100, 110, 120, 130, 140, 150, 
        160, 170, 180, 190, 200, -99 };
        
        int x = 0;
        int y = 0;
        int z = 0;
      
        
        for (int i =0; i < firstSet.length; i++) {
            x += firstSet[i];
        }
        for (int i =0; i < secondSet.length; i++) {
            y += secondSet[i];
        }       
        for (int i =0; i < thirdSet.length; i++) {
            z += thirdSet[i];
        }
        System.out.println("First set = " + x);
        System.out.println("Second set = " + y);
        System.out.println("Third set = " + z);
        }
    }

