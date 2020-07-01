/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benli
 */
public class LlamasWhalesAndDodosOhMy {
    
    public static void main(String[] args) {
        int llamas = 20;
        int whales = 15;
        int dodos = 0;
        
        if (dodos > 0) {
            System.out.println("Egads, i thought dodos were extinct!");
        }
        
        if(dodos < 0) {
            System.out.println("Hold on, how can we have negative dodos?!?");
                    }
        
        if (llamas > whales){
            System.out.println("whales may be bigger, but llamas are better, ha!");
                    }
        
        if (llamas <= whales){
            System.out.println("aw man, brawn over brains i guess. whales beat llamas");
        }
        
        System.out.println("theres been a huge increase in the dodo populations due to cloning!");
        dodos += 1000;
        
        if ((whales +llamas) < dodos){
            System.out.println("I never thought I'd see the day when dodos ruled the earth.");
        }
    }
    
}
    

