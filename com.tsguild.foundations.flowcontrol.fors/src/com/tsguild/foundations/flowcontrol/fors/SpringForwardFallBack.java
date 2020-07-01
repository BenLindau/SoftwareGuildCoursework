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
public class SpringForwardFallBack {
    public static void main(String[] args) {
        System.out.println("its spring...!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ", ");
        }
        
        System.out.println("Noh no, its fall....");
        for (int i = 10; i > 0; i--) { 
            System.out.println(i + ", ");
        }
        
    }
}
