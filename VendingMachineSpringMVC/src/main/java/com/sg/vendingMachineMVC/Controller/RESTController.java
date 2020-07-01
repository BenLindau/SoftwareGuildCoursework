/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachineMVC.Controller;

import com.sg.vendingMachineMVC.Dao.Dao;
import com.sg.vendingMachineMVC.Dao.PersistenceException;
import com.sg.vendingMachineMVC.model.Inventory;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Controller;
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
