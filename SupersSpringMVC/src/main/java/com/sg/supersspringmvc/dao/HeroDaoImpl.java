/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Hero;
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
public class HeroDaoImpl implements HeroDao {
    
    // ===============================SQL HERO STATEMENTS===========================
    private static final String SQL_INSERT_HERO
            = "insert into Heros "
            + "(Name, Description, Powers, LocationId, OrganizationId) "
            + " values (?, ?, ?, ?, ?) ";
    private static final String SQL_DELETE_HERO
            = "delete from Heros where heroId = ?";
    private static final String SQL_SELECT_HERO
            = "select * from heros where heroId = ?";
    private static final String SQL_UPDATE_HERO
            = "update heros set "
            + "name = ?, Description = ?, Powers = ?, LocationId = ?, OrganizationId = ? "
            + "where heroId = ?";
    private static final String SQL_SELECT_ALL_HEROS
            = "select * from heros";
    private static final String SQL_SELECT_HERO_BY_HEROID
            = "select * from heros "
            + "where heroId = ?";
    
     //========================JDBC INSTANCE==========================================================
        
        private JdbcTemplate jdbcTemplate;
    
        public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
    }  
        
    //==============================HERO STATEMENTS==================================================================
    
     @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Hero addHero(Hero hero) {
        jdbcTemplate.update(SQL_INSERT_HERO,
                hero.getName(),
                hero.getDescription(),
                hero.getPowers(),
                hero.getLocationId(),
                hero.getOrganizationId());
                
            int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
            
            hero.setHeroId(newId);
            return hero;
    }
    
    

    @Override
    public void removeHero(int heroId) {
         jdbcTemplate.update(SQL_DELETE_HERO, heroId);
    }

    @Override
    public void updateHero(Hero hero) {
        jdbcTemplate.update(SQL_UPDATE_HERO,
                hero.getName(),
                hero.getDescription(),
                hero.getPowers(),
                hero.getLocationId(),
                hero.getOrganizationId(),
                hero.getHeroId());
                
    }

    @Override
    public List<Hero> getAllHeros() {
         return jdbcTemplate.query(SQL_SELECT_ALL_HEROS,
                new HeroDaoImpl.HeroMapper());
    }

    @Override
    public Hero getHeroById(int heroId) {
         try {
            return jdbcTemplate.queryForObject(SQL_SELECT_HERO_BY_HEROID,
                   new HeroDaoImpl.HeroMapper(), heroId);
        } catch (EmptyResultDataAccessException ex) {
                return null;
    }
    }

    @Override
    public List<Hero> searchHeros(Map<HeroSearchTerm, String> criteria) {
        
        if (criteria.isEmpty()) {
            return getAllHeros();
        } else {
            
            StringBuilder sQuery = new StringBuilder("select * from heros where ");
            
            int numParams = criteria.size();
            int paramPosition = 0;
            
            String[] paramVals = new String[numParams];
            Set<HeroSearchTerm> keySet = criteria.keySet();
            Iterator<HeroSearchTerm> iter = keySet.iterator();
            
            while(iter.hasNext()) {
                HeroSearchTerm currentKey = iter.next();
                
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                sQuery.append(currentKey);
                sQuery.append(" = ? ");
                
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            return jdbcTemplate.query(sQuery.toString(),
                    new HeroDaoImpl.HeroMapper(), paramVals);
        }
    
    }
    
//=============================MAPPER STATEMENTS==================================================
    
    
    private static final class HeroMapper implements RowMapper<Hero> {

        @Override
        public Hero mapRow(ResultSet rs, int i) throws SQLException {
           
            Hero hero = new Hero();
            hero.setHeroId(rs.getInt("heroId"));
            hero.setName(rs.getString("Name"));
            hero.setDescription(rs.getString("description"));
            hero.setPowers(rs.getString("powers"));
            hero.setLocationId(rs.getInt("locationId"));
            hero.setOrganizationId(rs.getInt("organizationId"));
            return hero;
        
        }
        
    }
}

