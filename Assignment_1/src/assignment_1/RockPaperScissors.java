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

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {

    public static void main(String[] args) {
        
        Scanner scr = new Scanner(System.in);
        Random rand = new Random();
        
        int x = 1;
        
      do {  
        
        System.out.println("Would you like to play Rock, Paper Scissors? (1=y / 2=n)");
        x = scr.nextInt();
           
        if (x == 1) {
           
        System.out.println("How many rounds would you like to play? (1-10): ");
        int rounds = scr.nextInt();
        
        int wins = 0;
        
        for (int i = 0; i < rounds; i++) {
            
            System.out.println("Enter 1 for Rock, 2 for Paper, 3 for Scissors!");
            
            System.out.println("1, 2, 3....Shoot! (enter your play)");
            int play = scr.nextInt();
            
            int rock = 1;
            int paper = 2;
            int scissors = 3;
            
            double compPlay = rand.nextInt(3) + 1; 
            
            if (play == compPlay) {
                System.out.println("Looks like you won this round!");
                wins++;
            }   else {
                System.out.println("The computer won this round!");
            }   
        } 
        System.out.println("Good job! You won " + wins + "rounds.");  
        
        } else {
            System.out.println("Thanks for playing!");
        }
      } while (x == 1);
    }
}

    
    
    
  

