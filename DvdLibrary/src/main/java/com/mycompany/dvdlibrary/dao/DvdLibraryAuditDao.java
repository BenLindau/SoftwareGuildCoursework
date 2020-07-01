/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

/**
 *
 * @author benli
 */
public interface DvdLibraryAuditDao {
    
    public void writeAuditEntry(String entry) throws DvdLibraryPersistenceException;
    
}
