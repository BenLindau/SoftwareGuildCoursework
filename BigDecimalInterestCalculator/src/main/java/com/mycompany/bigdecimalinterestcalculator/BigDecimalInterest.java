/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bigdecimalinterestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author benli
 */
public class BigDecimalInterest {
    
    public static void main(String[] args) {
        
    
    Scanner calc = new Scanner(System.in);
    
    double loan;
    double interest;
    double interestPercent;
    double interestRate;
    
        System.out.println("Welcome to the Interest Calculator");
        
        System.out.println("Please enter loan amount");
        loan = calc.nextDouble();
    
        System.out.println("Please enter the interest rate");
        interestRate = calc.nextDouble();
        
        interestPercent = interestRate / 100;
        
        BigDecimal decimalInterest = new BigDecimal(Double.toString(interestPercent));
        decimalInterest = decimalInterest.setScale(2, RoundingMode.HALF_UP);
        BigDecimal decimalLoanAmount = new BigDecimal(Double.toString(loan));
        decimalLoanAmount = decimalLoanAmount.setScale(2, RoundingMode.HALF_UP);
    
        BigDecimal Interest = decimalInterest.multiply(decimalLoanAmount);
    
        System.out.println("Interest = " + Interest);
    }   
    
}
