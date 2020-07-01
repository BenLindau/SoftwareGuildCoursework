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
public class WaitAWhile {
    public static void main(String[] args) {
        
        int timeNow = 5;
        int bedTime = 10;
        
        while (timeNow < bedTime) {
            System.out.println("its only " + timeNow + " 0'clock");
            System.out.println("I think ill stay up jsut a while longer");
                    timeNow++; //time passes
        }
        System.out.println("oh. its " + timeNow + "oclock");
        System.out.println("Guess i should go to bed");
    
        }
                
    }

