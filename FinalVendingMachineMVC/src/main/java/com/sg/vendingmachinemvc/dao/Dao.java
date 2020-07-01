/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemvc.dao;

import com.sg.vendingmachinemvc.model.Inventory;
import java.util.List;

/**
 *
 * @author benli
 */
public interface Dao {
    
    public String makePurchase(double payment, int itemId) throws PersistenceException;
    
    public Inventory getItemById(int itemId) throws PersistenceException;
    
    List<Inventory> getAllInventory() throws PersistenceException;
    
    }