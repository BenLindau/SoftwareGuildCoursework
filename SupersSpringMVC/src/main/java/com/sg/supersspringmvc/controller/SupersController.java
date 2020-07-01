/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.controller;

import com.sg.supersspringmvc.model.Hero;
import com.sg.supersspringmvc.model.Location;
import com.sg.supersspringmvc.model.Organization;
import com.sg.supersspringmvc.model.Sighting;
import com.sg.supersspringmvc.service.DataValidationException;
import com.sg.supersspringmvc.service.HeroService;
import com.sg.supersspringmvc.service.LocationService;
import com.sg.supersspringmvc.service.OrganizationService;
import com.sg.supersspringmvc.service.SightingService;
import java.util.ArrayList;
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
public class SupersController {
   
HeroService heroService;
LocationService locationService;
OrganizationService orgService;
SightingService sightingService;



@Inject
public SupersController(HeroService heroService, LocationService locationService,
        OrganizationService orgService, SightingService sightingService) {
    this.heroService = heroService;
    this.locationService = locationService;
    this.orgService = orgService;
    this.sightingService = sightingService;
}


//====================================Display Methods======================================
    
    @RequestMapping(value="/",
            method = RequestMethod.GET)
    public String displayMainPage(Model model) {
        List<Sighting> recentSightings = sightingService.getAllSightings();
        
                
        model.addAttribute("sightingList", recentSightings);
        
        return "index";
    }

    @RequestMapping(value = "/displayHeroList",
            method = RequestMethod.GET)
    public String displayHeroList(Model model) {
        List<Hero> heroList = heroService.getAllHeros();
        List<Location> locationList = locationService.getAllLocations();
        List<Organization> orgList = orgService.getAllOrganizations();
        
        model.addAttribute("heroList", heroList);
        model.addAttribute("locationList", locationList);
        model.addAttribute("orgList", orgList);
               
        return "heroList";
    }
    
    @RequestMapping(value = "/displayLocations",
            method = RequestMethod.GET)
    public String displayLocationList(Model model) {
        List<Location> locationList = locationService.getAllLocations();
        
        model.addAttribute("locationList", locationList);
        
        return "locations";
    }
    
    @RequestMapping(value = "/displaySightings",
            method = RequestMethod.GET)
    public String displaySightings(Model model) {
        List<Hero> heroList = heroService.getAllHeros();
        List<Location> locationList = locationService.getAllLocations();
        List<Sighting> sightingList = sightingService.getAllSightings();
        
        model.addAttribute("heroList", heroList);
        model.addAttribute("locationList", locationList);
        model.addAttribute("sightingList", sightingList);
               
        return "sighting";
    }
    
    @RequestMapping(value = "/displayOrganizations",
            method = RequestMethod.GET)
    public String displayOrganizations(Model model) {
        List<Organization> orgList = orgService.getAllOrganizations();
        List<Location> locationList = locationService.getAllLocations();
        
        model.addAttribute("orgList", orgList);
        model.addAttribute("locationList", locationList);
        
        return "Organization";
    }
//========================================CREATE METHODS===================================
    
    @RequestMapping(value = "/createHero",
            method = RequestMethod.POST)
    public String createHero(HttpServletRequest request) throws DataValidationException {
        Hero hero = new Hero();
        hero.setName(request.getParameter("name"));
        hero.setDescription(request.getParameter("description"));
        hero.setPowers(request.getParameter("powers"));
        String locationId = request.getParameter("locationId");
        int intLocation = Integer.parseInt(locationId);
        hero.setLocationId(intLocation);
        String orgId = request.getParameter("orgId");
        int intOrgId = Integer.parseInt(orgId);
        hero.setOrganizationId(intOrgId);
        
        heroService.addHero(hero);
        
        return "redirect:displayHeroList";
    }
    
