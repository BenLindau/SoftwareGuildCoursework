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

public class YourLifeInMovies {
    public static void main(String[] args) {
    Scanner inputReader = new Scanner(System.in);
    
    int newNum;
        
System.out.println("What is the year you were born?");
    newNum = inputReader.nextInt();
    
if (newNum < 2005) {
    System.out.println("Pixar's UP came out half a decade ago");
}
    
if (newNum < 1995) { 
    System.out.println("Harry Potter came out over 15 years ago");
}

if (newNum < 1985) {
    System.out.println("Space Jam came out not last decade, but the one before that!");
}

if (newNum < 1975) {
    System.out.println("The original Jurassic Park release is closer to the lunar landing than today.");
}

if (newNum < 1965) {
    System.out.println("Mash has been around for almost half a century.");
}
}

    
}
    
    

