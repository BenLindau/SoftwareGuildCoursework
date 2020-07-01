/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Sighting;
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
public class SightingDaoImpl implements SightingDao{
    
    //=================SIGHTING SQL STATEMENTS============================
        
        private static final String SQL_INSERT_SIGHTING
                = "insert into sightings "
                + "(heroId, locationId, Date) "
                + "values (?, ?, ?)";
        private static final String SQL_DELETE_SIGHTING
                = "delete from sightings where sightingId = ?";
        private static final String SQL_SELECT_SIGHTINGS_BY_ID
                = "select * from sightings where sightingId = ?";
        private static final String SQL_SELECT_ALL_SIGHTINGS
                = "select * from sightings";
        private static final String SQL_UPDATE_SIGHTING
                = "update sightings set " 
                + "heroId  = ?, locationId = ?, date = ?  "
                + "where sightingId = ?";
        private static final String SQL_SELECT_SIGHTINGS_BY_LOCATION
                = "select h.name, l.location, s.date from sightings"
                + "join heros h on s.heroId = h.heroId "
                + "+ join location l on s.locationId = l.locationId "
                + "where locationId = ?";
        private static final String SQL_SELECT_SIGHTING_BY_HERO
                = "select h.name, l.location, s.date from sightings "
                + "join heros h on s.heroId = h.heroId "
                + "join location l on s.locationId = l.locationId "
                + "where heroId = ?";
   //========================JDBC INSTANCE==========================================================
        
        private JdbcTemplate jdbcTemplate;
    
        public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
    }    
    //=============================================SIGHTING STATEMENTS=====================================================

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Sighting addSighting(Sighting sighting) {
       jdbcTemplate.update(SQL_INSERT_SIGHTING,
                sighting.getHeroId(),
                sighting.getLocationId(),
                sighting.getDate());
                   
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        
        sighting.setSightingId(newId);
        return sighting;
        }

    @Override
    public void removeSighting(int sightingId) {
         jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }

    @Override
    public void updateSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTING,
                sighting.getHeroId(),
                sighting.getLocationId(),
                sighting.getDate(),                               
                sighting.getSightingId());
                
    }

    @Override
    public List<Sighting> getAllSightings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS, 
                new SightingDaoImpl.SightingMapper());
    }

    @Override
    public Sighting getSightingById(int sightingId) {
         try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SIGHTINGS_BY_ID,
                   new SightingDaoImpl.SightingMapper(), sightingId);
        } catch (EmptyResultDataAccessException ex) {
                return null;
    }
    }

    @Override
    public List<Sighting> searchSighting(Map<SightingSearchTerm, String> criteria) {
     
        if (criteria.isEmpty()) {
            return getAllSightings();
        } else {
            
            StringBuilder sQuery = new StringBuilder("select * from sightings where ");
            
            int numParams = criteria.size();
            int paramPosition = 0;
            
            String[] paramVals = new String[numParams];
            Set<SightingSearchTerm> keySet = criteria.keySet();
            Iterator<SightingSearchTerm> iter = keySet.iterator();
            
            while(iter.hasNext()) {
                SightingSearchTerm currentKey = iter.next();
                
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                sQuery.append(currentKey);
                sQuery.append(" = ? ");
                
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            return jdbcTemplate.query(sQuery.toString(),
                    new SightingDaoImpl.SightingMapper(), paramVals);
        }
    }
    
    //=============================MAPPER STATEMENTS==================================================
 
    
    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
                
            Sighting sighting = new Sighting();
            sighting.setSightingId(rs.getInt("sightingId"));
            sighting.setHeroId(rs.getInt("heroId"));
            sighting.setLocationId(rs.getInt("locationId"));
            sighting.setDate(rs.getString("date"));
            
            
            return sighting;
            
        }
        
        
    }
}
