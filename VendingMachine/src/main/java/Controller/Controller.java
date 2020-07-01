/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.Inventory;
import Dao.Dao;
import Dao.DaoPersistenceException;
import Dao.PersistenceException;
import Service.DataValidationException;
import Service.DuplicateItemException;
import Service.ServiceLayer;
import UserIO.UserIO;
import UserIO.UserIoImpl;
import UserIO.View;
import java.util.List;

/**
 *
 * @author benli
 */
public class Controller {
    
    View view;
    Dao dao;
    private UserIO io = new UserIoImpl();
    private ServiceLayer service;
    
    
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {
            
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    makePurchase();
                    break;
                case 2:
                    addInventory();
                    break;
                case 3:
                    removeInventory();
                    break;
                case 4:
                    listInventory();
                    break;
                case 5:
                    keepGoing = false;
                default:
                    unknownCommand();
                }
            
            }
        exitMessage();
        } catch (PersistenceException e) {
            view.displayErrorMessage("Action not supported");
        }
    }
    
    public Controller(ServiceLayer service, View view, Dao dao) {
        this.service = service;
        this.view = view;
        this.dao = dao;
    }
    
        
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void addInventory() throws PersistenceException{
        view.displayAddInventoryBanner();
        boolean hasErrors = false;
        do {
        Inventory newInventory = view.getNewItemInfo();
        try {
        service.addInventory(newInventory);
        view.displayAddInventorySuccessBanner();
        hasErrors = false;
        } catch (DuplicateItemException | DataValidationException e) {
            hasErrors = true;
            view.displayErrorMessage(e.getMessage());
        } 
        } while (hasErrors);
    }
    
    private void listInventory() throws PersistenceException {
        view.displayDisplayAllBanner();
        List<Inventory> newInventory = service.getAllInventory();
        view.displayStockList(newInventory);
    }
    
    private void removeInventory() throws PersistenceException {
        view.displayRemoveInventoryBanner();
        String soda = view.getSodaChoice();
        service.removeInventory(soda);
        view.displayRemoveInventorySuccessBanner();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
    private void makePurchase() throws PersistenceException {
        view.displayMakePurchaseBanner();
        dao.makePurchase();
        view.displayPurchaseMade();
    }
}
