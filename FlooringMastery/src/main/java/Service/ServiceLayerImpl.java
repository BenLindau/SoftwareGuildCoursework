/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.Order;
import Dao.AuditDao;
import Dao.Dao;
import Dao.PersistenceException;
import java.util.List;

/**
 *
 * @author benli
 */
public class ServiceLayerImpl implements Service {

    Dao dao;
    private AuditDao auditDao;
    
    public ServiceLayerImpl(Dao dao, AuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
        
    @Override
    public void addOrder(Order order) throws DuplicateIdException, DataValidationException, PersistenceException {
       
        if (dao.getOrder(order.getOrderNum()) != null) {
            throw new DuplicateIdException("Error: Order already exists");
        }
        validateOrderData(order);
        
        dao.addOrder(order.getOrderNum(), order);
        
       // auditDao.writeAuditEntry("Order " + order.getOrderNum() + " created.");
    }

    @Override
    public List<Order> getOrders() throws PersistenceException {
        return dao.getOrders();
    }

    @Override
    public Order getOrder(String orderNum) throws PersistenceException {
        return dao.getOrder(orderNum);
    }
    
    public Order editOrder(Order editedOrder) throws PersistenceException {
        
        auditDao.writeAuditEntry("Order " + editedOrder.getOrderNum() + " was edited.");
        
        return dao.editOrder(editedOrder);
    }
    @Override
    public Order removeOrder(String orderNum) throws PersistenceException {
        
        Order removedOrder = dao.removeOrder(orderNum);
        
        // auditDao.writeAuditEntry("Order " + orderNum + " removed.");
    
        
        return removedOrder;
        
    }
    
    private void validateOrderData(Order order) throws DataValidationException {
        
        if (order.getOrderNum() == null || order.getName().trim().length() == 0  || 
                order.getState().trim().length() == 0 ||
                order.getTaxRate() == 0 || order.getArea().equals(null) ||
                order.getMaterial().trim().length() == 0) {
            throw new DataValidationException("ERROR: Order already exists");
        }
        
    }
   
    @Override
    public void saveUpdates() throws PersistenceException {
        dao.saveUpdates();
    }
   
    
}
