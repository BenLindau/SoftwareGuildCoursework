/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.Order;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benli
 */
public class DaoStubImpl implements Dao{

       
    private Order onlyOrder;
    private List<Order> orderList = new ArrayList<>();
    
    public DaoStubImpl() {
        onlyOrder = new Order();
        
        double dubArea = 123.123;
        BigDecimal area = new BigDecimal(dubArea);
        
        onlyOrder.setOrderNum("12345");
        onlyOrder.setName("Joe");
        onlyOrder.setState("WI");
        onlyOrder.setTaxRate(.05);
        onlyOrder.setArea(area);
        onlyOrder.setMaterial("tile");
         
        orderList.add(onlyOrder);
    }
    
    @Override
    public Order addOrder(String orderNum, Order order) throws PersistenceException {
       /*if (orderNum.equals(onlyOrder.getOrderNum())) {
           return onlyOrder;
       } else {
           return null;
      }*/
       orderList.add(onlyOrder);
       return onlyOrder;
    }

    @Override
    public List<Order> getOrders() throws PersistenceException {
        return orderList;
    }

    @Override
    public Order editOrder(Order editedOrder) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getOrder(String orderNum) throws PersistenceException {
        if (orderNum.equalsIgnoreCase(onlyOrder.getOrderNum())) {
            return onlyOrder; 
        } else {
            return null;
        }
    }

    @Override
    public Order removeOrder(String orderNum) throws PersistenceException {
        if (orderNum.equalsIgnoreCase(onlyOrder.getOrderNum())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public void saveUpdates() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
