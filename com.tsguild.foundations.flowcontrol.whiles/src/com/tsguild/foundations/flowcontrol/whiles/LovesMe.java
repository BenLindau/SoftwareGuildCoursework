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

public class LovesMe {
    public static void main(String[] args) {
        
        Scanner scr = new Scanner(System.in);
        
        int pedals;
        
        System.out.println("How many pedals are on your flower?: ");
        pedals = scr.nextInt();
        
        while (pedals >= 0) {
            if ((pedals % 2) == 0) {
                System.out.println("she loves me");
                pedals--;
            } else if ((pedals % 2) != 0) {
                System.out.println("She loves me not");
                pedals--;
            } else {
                System.out.println("Hope someone loves you");
            }
           }
         System.out.println("You are lovely");
    }
    }
/* i used a while loop with a elseif so that i could get
alternating results counting down to 0*/
