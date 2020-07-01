/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachine.dao;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.vendingMachine.model.Item;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benli
 */
public class InMemDaoImpl implements VendingMachineDao {

    //public Map<Integer, Item> itemsMap = new HashMap<>();
    
    @Override
    public  List<Map<Integer, Item>> getAllItems() {
        
        String json = "items.txt";
        ObjectMapper mapper = new ObjectMapper();
        
        List<Map<Integer, Item>> itemsMap = mapper.readValue(json, new TypeReference<List<Map<String, Object>>>(){});
        return itemsMap;
                
    }

    @Override
    public Item selectItem(long itemId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCash() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item updateItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

  

