/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachineMVC.Service;

import com.sg.vendingMachineMVC.Dao.Dao;
import com.sg.vendingMachineMVC.Dao.PersistenceException;
import com.sg.vendingMachineMVC.model.Inventory;
import java.util.List;

/**
 *
 * @author benli
 */
public class ServiceLayerImpl implements ServiceLayer{
    
    Dao dao;
    
    
    public ServiceLayerImpl(Dao dao) {
        this.dao = dao;
        
    }
    
    @Override
    public void addInventory(Inventory inventory) throws
        DuplicateItemException,
        DataValidationException,
        PersistenceException {
        
        validateData(inventory);
                
        dao.addInventory(inventory.getSoda(), inventory);
        
        //auditDao.writeAuditEntry("Soda: " + inventory.getSoda() + "Created.");
    }
    
    @Override
    public List<Inventory> getAllInventory() throws
             PersistenceException {
        return dao.getAllInventory();
    }
    
    @Override
    public Inventory removeInventory(String soda) throws
             PersistenceException {
        
        Inventory removedSoda = dao.removeItem(soda);
                
       // auditDao.writeAuditEntry("Soda: " + removedSoda.getSoda() + "Removed.");
      
        return removedSoda;
    }
    
    
    private void validateData(Inventory inventory) throws DataValidationException {
        
        if (inventory.getSoda().trim().length() == 0 ||
                inventory.getPrice().equals(null) ||
                inventory.getInventory() >= 0) {
            throw new DataValidationException("Error : All fields are required");
        }
    }
    
    
    
}

