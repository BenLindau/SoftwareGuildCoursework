/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.service;

import com.sg.supersspringmvc.dao.SightingDao;
import com.sg.supersspringmvc.dao.SightingSearchTerm;
import com.sg.supersspringmvc.model.Sighting;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public class SightingServiceImpl implements SightingService {

    SightingDao dao;
    
    public SightingServiceImpl(SightingDao dao) {
        this.dao = dao;
    }
    
    public void validateSightingData(Sighting sighting) throws DataValidationException {
        if(sighting.getHeroId() == 0 || sighting.getLocationId() == 0 ||
                sighting.getDate() == null || sighting.getDate().trim().length() == 0) {
            throw new DataValidationException("Error: All Fields Required");
        }
    }
    
    @Override
    public Sighting addSighting(Sighting sighting) throws DataValidationException {
        validateSightingData(sighting);
        Sighting newSighting = dao.addSighting(sighting);
        return newSighting;
    }

    @Override
    public void removeSighting(int sightingId) {
        dao.removeSighting(sightingId);
    }

    @Override
    public void updateSighting(Sighting sighting) {
        dao.updateSighting(sighting);
    }

    @Override
    public List<Sighting> getAllSightings() {
        return dao.getAllSightings();
    }

    @Override
    public Sighting getSightingById(int sightingId) {
        return dao.getSightingById(sightingId);
    }

    @Override
    public List<Sighting> searchSighting(Map<SightingSearchTerm, String> criteria) {
        List<Sighting> sightingList = dao.searchSighting(criteria);
        return sightingList;
    }
    
}
