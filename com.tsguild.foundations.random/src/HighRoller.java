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
import java.util.Scanner;

public class HighRoller {
   public static void main(String[] args) {

Random diceRoller = new Random();
Scanner scr = new Scanner(System.in);

int x;

System.out.println("Please enter the number of sides on your dice: ");
x = scr.nextInt();

int rollResult = diceRoller.nextInt(x) + 1;

System.out.println("TIME TO ROOOOOOLL THE DICE!");
System.out.println("I rolled a " + rollResult);

if (rollResult == 7) {
System.out.println("You rolled a critical failure!");
} else if (rollResult != 7) {
    System.out.println("You rolled a " + rollResult + ", nice job!");
}
}
} 
   

