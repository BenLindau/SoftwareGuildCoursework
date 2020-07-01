/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.ClassRoster.ui;

/**
 *
 * @author benli
 */

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    
     Scanner scan = new Scanner(System.in);
     
    String prompt = "Please select from the above options";
     
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
         print(prompt);
        String input = scan.nextLine();
        return Double.parseDouble(input);
        
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
         double newNum;
        do{
        print(prompt);
            String input = scan.nextLine();
        newNum = Double.parseDouble(input);
        return newNum;
        } while (min > newNum || newNum > max);
    }

    @Override
    public float readFloat(String prompt) {
       print(prompt);
        String input = scan.nextLine();
        return Float.parseFloat(input);
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
          float newNum;
        do{
        print(prompt);
            String input = scan.nextLine();
        newNum = Float.parseFloat(input);
        return newNum;
        } while (min > newNum || newNum > max);
    }
    
    @Override
    public int readInt(String prompt) {
        print(prompt);
        String input = scan.nextLine();
        return Integer.parseInt(input);
    }

    @Override
    public int readInt(String prompt, int min, int max) {
       int newNum;
        do{
        System.out.println(prompt);
          String input = scan.nextLine();
        newNum = Integer.parseInt(input);
        return newNum;
        } while (min > newNum || newNum > max);
        
    }

    @Override
    public long readLong(String prompt) {
         print(prompt);
        String input = scan.nextLine();
        return Long.parseLong(input);
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long newNum;
        do{
        print(prompt);
            String input = scan.nextLine();
        newNum = Long.parseLong(input);
        return newNum;
        } while (min > newNum || newNum > max);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return scan.nextLine();
    }
}

    
    

