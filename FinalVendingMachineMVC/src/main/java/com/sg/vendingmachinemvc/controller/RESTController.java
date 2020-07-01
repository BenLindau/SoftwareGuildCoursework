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
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author benli
 */

@CrossOrigin
@Controller
public class RESTController {
   
    private Dao dao;
    
    @Inject
    public RESTController(Dao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/inventory", 
            method = RequestMethod.GET)
    @ResponseBody
    public List<Inventory> getAllInventory() throws PersistenceException {
        return dao.getAllInventory();
    }
    
}
