/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author benli
 */

import java.util.Scanner;

public class Shapes {
       
    
    
    
    public int Perimeter(int length, int width) {
        return (width + length) * 2;  
    }
    
            
    public int Area(int length, int width) {
        return length * width;
    }     
    
    public String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
