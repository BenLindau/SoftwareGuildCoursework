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

public class GuessMe {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        int newNum = 26;
        int newGuess;
        
        System.out.println("Input your guess: ");
                newGuess = inputReader.nextInt();
                
        if (newNum > newGuess) {
            System.out.println("Ha, nice try - to low");
        }
        
        if (newNum < newGuess) {
            System.out.println("Ha, nice try - to high!");
        }
        
        if (newNum == newGuess) {
            System.out.println("Good job! You Guessed right!");
        }
        }
                
                
                
        
    }
 
