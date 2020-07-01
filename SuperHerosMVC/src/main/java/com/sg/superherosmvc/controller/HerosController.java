/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author benli
 */

@Controller
public class HerosController {
    
    @RequestMapping(value = "/displayHeroList",
            method = RequestMethod.GET)
    public String displayHeroList(Model model) {
        return "heroList";
    }
    
    
    
    
}
