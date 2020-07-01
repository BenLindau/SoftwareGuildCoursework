/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachineMVC.Service;

import com.sg.vendingMachineMVC.Dao.PersistenceException;
import com.sg.vendingMachineMVC.model.Inventory;
import java.util.List;

/**
 *
 * @author benli
 */
public interface ServiceLayer {
     
       
    void addInventory(Inventory inventory) throws
            DuplicateItemException,
            DataValidationException,
            PersistenceException;
            
    List<Inventory> getAllInventory() throws 
            PersistenceException;
    
    Inventory removeInventory(String soda) throws
            PersistenceException;
    
}

