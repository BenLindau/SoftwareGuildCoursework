/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benli
 */
public class SpaceRustlers {
    
    public static void main(String[] args) {
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;
        
        if(aliens > spaceships) {
            System.out.println("vroom, vroom! lets get going!");
        } else{
            System.out.println("there arent enough green guys to drive these ships!");
        }
        
        if(cows == spaceships) {
            System.out.println("wow, way to plan ahead! Just enough room for the beef");
        } else if (cows > spaceships){
            System.out.println("dangit! i dont know where these cows are gonna go");
        } else { 
            System.out.println("too many ships not enough cows");
        }
        
        }
                
    }
    

