/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachine.dao;

import com.sg.vendingMachine.model.Item;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public interface VendingMachineDao {
    
   public List<Map<Integer, Item>> getAllItems();
      
   public Item selectItem(long itemId);
   
   public void getCash();
   
   public Item updateItem();
   
   }
