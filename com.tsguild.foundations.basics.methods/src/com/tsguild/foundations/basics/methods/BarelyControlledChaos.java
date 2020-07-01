/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.methods;

/**
 *
 * @author benli
 */
public class BarelyControlledChaos {
    public static void main(String[] args) {

        String color = aColor(); // call color method here 
        String animal = anAnimal(); // call animal method again here 
        String colorAgain = aColor(); // call color method again here 
        int weight = theyWeigh(199); // call number method, 
            // with a range between 5 - 200 
        int distance = theyWeigh(20); // call number method, 
            // with a range between 10 - 20 
        int number = theyWeigh(15000); // call number method, 
            // with a range between 10000 - 20000 
        int time = theyWeigh(3); // call number method, 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    } 
    
    public static String aColor() {
       return "blue";
    }
    public static String anAnimal() {
        return "Zebra";
    }
    public static int theyWeigh(int x) {
        return x;
    
}
}
