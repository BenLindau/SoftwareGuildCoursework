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
public class Capital {
    
        
    private String stateCapital;
    private int population;
    private int area;

   
    
    public Capital (String name, int pop, int sqMiles) {
        stateCapital = name;
        population = pop;
        area = sqMiles;
    }
    
        
    @Override
    public String toString() {
         return stateCapital + " | " + population + " | " + area;
    }     
    public String getStateCapital() {
        return stateCapital;
    }

    public void setStateCapital(String stateCapital) {
        this.stateCapital = stateCapital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
    
}
