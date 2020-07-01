/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals;

import java.util.HashMap;
import java.util.Set;


/**
 *
 * @author benli
 */
public class StateCapitals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        HashMap<String, String> stateCapitals = new HashMap<>();
        
        stateCapitals.put("Alabama", "Montgomery");
        
        stateCapitals.put("Alaska", "Juneau");
        
        stateCapitals.put("Arizona", "Phoenix");
        
        stateCapitals.put("Arkansas", "Little Rock");
        
        System.out.println("Map size is " + stateCapitals.size());
        
        Set<String> keys = stateCapitals.keySet();
        
       for(String currentState : keys) {
           String currentCapitals = stateCapitals.get(currentState);
           System.out.println("The capital of " + currentState + " is " + currentCapitals);
       } 
        
    }
    
}
