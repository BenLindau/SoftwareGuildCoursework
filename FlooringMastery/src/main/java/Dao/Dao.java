/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.Order;
import java.util.List;

/**
 *
 * @author benli
 */
public interface Dao {
    
    Order addOrder(String orderNum, Order order) throws PersistenceException;
    
    List<Order> getOrders() throws PersistenceException;
    
    Order editOrder(Order editedOrder) throws PersistenceException;
    
    Order getOrder(String orderNum) throws PersistenceException;
    
    Order removeOrder(String orderNum) throws PersistenceException;
    
    void saveUpdates() throws PersistenceException; 
    
}
