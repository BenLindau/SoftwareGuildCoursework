/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.fors;

import java.util.Scanner;

/**
 *
 * @author benli
 */
public class ForTimesFor {
    public static void main(String[] args) {
       
        Scanner scr = new Scanner(System.in);
        
        int x;
        int guess;
        
        System.out.println("Which times table should i recite: ");
        x = scr.nextInt();
        
        for (int i = 1; i < 15; i++) {
            System.out.println("What do you think the answer: ");
            guess = scr.nextInt();
            
            if (guess == i*x) {
                System.out.println("Thats correct!");
            } else {            
            System.out.println(i + "*" + x + " is: " + i*x);
            }
            }
    }
}
