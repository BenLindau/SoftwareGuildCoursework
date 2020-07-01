/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benli
 */
public class BewareTheKraken {
    public static void main(String[] args) {
        System.out.println("Already, get those flippers and wetsuit on - we're going diving");
        System.out.println("HEre we gooo000oooo!");
        
        int depthDived = 0;
        
        while(depthDived < 36200){
            System.out.println("So far, we've swam" + depthDived + "feet");
            
                if(depthDived >= 20000) {
                    System.out.println("uhhh i think i see the kraken, guys");
                    System.out.println("time to go");
                    break;
                }
                
                depthDived += 1000;
        }
        System.out.println("we ended up swimming " + depthDived + "feet");
        System.out.println("we can go deeper");
    }
    }
        
   
    

