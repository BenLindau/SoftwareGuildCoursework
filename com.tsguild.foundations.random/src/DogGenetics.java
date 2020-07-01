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

public class DogGenetics {
    public static void main(String[] args) {
        Random randomNum = new Random();
        Scanner scr = new Scanner(System.in);
        
        int n1;
        int n2;
        int n3;
        int n4;
        int n5;
        
        String dogName;
        
        System.out.println("What is your dogs name?");
        dogName = scr.nextLine();
        
        System.out.println("Your dog, " + dogName + "is:");
        
        n1 = randomNum.nextInt(100);
        System.out.println(n1 + "% German Shorthair");
        
        n2 = randomNum.nextInt(100 - n1);
        System.out.println(n2 + "% Bulldog");
        
        n3 = randomNum.nextInt(100 - n1 - n2);
        System.out.println(n3 + "% Mountain Curr");
        
        n4 = randomNum.nextInt(100 - n1 - n2 - n3);
        System.out.println(n4 + "% Black Lab");
        
        n5 = randomNum.nextInt(100 - n1 - n2 - n3 - n4);
        System.out.println(n5 + "% Doberman");
        
        System.out.println("Wow, thats quite a dog!");
              
    }
}
