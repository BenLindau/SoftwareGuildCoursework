/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorizor;

/**
 *
 * @author benli
 */
import java.util.Scanner;

public class Factorizor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Scanner scr = new Scanner(System.in);
        
        System.out.println("What is your principal amount?");
        float currentAmount = scr.nextFloat();
        
        System.out.println("What is your interest rate?");
        float intRate = scr.nextFloat();
        
        System.out.println("Please enter time (in years)");
        float time = scr.nextFloat();
        
        float newBalance = (currentAmount * (1 + (intRate/100)* time));
        System.out.println("Your balance will be " + newBalance + " after " + time + " years ");
    
    
    }
    }

