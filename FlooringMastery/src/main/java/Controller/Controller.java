/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.Order;
import Dao.Dao;
import Dao.PersistenceException;
import Service.DataValidationException;
import Service.DuplicateIdException;
import Service.Service;
import UserIO.UserIO;
import UserIO.UserIOFileImpl;
import UserIO.View;
import java.util.List;

/**
 *
 * @author benli
 */
public class Controller {
    
    Service service;
    private UserIO io = new UserIOFileImpl();
    View view;
    
    public Controller(Service service, View view) {
        this.service = service;
        this.view = view;
    }
        
    public void run() throws DuplicateIdException, DataValidationException {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {
            
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    listOrders();
                    break;
                case 2:
                    createOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    viewOrder();
                    break;
                case 5:
                    removeOrder();
                    break;
                case 6:
                    saveUpdates();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    } catch (PersistenceException e) {
        view.displayErrorMessage(e.getMessage());
        }
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createOrder() throws PersistenceException, DuplicateIdException, DataValidationException {
        view.displayCreateOrderBanner();
        Order newOrder = view.getNewOrderInfo();
        service.addOrder(newOrder);
        view.displayCreateOrderSuccessBanner();
    }
    
    private void listOrders() throws PersistenceException {
        view.displayAllOrdersBanner();
        List<Order> orderList = service.getOrders();
        view.displayAllOrders(orderList);
    }
    
    private void editOrder() throws PersistenceException {
        view.displayEditOrderBanner();
        String editedOrderNum = view.getOrderNum();
        Order editedOrder = service.getOrder(editedOrderNum);
        view.editOrder(editedOrder);
        service.editOrder(editedOrder);
        view.displayOrderEditedBanner();
    }
    
    private void viewOrder() throws PersistenceException {
        view.displayViewOrderbanner();
        String orderNum = view.getOrderNum();
        Order order = service.getOrder(orderNum);
        view.displayOrder(order);
    }
    
    private void removeOrder() throws PersistenceException {
        view.displayRemoveOrderBanner();
        String orderNum = view.getOrderNum();
        service.removeOrder(orderNum);
        view.displayRemoveSuccessBanner();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
    private void saveUpdates() throws PersistenceException {
     service.saveUpdates();
     view.displaySaveUpdates();
    }
}
    
