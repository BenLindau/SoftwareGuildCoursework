/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

/**
 *
 * @author benli
 */
public class SimpleCalculator {

   
    public static void main(String[] args) {
        
        System.out.println("would you like to calculate?");
        String run = myScan.scan.nextLine();
        
        if (run.equals("yes")) {
            System.out.println("What operation would you like to perform?");
            String operation = myScan.scan.nextLine();
            
            System.out.println("What is the first number?");
                        int a = myScan.scan.nextInt();
        
                    System.out.println("What is the second number?");
                        int b = myScan.scan.nextInt();
            
                if (operation.equals("add")) {
                                        
                       System.out.println("Your number is " + Adder.Add(a, b));
                        
                } else if (operation.equals("subtract")) {
                                       
                        System.out.println("Your number is " + Subtract.Sub(a, b));
                        
                } else if (operation.equals("multiply")) {
                    
                        System.out.println("Your number is " + Multiply.Mult(a, b));
                
                } else if (operation.equals("divide")) {
                    
                        System.out.println("Your number is " + Divide.Div(a, b));
                        
                }else {
                    System.out.println("You did not enter a valid function");
                }
                
        
        } else {
            System.out.println("OK!");
            
        }
        
    }
    
}
