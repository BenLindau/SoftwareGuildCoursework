/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Location;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public interface LocationDao {
    
     
    public Location addLocation(Location location);
    
    public void removeLocation(int locationId);
    
    public void updateLocation(Location location);
    
    public List<Location> getAllLocations();
    
    public Location getLocationById(int locationId);
    
    public List<Location> searchLocations(Map<LocationSearchTerm, String> criteria);

    
}