    @RequestMapping(value = "/createLocation",
            method = RequestMethod.POST)
    public String createLocation(HttpServletRequest request) 
        throws DataValidationException {
        Location loc = new Location();
        loc.setName(request.getParameter("name"));
        loc.setStreet(request.getParameter("street"));
        loc.setCity(request.getParameter("city"));
        loc.setState(request.getParameter("state"));
        loc.setZipCode(request.getParameter("zipCode"));
        String stringLat = request.getParameter("latitude");
        double dubLat = Double.parseDouble(stringLat);
        loc.setLatitude(dubLat);
        String stringLong = request.getParameter("longitude");
        Double dubLong = Double.parseDouble(stringLong);
        loc.setLongitude(dubLong);
        
        locationService.addLocation(loc);
        
        return "redirect:displayLocations";
    }
    
    @RequestMapping(value = "/createSighting",
            method = RequestMethod.POST)
    public String createSighting(HttpServletRequest request) throws DataValidationException {
        Sighting sighting = new Sighting();
        String heroId = request.getParameter("heroId");
        int intHeroId = Integer.parseInt(heroId);
        sighting.setHeroId(intHeroId);
        String locationId = request.getParameter("locationId");
        int intLocation = Integer.parseInt(locationId);
        sighting.setLocationId(intLocation);
        sighting.setDate(request.getParameter("date"));
        
        
        sightingService.addSighting(sighting);
        
        return "redirect:displaySightings";
    }
    
    @RequestMapping(value = "/createOrg",
            method = RequestMethod.POST)
    public String createOrg(HttpServletRequest request) throws DataValidationException {
        Organization org = new Organization();
        org.setName(request.getParameter("name"));
        String locString = request.getParameter("locationId");
        int intLoc = Integer.parseInt(locString);
        org.setLocationId(intLoc);
        org.setPhone(request.getParameter("phone"));
        org.setEmail(request.getParameter("email"));
        
        orgService.addOrganization(org);
        
        return "redirect:displayOrganizations";
    }
    
//=====================================Deatils Pages======================================
    
    @RequestMapping(value = "/displayHeroDetails",
            method = RequestMethod.GET)
    public String displayHeroDetails(HttpServletRequest request,
            Model model) {
        String heroIdParameter = request.getParameter("heroId");
        int heroId = Integer.parseInt(heroIdParameter);
        
        Hero hero = heroService.getHeroById(heroId);
        
        model.addAttribute("hero", hero);
        
        return "heroDetails";
                
    }
    
    @RequestMapping(value = "/displayLocationDetails",
            method = RequestMethod.GET)
    public String displayLocationDetails(HttpServletRequest request,
            Model model) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);
        
        Location location = locationService.getLocationById(locationId);
        model.addAttribute("location", location);
        return "locationDetails";        
    }
    
    @RequestMapping(value = "/displayOrgDetails",
            method = RequestMethod.GET)
    public String displayOrgDetails(HttpServletRequest request,
            Model model) {
        String orgIdParameter = request.getParameter("orgId");
        int orgId = Integer.parseInt(orgIdParameter);
        
        Organization org = orgService.getOrganizationById(orgId);
        model.addAttribute("org", org);
        return "orgDetails";        
    }
    
