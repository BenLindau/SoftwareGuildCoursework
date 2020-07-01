package com.tsguild.foundations.flowcontrol.fors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benli
 */

import java.util.Scanner;


public class TheCount {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        
        
        
              
        System.out.println("What number would you like to count by?");
        int x = scr.nextInt();
        
        System.out.println("What would you like to start at?");
        int y = scr.nextInt();
        
        System.out.println("Where would you like to stop?");
        int z = scr.nextInt();
        
        for (int i = y; i <= z; i = i + x) {
                        
            if (i < z) {
                System.out.println(i);
            } else {
                System.out.println(i + " Ah hahaha");
            }
            }
        }
        
        
    }

