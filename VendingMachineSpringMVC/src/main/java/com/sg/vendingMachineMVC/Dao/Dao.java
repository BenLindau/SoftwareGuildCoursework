/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachineMVC.Dao;

import com.sg.vendingMachineMVC.model.Inventory;
import java.util.List;

/**
 *
 * @author benli
 */
public interface Dao {
    
    public void makePurchase() throws PersistenceException;
    
    Inventory addInventory(String soda, Inventory inventory) throws PersistenceException;
    
    List<Inventory> getAllInventory() throws PersistenceException;
    
    Inventory removeItem(String soda) throws PersistenceException;
    
    
}
