/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author benli
 */

@Controller
public class SearchController {
    
    
    @RequestMapping(value = "/displaySearchHero",
            method = RequestMethod.GET) 
    public String displaySearchHero() {
        return "searchHero";
    }
    
    @RequestMapping(value = "/displaySearchLocation",
            method = RequestMethod.GET) 
    public String displaySearchLocations() {
        return "searchLocation";
    }
    
}
