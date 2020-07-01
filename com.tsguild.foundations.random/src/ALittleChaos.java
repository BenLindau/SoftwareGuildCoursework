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
public class ALittleChaos {
    public static void main(String[] args) {
        Random randomizer = new Random();
        
        System.out.println("Randcom can make integers:" + randomizer.nextInt());
        System.out.println("Or a double: )" + randomizer.nextDouble());
        System.out.println("Or even a boolean:" + randomizer.nextBoolean());
        
        int num = randomizer.nextInt(100);
        
        System.out.println("You can store a randmoized result:" + num);
        System.out.println("and use if over and over again:" + num + ", " + num);
        System.out.println("or just keep generating new values");
        System.out.println("here is a bunch of numbers between 0 and 100");
        
        System.out.print(randomizer.nextInt(101) + ",");
        System.out.print(randomizer.nextInt(101) + ",");
        System.out.print(randomizer.nextInt(101) + ",");
        System.out.print(randomizer.nextInt(101) + ",");
        System.out.print(randomizer.nextInt(101) + ",");
        System.out.print(randomizer.nextInt(101) + ",");
        System.out.print(randomizer.nextInt(101));
      
    }
}
