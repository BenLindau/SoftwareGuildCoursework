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

public class stayPositive {
    public static void main(String[] args) {
   
        Scanner scr = new Scanner(System.in);
    
    int x;
    
    System.out.println("Please input a number: ");
       x = scr.nextInt();
       
    while (x > 0) {
    System.out.println(x);
            x--;
        }
    }
       
       
    
    
    
}
