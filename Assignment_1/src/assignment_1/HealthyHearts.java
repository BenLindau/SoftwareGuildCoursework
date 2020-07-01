/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1;

/**
 *
 * @author benli
 */
import java.util.Scanner;

public class HealthyHearts {
    
    public static void main(String[] args) {
        
        Scanner scr = new Scanner(System.in);
        
        System.out.println("What is your age?");
        int age = scr.nextInt();
        
        int maxHeartRate = 220 - age;
        
        double targetMin = maxHeartRate * .5;
        double targetMax = maxHeartRate * .75;
        
        
        System.out.println("Your maximum heart rate is " + maxHeartRate);
        System.out.println("Your target heart rate is between " + targetMin + " and " + targetMax + " beats per minute.");
        
        
        
        
        
    }
    
}
