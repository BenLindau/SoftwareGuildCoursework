/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactored;

/**
 *
 * @author benli
 */
public class Game {
    
    public void rockPaperScissors() {
        
        String x;
             
        do {
            System.out.println("Would you like to play rock paper scissors?");
            x = myScan.scan.nextLine();
            
            if (x.equals("y")) {
                
                System.out.println("How many rounds would you like to play?");
                int rounds = myScan.scan.nextInt();
            
                int wins = 0;
                
              for (int i = 0; i < rounds; i++) {
            
            System.out.println("Enter 1 Rock, 2 for Paper, 3 for Scissors!");
            
            System.out.println("1, 2, 3....Shoot! (enter your play)");
            int play = myScan.scan.nextInt();
            
            int rock = 1;
            int paper = 2;
            int scissors = 3;
            
            double compPlay = myRand.rand.nextInt(3) + 1; 
            
            if (play == compPlay) {
                System.out.println("Looks like you won this round!");
                wins++;
            }   else {
                System.out.println("The computer won this round!");
            }   
        }   
        }
        } while (x.equals("y"));
    }
    
}
