/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.scanner;

/**
 *
 * @author benli
 */
import java.util.Scanner;


public class QuestForTheUserInput {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        String yourName;
        String yourQuest;
        double velocityOfSwallow;
        
        System.out.print("What is your name?? ");
        yourName = inputReader.nextLine();
        
        System.out.println("What is your quest?! ");
        yourQuest = inputReader.nextLine();
        
        System.out.println("What is the airspeed velocity of an unladen swallow!?! ");
        velocityOfSwallow = inputReader.nextDouble();
        
        System.out.println("How do you know " + velocityOfSwallow + " is correct, " + yourName + ",");
        System.out.println("when you didnt even know if it as the african or european swallow!");
        System.out.println("maybe skip answering things about birds and instead go " + yourQuest);
        
        
                
              
    }
    
}
