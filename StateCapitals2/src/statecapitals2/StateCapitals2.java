/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
/**
 *
 * @author benli
 */
public class StateCapitals2 {
    
     public static void main(String[] args) {
        
    HashMap<String, Object> capitals = new HashMap<>();
    
    capitals.put("Alabama", new Capital("Montgomery", 205000, 156));
    capitals.put("Alaska", new Capital("Juneau", 31000, 156));
    capitals.put("Arizona", new Capital("Pheonix", 1445000, 517));
    capitals.put("Arkansas", new Capital("Little Rock", 193000, 116));
    
     
    for (String key : capitals.keySet()) {
         String values = capitals.get(key).toString();
         System.out.println(key + " | " + values);
     }
    
         System.out.println("Please enter a minimum population");
         int min = myScan.scan.nextInt();
         
         
         
    for (String key : capitals.keySet()) {   
        String values = capitals.get(key).toString();    
        Capital newCapital = (Capital) capitals.get(key);
            int newPop = newCapital.getPopulation();
                if (min < newPop) {
                    System.out.println(key + " | " + values);
            }
        }    
        
    }
     
}
