package com.tsguild.foundations.basics.arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benli
 */
public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruits = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange",
            "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple",
            "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple",
            "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple",
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple",
            "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Orange"};
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < fruits.length - 1; i++) {
            if (fruits[i] == "Apple"){
                x++;
            } else {
                y++;
            }
        }
        System.out.println("Apples is equal to: " + x);
        System.out.println("Oranges is equal to: " + y);
        
    }
}
