/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

/**
 *
 * @author benli
 */
import java.util.Random;
import java.util.Scanner;


public class LuckySevens {

    public static void main(String[] args) {
        Random dice1 = new Random();
        Random dice2 = new Random();
        Scanner scr = new Scanner(System.in);
        
        System.out.println("How much money do you have to play with?");
        int total = scr.nextInt();
        
        System.out.println("How much do you have to bet? ");
        int bet = scr.nextInt();
           
        int i = 1;
        int max = total;
        int maxRolledAt = 0;
                    
       do {
        
        int roll1 = dice1.nextInt(6) + 1;
            System.out.println("your first roll = " + roll1);   
            int roll2 = dice2.nextInt(6) + 1;
            System.out.println("your second roll = " + roll2);
            int result = roll1 + roll2; 
            
                       
            if (result == 7) {
                total = total + bet;
                System.out.println("You won! You now have " + total + " to play with");
                    if (total > max) {
                        max = total;
                        maxRolledAt = i;
                        }
                    i++;
                } else {
                total = total - bet;
                System.out.println("You lost. You only have " + total + " to play wth");
                    if (total > max) {
                        max = total;
                        maxRolledAt = i;
                        }
                    i++;
                    }
            
            } while (total > 0);
        System.out.println("You played " + i + " number of times.");
        System.out.println("You should have quit at " + maxRolledAt + " when you had " + max);
        }
    
}
    
       
        
        
        

        
    
    
    