//==========================DELETE METHODS=======================================
    
    @RequestMapping(value = "/deleteHero",
            method = RequestMethod.GET)
    public String deleteHero(HttpServletRequest request) {
        String heroIdParameter = request.getParameter("heroId");
        int heroId = Integer.parseInt(heroIdParameter);
        heroService.removeHero(heroId);
        return "redirect:displayHeroList";
    }

    @RequestMapping(value = "/deleteLocation",
            method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {
        String locationIdParameter = request.getParameter("locationId");
        int intLocId = Integer.parseInt(locationIdParameter);
        locationService.removeLocation(intLocId);
        return "redirect:displayLocations";
    }
    
    @RequestMapping(value = "/deleteSighting",
            method = RequestMethod.GET)
    public String deleteSighting(HttpServletRequest request) {
        String sightingIdParameter = request.getParameter("sightingId");
        int intSightingId = Integer.parseInt(sightingIdParameter);
        sightingService.removeSighting(intSightingId);
        return "redirect:displaySightings";
    }
    
    @RequestMapping(value = "/deleteOrganization",
            method = RequestMethod.GET)
    public String deleteOrganization(HttpServletRequest request) {
        String orgIdParameter = request.getParameter("orgId");
        int intOrgId = Integer.parseInt(orgIdParameter);
        orgService.removeOrganization(intOrgId);
        return "redirect:displayOrganizations";
    }
    
//===================================EDIT METHODS========================
    @RequestMapping(value = "/dislpayEditHeroForm",
            method = RequestMethod.GET) 
    public String displayEditHeroForm (HttpServletRequest request,
            Model model) {
        String heroIdParameter = request.getParameter("heroId");
        int heroId = Integer.parseInt(heroIdParameter);
        Hero hero = heroService.getHeroById(heroId);
        
        List<Location> locationList = locationService.getAllLocations();
        List<Organization> orgList = orgService.getAllOrganizations();
        model.addAttribute("hero", hero);
        model.addAttribute("locationList", locationList);
        model.addAttribute("orgList", orgList);
        
        return "editHero";        
    }
    
    @RequestMapping (value="editHero",
            method = RequestMethod.POST)
    public String editHero(@ModelAttribute("hero") Hero hero,
            BindingResult result, HttpServletRequest request) throws DataValidationException {
        if(result.hasErrors()) {
            return "editHero";
        }       
               
        heroService.updateHero(hero);
        return "redirect:displayHeroList";
    }
    
    @RequestMapping(value = "/dislpayEditLocationForm",
            method = RequestMethod.GET) 
    public String displayEditLocationForm (HttpServletRequest request,
            Model model) {
        String locationIdParameter = request.getParameter("locationId");
        int locationId = Integer.parseInt(locationIdParameter);
        Location location = locationService.getLocationById(locationId);
        
        model.addAttribute("location", location);
        
        
        return "editLocation";        
    }
    
    @RequestMapping (value="editLocation",
            method = RequestMethod.POST)
    public String editHero(@ModelAttribute("location") Location location,
            BindingResult result, HttpServletRequest request) throws DataValidationException {
        if(result.hasErrors()) {
            return "editLocation";
        }       
               
        locationService.updateLocation(location);
        return "redirect:displayLocations";
    }
    
    @RequestMapping(value = "/dislpayEditOrganizationForm",
            method = RequestMethod.GET) 
    public String displayEditOrganizationForm (HttpServletRequest request,
            Model model) {
        String orgIdParameter = request.getParameter("orgId");
        int orgId = Integer.parseInt(orgIdParameter);
        Organization org = orgService.getOrganizationById(orgId);
        List<Location> locationList = locationService.getAllLocations();
        
        model.addAttribute("org", org);
        model.addAttribute("locationList", locationList);
        
        return "editOrganization";        
    }
    
    @RequestMapping (value="/editOrganization",
            method = RequestMethod.POST)
    public String editOrganization(@ModelAttribute("org") Organization org,
            BindingResult result, HttpServletRequest request) throws DataValidationException {
        if(result.hasErrors()) {
            return "editOrganization";
        }       
        
        orgService.updateOrganization(org);
        return "redirect:displayOrganizations";
    }
    
    @RequestMapping(value = "/dislpayEditSightingForm",
            method = RequestMethod.GET) 
    public String displayEditSightingForm (HttpServletRequest request,
            Model model) {
        String sightingIdParameter = request.getParameter("sightingId");
        int sightingId = Integer.parseInt(sightingIdParameter);
        Sighting sighting = sightingService.getSightingById(sightingId);
        
        List<Location> locationList = locationService.getAllLocations();
        List<Hero> heroList = heroService.getAllHeros();
        model.addAttribute("sighting", sighting);
        model.addAttribute("locationList", locationList);
        model.addAttribute("heroList", heroList);
        
        return "editSighting";        
    }
    
    @RequestMapping (value="editSighting",
            method = RequestMethod.POST)
    public String editSighting(@ModelAttribute("sighting") Sighting sighting, 
            BindingResult result, HttpServletRequest request) throws DataValidationException {
        if(result.hasErrors()) {
            return "editOrganization";
        }     
        sightingService.updateSighting(sighting);
        return "redirect:displaySightings";
    }
    
}
