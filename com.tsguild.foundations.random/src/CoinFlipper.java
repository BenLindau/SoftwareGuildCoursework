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

public class CoinFlipper {
 public static void main(String[] args) {
   Random coinFlipper = new Random();
   
     
   System.out.println("Ready, set, flip!");  
   
   int x = coinFlipper.nextInt(2);
   
   if (x == 1) {
    System.out.print("You got: Tails");
   } else if (x == 2) {
       System.out.print("You got: Heads");
   }
  }
 }   

 