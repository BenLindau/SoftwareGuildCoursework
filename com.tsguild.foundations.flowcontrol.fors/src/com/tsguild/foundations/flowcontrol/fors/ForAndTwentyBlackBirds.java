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
public class ForAndTwentyBlackBirds {
    public static void main(String[] args) {
        int birdsInPie = 1;
        for (int i = 0; i < 20; i++) {
        System.out.println("Blackbird # " + i + " goes into the pie!");
        birdsInPie++;
        }
        
        System.out.println("there are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
        
    }
                
    }

