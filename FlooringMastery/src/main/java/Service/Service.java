/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.Order;
import Dao.PersistenceException;
import java.util.List;

/**
 *
 * @author benli
 */
public interface Service {
    
    void addOrder(Order order) throws DuplicateIdException,
            DataValidationException, PersistenceException;
    
    List<Order> getOrders() throws PersistenceException;
    
    Order getOrder(String orderNum) throws PersistenceException;
    
    Order removeOrder(String orderNum) throws PersistenceException;
    
    Order editOrder(Order editedOrder) throws PersistenceException;
    
    void saveUpdates() throws PersistenceException;
}
   
