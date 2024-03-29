/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.service;

import com.sg.supersspringmvc.dao.SightingSearchTerm;
import com.sg.supersspringmvc.model.Sighting;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public interface SightingService {
    
     public Sighting addSighting(Sighting sighting) throws DataValidationException;
    
    public void removeSighting(int sightingId);
    
    public void updateSighting(Sighting sighting);
    
    public List<Sighting> getAllSightings();
    
    public Sighting getSightingById(int sightingId);
    
    public List<Sighting> searchSighting(Map<SightingSearchTerm, String> criteria);
    
    
    
}
