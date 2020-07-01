/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachine.controller;

import com.sg.vendingMachine.dao.VendingMachineDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author benli
 */

@CrossOrigin
@Controller
public class RESTController {

    private VendingMachineDao dao;
    
    @Inject
    public RESTController(VendingMachineDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/items", 
            method = RequestMethod.GET)
    @ResponseBody
    public String getItems() {
        return "items.txt";
    }
}
