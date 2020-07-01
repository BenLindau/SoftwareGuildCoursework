/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemvc.controller;

import com.sg.vendingmachinemvc.dao.Dao;
import com.sg.vendingmachinemvc.dao.PersistenceException;
import com.sg.vendingmachinemvc.model.Inventory;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author benli
 */

@Controller
public class vendingMachineController {
    
    Dao dao; 
    
    @Inject
    public vendingMachineController(Dao dao) {
        this.dao = dao;
    }

    private double change = 0;
    
    
    @RequestMapping(value="/", 
            method = RequestMethod.GET)
    public String getAllInventory(Model model) throws PersistenceException {
        List<Inventory> inventory = dao.getAllInventory();
        model.addAttribute("inventory", inventory);
        model.addAttribute("change", change);
        
        return "index";
    }
    
    @RequestMapping(value="/menuItems", 
            method = RequestMethod.GET)
    public String selectItem(HttpServletRequest request, 
            Model model) throws PersistenceException {
        List<Inventory> inventory = dao.getAllInventory();
        model.addAttribute("inventory", inventory);
        
        String stringid = request.getParameter("currentId");
        int itemId = Integer.parseInt(stringid);
        Inventory currentItem = dao.getItemById(itemId);      
        
                        
        model.addAttribute("item", currentItem);
        model.addAttribute("change", change);
        
        
        return "listItem";
    }
    
    @RequestMapping(value="/addQuarter", 
            method= RequestMethod.GET)
    public String addQuarter(HttpServletRequest request, Model model) throws PersistenceException {
        List<Inventory> inventory = dao.getAllInventory();
        model.addAttribute("inventory", inventory);
         String stringid = request.getParameter("currentId");
        int itemId = Integer.parseInt(stringid);
        Inventory currentItem = dao.getItemById(itemId);      
        
        change = change + .25;    
        
        model.addAttribute("item", currentItem);
        model.addAttribute("change", change);
                
                
        return "listItem";
    }
              
    @RequestMapping(value="/addDime", 
            method= RequestMethod.GET)
    public String addDime(HttpServletRequest request, Model model) throws PersistenceException {
        List<Inventory> inventory = dao.getAllInventory();
        model.addAttribute("inventory", inventory);
         String stringid = request.getParameter("currentId");
        int itemId = Integer.parseInt(stringid);
        Inventory currentItem = dao.getItemById(itemId);      
        
        change = change + .10;    
        
        model.addAttribute("item", currentItem);
        model.addAttribute("change", change);
       
        
        return "listItem";
    }
     
    @RequestMapping(value="/addNickel", 
            method= RequestMethod.GET)
    public String addNickel(HttpServletRequest request, Model model) throws PersistenceException {
        List<Inventory> inventory = dao.getAllInventory();
        model.addAttribute("inventory", inventory);
         String stringid = request.getParameter("currentId");
        int itemId = Integer.parseInt(stringid);
        Inventory currentItem = dao.getItemById(itemId);      
        
        change = change + .05;    
        
        model.addAttribute("item", currentItem);
        model.addAttribute("change", change);
       
        
        return "listItem";
    }
    
    @RequestMapping(value="/addPenny", 
            method= RequestMethod.GET)
    public String addPenny(HttpServletRequest request, Model model) throws PersistenceException {
        List<Inventory> inventory = dao.getAllInventory();
        model.addAttribute("inventory", inventory);
         String stringid = request.getParameter("currentId");
        int itemId = Integer.parseInt(stringid);
        Inventory currentItem = dao.getItemById(itemId);      
        
        change = change + .01;    
        
        model.addAttribute("item", currentItem);
        model.addAttribute("change", change);
       
        
        return "listItem";
    }
    
    @RequestMapping(value="/makePurchase",
            method = RequestMethod.GET) 
    public String makePurchase(HttpServletRequest request,
             Model model) throws PersistenceException {
        
         List<Inventory> inventory = dao.getAllInventory();
        model.addAttribute("inventory", inventory);
        
        
        
        String stringid = request.getParameter("currentId");
        int itemId = Integer.parseInt(stringid);
        Inventory currentItem = dao.getItemById(itemId); 
        model.addAttribute("item", currentItem);
        
        double payment = change;
        double price = currentItem.getPrice();
        int quantity = currentItem.getInventory();
        
        
        if (quantity == 0) {
                       
            return "SoldOut";
             
        } else if (payment < price) {
            return "MoreMoney";
            
        } else if(payment == price) {
             String changeReturned = dao.makePurchase(payment, itemId);
                       
            model.addAttribute("changeReturn", changeReturned);
            return "itemVend";
        } else {
            String changeReturned = dao.makePurchase(payment, itemId);
                        
            model.addAttribute("changeReturn", changeReturned);
            return "returnChange";
        }            
        
    }
    
    @RequestMapping(value="/abort", method = RequestMethod.GET)
    public String abortTransaction(HttpServletRequest request, Model model) throws PersistenceException {
        
        change = 0;
         
        List<Inventory> inventory = dao.getAllInventory();
        model.addAttribute("inventory", inventory);
        model.addAttribute("change", change);
       
        
        return "index";
    }

}
