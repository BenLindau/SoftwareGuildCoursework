/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author benli
 */
public class LocationDaoImpl implements LocationDao{
    
    //=====================LOCATION SQL STATEMENTS==================================        
        
        private static final String SQL_INSERT_LOCATION
                = "insert into locations (name, street, city, state, zipcode, latitude, longitude) "
                + "values (?, ?, ?, ?, ?, ?, ?)";
        private static final String SQL_DELETE_LOCATION
                = "delete from locations where locationId = ?";
        private static final String SQL_UPDATE_LOCATION
                = "update locations set "
                + "name = ?, street = ?, city = ?, state = ?, zipcode = ?, latitude = ?, longitude = ? "
                + "where locationId = ?";
        private static final String SQL_SELECT_LOCATION_BY_LOCATIONID
                = "select * from locations where locationId = ?";
        private static final String SQL_SELECT_ALL_LOCATIONS
                = "select * from locations";
    
    //========================JDBC INSTANCE==========================================================
 
        private JdbcTemplate jdbcTemplate;
    
        public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
    }   
    
    //=====================================LOCATION STATEMENTS=========================================
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Location addLocation(Location location) {
           
        jdbcTemplate.update(SQL_INSERT_LOCATION, 
                location.getName(),
                location.getStreet(),
                location.getCity(),
                location.getState(),
                location.getZipCode(),
                location.getLatitude(),
                location.getLongitude());
        
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        
        location.setLocationId(newId);
        return location;
    
    }

    @Override
    public void removeLocation(int locationId) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationId);
    }

    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getName(),
                location.getStreet(),
                location.getCity(),
                location.getState(),
                location.getZipCode(),
                location.getLatitude(),
                location.getLongitude(),
                location.getLocationId());
    }

    @Override
    public List<Location> getAllLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS, 
                new LocationDaoImpl.LocationMapper());
    }


    @Override
    public Location getLocationById(int locationId) {
         try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION_BY_LOCATIONID,
                   new LocationDaoImpl.LocationMapper(), locationId);
        } catch (EmptyResultDataAccessException ex) {
                return null;
    }
    } 

    @Override
    public List<Location> searchLocations(Map<LocationSearchTerm, String> criteria) {
        
        if (criteria.isEmpty()) {
            return getAllLocations();
        } else {
            
            StringBuilder sQuery = new StringBuilder("select * from locations where ");
            
            int numParams = criteria.size();
            int paramPosition = 0;
            
            String[] paramVals = new String[numParams];
            Set<LocationSearchTerm> keySet = criteria.keySet();
            Iterator<LocationSearchTerm> iter = keySet.iterator();
            
            while(iter.hasNext()) {
                LocationSearchTerm currentKey = iter.next();
                
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                sQuery.append(currentKey);
                sQuery.append(" = ? ");
                
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            return jdbcTemplate.query(sQuery.toString(),
                    new LocationDaoImpl.LocationMapper(), paramVals);
        }
     }
    
    
      private static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
                
             Location location = new Location();
             location.setLocationId(rs.getInt("locationId"));
             location.setName(rs.getString("name"));
             location.setStreet(rs.getString("street"));
             location.setCity(rs.getString("city"));
             location.setState(rs.getString("state"));
             location.setZipCode(rs.getString("zipCode"));
             location.setLatitude(rs.getDouble("latitude"));
             location.setLongitude(rs.getDouble("longitude"));
             
             return location;
                
        }
         
    }
    
}
