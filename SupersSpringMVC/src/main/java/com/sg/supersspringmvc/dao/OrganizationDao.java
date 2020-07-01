/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Organization;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public interface OrganizationDao {
    
    
    public Organization addOrganization(Organization org);
    
    public void removeOrganization(int orgId);
    
    public void updateOrganization(Organization org);
    
    public List<Organization> getAllOrganizations();
    
    public Organization getOrganizationById(int orgId);
    
    public List<Organization> searchOrganizations(Map<OrgSearchTerm, String> criteria); 

    
}
