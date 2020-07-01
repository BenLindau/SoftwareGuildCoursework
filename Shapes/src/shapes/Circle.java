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
public class Circle extends Shapes {
    
    private int radius;
    
    double pi = 3.14;

    
    public int Perimeter() {
        return (int) (2 * (pi*radius));
        
    }
    
    
    public int Area() {
        return (int) (pi * (radius * radius));
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
}
