/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.dao;

import com.sg.dvdlibrarymvc.model.Dvd;
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
public class DvdDaoDbImpl implements DvdDao {

    //======================SQL Statements==========================
    
    private static final String SQL_INSERT_DVD
            = "insert into dvds" 
            + "(title, releaseDate, director, studio, rating, comments)"
            + "values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_DVD
            = "delete from dvds where dvdId = ?";
    private static final String SQL_SELECT_DVD
            = "select * from dvds where dvdId = ?";
    private static final String SQL_UPDATE_DVD 
            = "update dvds "
            + "set title=?, releaseDate=?, director=?, studio=?, rating=?, comments=? "
            + "where dvdId=?";
    private static final String SQL_SELECT_ALL_DVDS
            = "select * from dvds ";
  
    
    
    //=========================================
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd addDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getRating(),
                dvd.getComments());
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                    Integer.class);
        dvd.setDvdId(newId);
        return dvd;        
    }

    @Override
    public void removeDvd(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }

    @Override
    public void updateDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getRating(),
                dvd.getComments(),
                dvd.getDvdId());
    }

    @Override
    public List<Dvd> getAllDvds() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS,
                new DvdMapper());
    }

    @Override
    public Dvd getDvdById(int dvdId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD, 
                    new DvdMapper(), dvdId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Dvd> searchDvd(Map<SearchTerm, String> criteria) {
        if (criteria.isEmpty()) {
            return getAllDvds();
        } else {
            StringBuilder sQuery =
                    new StringBuilder("select * from dvds where ");
            int numParams = criteria.size();
            int paramPosition = 0;
            
            String[] paramVals = new String[numParams];
            Set<SearchTerm> keySet = criteria.keySet();
        Iterator<SearchTerm> iter = keySet.iterator();
        
        while (iter.hasNext()) {
            SearchTerm currentKey = iter.next();
            
            if (paramPosition > 0) {
                sQuery.append(" and ");
            }
                sQuery.append(currentKey);
                sQuery.append(" = ? ");  
            
            paramVals[paramPosition] = criteria.get(currentKey);
            
            paramPosition++;
        }
        return jdbcTemplate.query(sQuery.toString(),
                new DvdMapper(), paramVals);
        }
    }
    
    private static final class DvdMapper implements RowMapper<Dvd> {

        @Override
        public Dvd mapRow(ResultSet rs, int i) throws SQLException {
            Dvd dvd = new Dvd();
            dvd.setDvdId(rs.getInt("dvdId"));
            dvd.setTitle(rs.getString("title"));
            dvd.setReleaseDate(rs.getString("releaseDate"));
            dvd.setDirector(rs.getString("director"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setRating(rs.getString("rating"));
            dvd.setComments(rs.getString("comments"));
            return dvd;
        }
        
    }    
    
}
