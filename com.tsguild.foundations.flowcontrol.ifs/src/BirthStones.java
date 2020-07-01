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

public class BirthStones {
    
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        
        int January = 1;
        int February = 2;
        int March = 3;
        int April = 4;
        int May = 5;
        int June = 6;
        int July = 7;
        int August = 8;
        int September = 9;
        int October = 10;
        int November = 11;
        int December = 12;
        
        int month;
        
        
    System.out.println("What months birthstone do you want to know?");
        month = src.nextInt();
        
    if(month == January) {
        System.out.println("January is Garnet");
    }
    if(month == February) {
        System.out.println("February is Amethyst");
    }
    if(month == March) {
        System.out.println("March is Aquamarine");
    }
    if(month == April) {
        System.out.println("April is diamond");
    }
    if(month == June) {
        System.out.println("January is Pearl");
    }
    if(month == July) {
        System.out.println("July is Ruby");
    }
    if(month == August) {
        System.out.println("August is Peridot");
    }
    if(month == September) {
        System.out.println("September is Sapphire");
    }
    if(month == October) {
        System.out.println("October is Opal");
    }
    if(month == November) {
        System.out.println("November is Topaz");
    }
    if(month == December) {
        System.out.println("December is Turquoise");
    }
    else {
        System.out.println("please enter a month of the year");
           }
    }
                
               
  
        
        
        
    }

