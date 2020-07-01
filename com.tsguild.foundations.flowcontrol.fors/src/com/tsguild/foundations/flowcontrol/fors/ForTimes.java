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

public class ForTimes {
    public static void main(String[] args) {
       
        Scanner scr = new Scanner(System.in);
        
        int x;
        
        System.out.println("Which times table should i recite: ");
        x = scr.nextInt();
        
        for (int i = 1; i < 15; i++) {
            System.out.println(i + "*" + x + " is: " + i*x);
            }
    }
}
