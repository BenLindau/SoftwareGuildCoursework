/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachineMVC.Dao;

import com.sg.vendingMachineMVC.UserIO.UserIO;
import com.sg.vendingMachineMVC.UserIO.UserIoImpl;
import com.sg.vendingMachineMVC.model.Inventory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author benli
 */
public class DaoFileImpl implements Dao {
      private UserIO io = new UserIoImpl();
        
    
    private Map<String, Inventory> stock = new HashMap<>();

    public void makePurchase() throws PersistenceException{
        int quarters = 0;
        int dimes = 0;
        int nickles = 0;
        int pennies = 0;
        double payment;
        double change;
        
        loadRoster();
        
        for (String soda : stock.keySet()) {
            System.out.println(soda);
        }
        String selection = io.readString("What soda would you like to purchase?");
       
        Inventory currentInventory = stock.get(selection);
        
                
        System.out.println(selection + " : " + currentInventory.getPrice());
        payment = io.readDouble("Please enter your payment");
        
             double price = currentInventory.getPrice().doubleValue();
        change = payment - price;
        
        if (currentInventory.getInventory() <= 0) {
            System.out.println("This item is not in stock");
        }
        
        if (payment < price) {
           do { payment = payment + io.readDouble("Insert more money");
        } while (payment < price);
        }
        
         if (payment > price) {
             change = payment - price; 
                
        if (change >= .25) {
            do {
                 quarters++;
                 change = change - .25;
             }while (change > 0.25);
        }
        if (change >= .10) {
            do {
                 dimes++;
                 change = change - .10;
             }while (change > 0.10);
        }
        if (change >= .05) {
            do {
                 nickles++;
                 change = change - .05;
             }while (change > 0.05);
        }
        if (change >= .00) {
            do {
                 pennies++;
                 change = change - .01;
             }while (change > 0.01);
        }
        
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickles " + nickles);
        System.out.println("Pennies: " + pennies);
        System.out.println("Enjoy!");
        
        int newInventory = currentInventory.getInventory();
        newInventory--;
        currentInventory.setInventory(newInventory--);
        
        writeRoster();
         }
       
    }
    
    @Override
    public Inventory addInventory(String soda, Inventory inventory) throws PersistenceException {
        Inventory newItem = stock.put(soda, inventory);
        writeRoster();
        return newItem;
    }

    @Override
    public List<Inventory> getAllInventory() throws PersistenceException {
        loadRoster();
        return new ArrayList<Inventory>(stock.values());
    }

    @Override
    public Inventory removeItem(String soda) throws PersistenceException {
        
       Inventory removedInventory = stock.remove(soda);
       writeRoster();
       return removedInventory;
    }
   
    public static final String ROSTER_FILE = "inventory.txt";
    
    public static final String DELIMITER = "::";
    
    private void loadRoster() throws PersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader
            (ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException("Could not load roster data to memory", e);
        }
            String currentLine;
            String[] currentTokens;
            
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                
                currentTokens = currentLine.split(DELIMITER);
                
                
                
                Inventory currentInventory = new Inventory();
                
                
                               
                currentInventory.setSoda(currentTokens[0]);
                BigDecimal price = new BigDecimal(currentTokens[1]);
                currentInventory.setPrice(price);
                int inventory = Integer.parseInt(currentTokens[2]);
                currentInventory.setInventory(inventory);
                
                
                 
                stock.put(currentInventory.getSoda(), currentInventory);
            }
            scanner.close();
            }
    private void writeRoster() throws PersistenceException {
        PrintWriter out;
        
         try {
             out = new PrintWriter(new FileWriter(ROSTER_FILE));
         } catch (IOException e) {
             throw new PersistenceException("Could not save data", e);
         }
         List<Inventory> itemsList = this.getAllInventory();
         
         for (Inventory currentInventory : itemsList) {
             out.println(currentInventory.getSoda() + DELIMITER + 
                     currentInventory.getPrice() + DELIMITER + currentInventory.getInventory());
             out.flush();
         }
         out.close();
    }
           
    }
    
