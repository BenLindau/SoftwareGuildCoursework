/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.fors;

/**
 *
 * @author benli
 */

import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        
        Scanner scr = new Scanner(System.in);
        
        int x;
        
        System.out.println("How many units fizzing and buzzing do you need in your life? ");
        x = scr.nextInt();
        
        for (int i = 1; i <= x; i++) {
                                               
            if (i % 3 == 0) {
                System.out.println("fizz");
            }else if (i % 5 == 0) {
                System.out.println("buzz");
            } else if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("FizzBuzz");
            } else System.out.println(i);         
            }
        System.out.println("TRADITION!");
        }
            
    }
