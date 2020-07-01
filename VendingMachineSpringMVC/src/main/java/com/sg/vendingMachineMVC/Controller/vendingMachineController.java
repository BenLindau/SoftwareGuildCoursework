/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachineMVC.Controller;

import com.sg.vendingMachineMVC.Dao.Dao;
import com.sg.vendingMachineMVC.Dao.PersistenceException;
import com.sg.vendingMachineMVC.Service.DataValidationException;
import com.sg.vendingMachineMVC.Service.DuplicateItemException;
import com.sg.vendingMachineMVC.Service.ServiceLayer;
import com.sg.vendingMachineMVC.UserIO.UserIO;
import com.sg.vendingMachineMVC.UserIO.UserIoImpl;
import com.sg.vendingMachineMVC.UserIO.View;
import com.sg.vendingMachineMVC.model.Inventory;
import java.util.List;
import javax.inject.Inject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

/**
 *
 * @author benli
 */


@Controller
public class vendingMachineController {
    
    
    View view;
    Dao dao;
    private UserIO io = new UserIoImpl();
    private ServiceLayer service;
  
    
    @Inject
    public vendingMachineController(Dao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/inventory", 
            method = RequestMethod.GET)
    public String getAllInventory(Model model) throws PersistenceException {
        List<Inventory> itemsList = dao.getAllInventory();
        model.addAttribute("itemsList", itemsList);
        return "index";
    }
    
     
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
    
    public vendingMachineController(ServiceLayer service, View view, Dao dao) {
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

