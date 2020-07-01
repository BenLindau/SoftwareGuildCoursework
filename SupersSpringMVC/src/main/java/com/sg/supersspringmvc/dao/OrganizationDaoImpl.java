/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Organization;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author benli
 */
public class OrganizationDaoImpl implements OrganizationDao {
    
    //=================================Organization Statements==============================================
        
        private static final String SQL_INSERT_ORGANIZATION
                = "insert into organizations (name, locationId, phone, email) "
                + "values (?, ?, ?, ?) ";
        private static final String SQL_DELETE_ORGANIZATION
                = "delete from Organizations where orgId = ?";
        private static final String SQL_UPDATE_ORGANIZATION
                = "update organizations set name = ?, locationId = ?,"
                + "phone = ?, email = ? where orgId = ?";
        private static final String SQL_SELECT_ORGANIZATION_BY_ID
                = "select * from organizations where orgId = ?";
        private static final String SQL_SELECT_ALL_ORGANIZATIONS
                = "select * from organizations";
    
    //========================JDBC INSTANCE==========================================================
        
        private JdbcTemplate jdbcTemplate;
    
        public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
    }  
    //================================ORGANIZATION STATEMENTS===========================================
    
    @Override
    public Organization addOrganization(Organization org) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION, 
                org.getName(),
                org.getLocationId(),
                org.getPhone(),
                org.getEmail());
        
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        
        org.setOrgId(newId);
        return org;
    }

    @Override
    public void removeOrganization(int orgId) {
         jdbcTemplate.update(SQL_DELETE_ORGANIZATION, orgId);
    }

    @Override
    public void updateOrganization(Organization org) {
       
        int orgId = org.getOrgId();
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION, 
                org.getName(),
                org.getLocationId(),
                org.getPhone(),
                org.getEmail(),
                org.getOrgId());
        }

    @Override
    public List<Organization> getAllOrganizations() {
         return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS, 
                new OrganizationDaoImpl.OrgMapper());
    }

    @Override
    public Organization getOrganizationById(int orgId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION_BY_ID,
                   new OrganizationDaoImpl.OrgMapper(), orgId);
        } catch (EmptyResultDataAccessException ex) {
                return null;
    }
    }

    @Override
    public List<Organization> searchOrganizations(Map<OrgSearchTerm, String> criteria) {
        if (criteria.isEmpty()) {
            return getAllOrganizations();
        } else {
            
            StringBuilder sQuery = new StringBuilder("select * from organizations where ");
            
            int numParams = criteria.size();
            int paramPosition = 0;
            
            String[] paramVals = new String[numParams];
            Set<OrgSearchTerm> keySet = criteria.keySet();
            Iterator<OrgSearchTerm> iter = keySet.iterator();
            
            while(iter.hasNext()) {
                OrgSearchTerm currentKey = iter.next();
                
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                sQuery.append(currentKey);
                sQuery.append(" = ? ");
                
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            return jdbcTemplate.query(sQuery.toString(),
                    new OrganizationDaoImpl.OrgMapper(), paramVals);
        }
    }
    
       private static final class OrgMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            
            Organization org = new Organization();
            org.setOrgId(rs.getInt("orgId"));
            org.setName(rs.getString("name"));
            org.setLocationId(rs.getInt("locationId"));
            org.setPhone(rs.getString("phone"));
            org.setEmail(rs.getString("email"));
            
            return org;
        }
        
    }
        
}
