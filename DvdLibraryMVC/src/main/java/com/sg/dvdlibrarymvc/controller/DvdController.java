/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.controller;

import com.sg.dvdlibrarymvc.dao.DvdDao;
import com.sg.dvdlibrarymvc.model.Dvd;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author benli
 */

@Controller
public class DvdController {
    
    DvdDao dao;
    
    @Inject
    public DvdController(DvdDao dao) {
        this.dao = dao;
    }
    
   
    @RequestMapping(value = "/displayDvdLibrary",
            method = RequestMethod.GET)
    public String displayDvdLibrary(Model model) {
        List<Dvd> dvdList = dao.getAllDvds();
        model.addAttribute("dvdList", dvdList);
        return "dvdLibrary";
    }
    
    @RequestMapping(value = "/createDvd", 
            method = RequestMethod.POST)
    public String createDvd(HttpServletRequest request) {
        Dvd dvd = new Dvd();
        dvd.setTitle(request.getParameter("title"));
        dvd.setReleaseDate(request.getParameter("releaseDate"));
        dvd.setDirector(request.getParameter("director"));
        dvd.setStudio(request.getParameter("studio"));
        dvd.setRating(request.getParameter("rating"));
        dvd.setComments(request.getParameter("comments"));
        
        dao.addDvd(dvd);
        
        return "redirect:displayDvdLibrary";
        
    }
    
    @RequestMapping(value = "/displayDvdDetails",
            method = RequestMethod.GET)
    public String displayDvdDetails(HttpServletRequest request, Model model) {
        String dvdIdParameter = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdParameter);
        
        Dvd dvd = dao.getDvdById(dvdId);
        
        model.addAttribute("dvd", dvd);
        
        return "dvdDetails";
    }
    
    @RequestMapping(value = "/deleteDvd",
            method = RequestMethod.GET) 
    public String deleteDvd(HttpServletRequest request) {
        String dvdIdParameter = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdParameter);
        dao.removeDvd(dvdId);
        return "redirect:displayDvdLibrary";
    }
    
    @RequestMapping(value = "/displayEditDvdForm",
            method = RequestMethod.GET)
    public String displayEditDvdForm(HttpServletRequest request, 
            Model model) {
        String dvdIdParameter = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdParameter);
        Dvd dvd = dao.getDvdById(dvdId);
        model.addAttribute("dvd", dvd);
        return "editDvdForm";
    }
    
    @RequestMapping(value = "/editDvd",
            method = RequestMethod.POST)
    public String editDvd(@Valid @ModelAttribute("dvd") Dvd dvd,
            BindingResult result) {
        if (result.hasErrors()) {
            return "editDvdForm";
        }
        dao.updateDvd(dvd);
        return "redirect:displayDvdLibrary";
    }
}

