/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benli
 */
import java.util.Random;

public class Opinionator { 
    public static void main(String[] args) {
    Random randomizer = new Random();
    System.out.println("I cant decide what animal i like the best.");
    System.out.println("i know! i can let random decide for me!");
    
    int x = randomizer.nextInt(5);
    
    System.out.println("the number we chose was: " + x);
    
    if (x == 0) {
        System.out.println("Llamas are the best");
    } else if (x == 1) {
        System.out.println("Dodos are the best");
    } else if (x == 2) {
        System.out.println("Woolly mammoths are the best");
    } else if (x == 3) {
        System.out.println("Sharks are the best");
    } else if (x == 4) {
        System.out.println("cockatoos are just awesome");
    } else if (x == 5) {
        System.out.println("Have you ever met a Mole-Rat? They're great!");
    }
    
    System.out.println("Thanks, Random! your the best!");
    
    
    }
  
    }
    

