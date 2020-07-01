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


public class DoOrDoNot {
    public static void main(String[] args) {
      
        Scanner input = new Scanner(System.in);
        System.out.println("Should i do it (y/n):");
        boolean doIt;
        
        if (input.next().equals("y")) {
            doIt = true;
        }else {
            doIt = false;
        }
        
        boolean iDidIt = false;
        
        do { 
            iDidIt = true;
            break;
        } while (doIt);
        
        if (doIt && iDidIt) {
            System.out.println("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to, but i did");
        } else {
            System.out.println("Dont look at me! I didnt do anything");
        }
        
    }
    }

      
