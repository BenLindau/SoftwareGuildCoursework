/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.service;

import com.sg.supersspringmvc.dao.OrgSearchTerm;
import com.sg.supersspringmvc.dao.OrganizationDao;
import com.sg.supersspringmvc.model.Organization;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public class OrganizationServiceImpl implements OrganizationService {

    OrganizationDao dao;
    
    public OrganizationServiceImpl(OrganizationDao dao) {
        this.dao = dao;
    }
    
    public void validateOrganizationData(Organization org) throws DataValidationException {
      if(org.getName() == null || org.getName().trim().length() == 0 ||
         org.getLocationId() == 0 ||
         org.getPhone() == null || org.getPhone().trim().length() == 0 ||
         org.getEmail() == null || org.getEmail().trim().length() == 0) {
          throw new DataValidationException("Error: All Fields Required");
      }
            
    }
    
    @Override
    public Organization addOrganization(Organization org) throws DataValidationException {
        validateOrganizationData(org);
        
        Organization newOrg = dao.addOrganization(org);
        return newOrg;
    }

    @Override
    public void removeOrganization(int orgId) { 
        dao.removeOrganization(orgId);
    }

    @Override
    public void updateOrganization(Organization org) {
        dao.updateOrganization(org);
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return dao.getAllOrganizations();
    }

    @Override
    public Organization getOrganizationById(int orgId) {
        return dao.getOrganizationById(orgId);
    }

    @Override
    public List<Organization> searchOrganizations(Map<OrgSearchTerm, String> criteria) {
        List<Organization> orgList = dao.searchOrganizations(criteria);
        return orgList;
    }
    
}
