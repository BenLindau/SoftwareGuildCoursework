/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemvc.dao;

import com.sg.vendingmachinemvc.model.Inventory;
import com.sg.vendingmachinemvc.userio.UserIO;
import com.sg.vendingmachinemvc.userio.UserIoFileImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    UserIO io = new UserIoFileImpl();
    
private Map<Integer, Inventory> stock = new HashMap<>();


    public String makePurchase(double payment, int itemId) throws PersistenceException{
        int quarters = 0;
        int dimes = 0;
        int nickles = 0;
        int pennies = 0;
        double change;
        
        loadRoster();
        
        Inventory item = stock.get(itemId);
        
        double price = item.getPrice();
        
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
        if (change > .00) {
            do {
                 pennies++;
                 change = change - .01;
             }while (change > 0.01);
        }      
        
               
               
        
         }
         int newInventory = item.getInventory();
        newInventory = newInventory - 1 ;
        item.setInventory(newInventory);
        
        writeRoster();
        
         String returnedChange = ("Quarters: " + quarters + " - " + "Dimes: " +
                dimes + " - "  + "Nickles " + nickles + " - " + "Pennies: " + pennies);
       return returnedChange;
    }
    
    

    @Override
    public List<Inventory> getAllInventory() throws PersistenceException {
        loadRoster();
        return new ArrayList<>(stock.values());
    }

    
    public static final String ROSTER_FILE = "inventory.txt"; 
    public static final String DELIMITER = "::";
    
    private void loadRoster() throws PersistenceException {
	    Scanner scanner;
	    try {
	          scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(getClass().getClassLoader().getResource("inventory.txt").getFile())));
            }  catch (FileNotFoundException e) {
            throw new PersistenceException("Could not load inventory data to memory", e);
            }           
            String currentLine;
            String[] currentTokens;
            
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                
                currentTokens = currentLine.split(DELIMITER);
                            
                Inventory currentInventory = new Inventory();
                 
                int itemId = Integer.valueOf(currentTokens[0]); 
                currentInventory.setItemId(itemId);
                currentInventory.setSoda(currentTokens[1]);
                double price = Double.parseDouble(currentTokens[2]);
                currentInventory.setPrice(price);
                int quantity = Integer.parseInt(currentTokens[3]);
                currentInventory.setInventory(quantity);
              
                stock.put(currentInventory.getItemId(), currentInventory);
            
            }
            
            scanner.close();
           }
                  
    private void writeRoster() throws PersistenceException {
        PrintWriter out;
        
         try {
             out = new PrintWriter(new FileWriter(getClass().getClassLoader().getResource("inventory.txt").getFile()));
         } catch (IOException e) {
             throw new PersistenceException("Could not save data", e);
         }
         List<Inventory> itemsList = this.getAllInventory();
         
         for (Inventory currentInventory : itemsList) {
             out.println(currentInventory.getItemId() + DELIMITER + currentInventory.getSoda() + DELIMITER + 
                     currentInventory.getPrice() + DELIMITER + currentInventory.getInventory());
             out.flush();
         }
         out.close();
    }

    @Override
    public Inventory getItemById(int itemId) throws PersistenceException {
        loadRoster();
        Inventory currentItem = stock.get(itemId);
               
        return currentItem;
    
    }
}
