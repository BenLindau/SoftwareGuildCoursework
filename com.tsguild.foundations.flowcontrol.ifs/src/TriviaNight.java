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

public class TriviaNight {
    public static void main(String[] args) {
        
        Scanner inputReader = new Scanner(System.in);
                
        System.out.println("Its Trivia Night!");
        
        int answerOne;
        
        System.out.println("First Question: What is the Lowest Level Programming Language?");
        System.out.println("1-Source Code");
        System.out.println("2-Assembly Language");
        System.out.println("3-C#");
        System.out.println("4-Maching Code");
        answerOne = inputReader.nextInt();
        
        int answerTwo;
        
        System.out.println("Second Question: Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1-Grace Hopper");
        System.out.println("2-Alan Turing");
        System.out.println("3-Charles Babbage");
        System.out.println("4-Larry Page");
        answerTwo = inputReader.nextInt();
        
        int answerThree;
        
        System.out.println("Third Question: Which Sci Fi Ship was once slated for a fill sized replica in vegas?");
        System.out.println("1-Serenity");
        System.out.println("2-Battlestar Galactica");
        System.out.println("3-Uss Enterprise");
        System.out.println("4-Millenium Falcon");
        answerThree = inputReader.nextInt();
               
       if ((answerOne == 4) && (answerTwo == 2) && (answerThree == 3)) {
        System.out.println("Good job you got all three right!");
        }
       else if ((answerOne == 4) && (answerTwo == 2) && (answerThree != 3)) {
        System.out.println("you got 2 correct!");
        }
       else if ((answerOne == 4) && (answerTwo != 2) && (answerThree == 3)) {
        System.out.println("you got 2 correct!");
        }
       else if ((answerOne != 4) && (answerTwo == 2) && (answerThree == 3)) {
        System.out.println("you got 2 correct!");
        }
          else if ((answerOne == 4) && (answerTwo != 2) && (answerThree != 3)) {
        System.out.println("you got 1 correct!");
        } else if ((answerOne != 4) && (answerTwo == 2) && (answerThree != 3)) {
        System.out.println("you got 1 correct!");
        }   else if ((answerOne != 4) && (answerTwo != 2) && (answerThree == 3)) {
        System.out.println("you got 1 correct!");
        }
        else {
           System.out.println("you did not get all three correct");
       }
       }    
       }
    
    

