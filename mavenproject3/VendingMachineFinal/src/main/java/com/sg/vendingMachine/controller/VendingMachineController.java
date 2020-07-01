/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachine.controller;
import com.sg.vendingMachine.dao.VendingMachineDao;
import java.io.File;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author benli
 */

@Controller
public class VendingMachineController {
    
    VendingMachineDao dao;
   
    @Inject
    public VendingMachineController(VendingMachineDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/items",
            method = RequestMethod.GET) 
    public String getItems() {
        return "items.txt";
    }
    
}
