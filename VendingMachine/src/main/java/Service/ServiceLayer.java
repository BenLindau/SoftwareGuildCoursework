/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.Inventory;
import Dao.PersistenceException;
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
