/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.service;

import com.sg.supersspringmvc.dao.LocationDao;
import com.sg.supersspringmvc.dao.LocationSearchTerm;
import com.sg.supersspringmvc.model.Location;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public class LocationServiceImpl implements LocationService {

    LocationDao dao;
    
    public LocationServiceImpl(LocationDao dao) {
        this.dao = dao;
    }
    
    public void validateLocationData(Location location) throws DataValidationException {
       if(location.getName() == null || location.getName().trim().length() == 0 ||
          location.getStreet() == null || location.getStreet().trim().length() == 0 ||  
          location.getCity() == null || location.getCity().trim().length() == 0 ||  
          location.getState() == null || location.getState().trim().length() == 0 ||  
          location.getZipCode() == null || location.getZipCode().trim().length() == 0 ||  
          location.getLatitude()== 0 ||  
          location.getLongitude()== 0) {
           throw new DataValidationException("Error: All Fields Required");
               }
    }

       
     @Override
    public Location addLocation(Location location) throws DataValidationException {
        
        validateLocationData(location);
        
        Location newLocation = dao.addLocation(location);
    
        return newLocation;
    }
       
    @Override
    public void removeLocation(int locationId) {
        dao.removeLocation(locationId);
    }

    @Override
    public void updateLocation(Location location) {
        dao.updateLocation(location);
    }

    @Override
    public List<Location> getAllLocations() {
        return dao.getAllLocations();                
    }

    @Override
    public Location getLocationById(int locationId) {
        return dao.getLocationById(locationId);
    }

    @Override
    public List<Location> searchLocations(Map<LocationSearchTerm, String> criteria) {
        List<Location> locationList = dao.searchLocations(criteria);
        return locationList;
    }
    
}
