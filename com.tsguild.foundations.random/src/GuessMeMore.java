/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benli
 */
import java.util.Scanner;
import java.util.Random;

public class GuessMeMore {
    public static void main(String[] args){
        Random randomNum = new Random();
        Scanner yourGuess = new Scanner(System.in);
    
    int x;
    int y;
    
    x = randomNum.nextInt(100 + 1 + 10) - 100;
    
    System.out.println("Please input your guess: ");
    y = yourGuess.nextInt();
    
    if (y == x) {
        System.out.println("Good Job! You were Right!");
    } else if (y != x) {
        System.out.println("You were not correct. Try again!");
        
    }
    
    
    
    
    }
    
}
