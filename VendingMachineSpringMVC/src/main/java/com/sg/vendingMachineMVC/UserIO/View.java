/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachineMVC.UserIO;

import com.sg.vendingMachineMVC.model.Inventory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author benli
 */
public class View {
    
     
    private UserIO io;
    
    public View(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
            io.print("1. Make Purchase");
            io.print("2. Add Inventory");
            io.print("3. Remove Inventory");
            io.print("4. List Inventory");
            io.print("5. Exit");
            
            return io.readInt("Please select from the above choices", 1, 5);
            
    }
    
    public Inventory getNewItemInfo() {
        String soda = io.readString("Please enter new item name");
        BigDecimal price = new BigDecimal(io.readDouble("Please enter the price"));
        int inventory = io.readInt("Please enter number stocked");
        
        Inventory newInventory = new Inventory();
        
        newInventory.setSoda(soda);
        newInventory.setPrice(price);
        newInventory.setInventory(inventory);
        
        return newInventory;
    }
    
    public void displayAddInventoryBanner() {
        io.print("=== Add Inventory ===");
    }
    
    public void displayAddInventorySuccessBanner() {
        io.readString("=== Inventory Added ===");
    }
    
    public void displayStockList(List<Inventory> stockList) {
        
        for (Inventory newInventory : stockList) {
            io.print((newInventory.getSoda()) + " : " + newInventory.getPrice()
                    + " : " + newInventory.getInventory());
            } io.readString("Please hit enter to continue");
        }
    public void displayDisplayAllBanner() {
        io.print("=== Display All Items ===");
    }
    
    public void displayRemoveInventoryBanner() {
        io.print("=== Remove Item ===");
    }
    
    public void displayRemoveInventorySuccessBanner() {
        io.readString("=== Item Removed ===");
    }
    
    public String getSodaChoice() {
       return io.readString("Please enter soda name");
    }
    
    public void displayExitBanner() {
        io.print("Goodbye!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }
    public void displayMakePurchaseBanner() {
        io.print("Make Purchase");
    }
    public void displayPurchaseMade() {
        io.print("Item Vended");
    }
    public void displayErrorMessage(String errorMsg) {
	    io.print("=== ERROR ===");
	    io.print(errorMsg);
	}
}


