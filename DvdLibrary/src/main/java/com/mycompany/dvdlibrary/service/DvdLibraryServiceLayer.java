/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.service;

import com.mycompany.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.mycompany.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author benli
 */
public interface DvdLibraryServiceLayer {
    
    void createDvd(DVD dvd) throws 
            DvdLibraryDuplicateIdException, DvdLibraryDataValidationException,
            DvdLibraryPersistenceException;
    
    List<DVD> getAllDvds() throws DvdLibraryPersistenceException;
    
    DVD getDvd(String title) throws DvdLibraryPersistenceException;
    
    DVD removeDvd(String title) throws DvdLibraryPersistenceException;
}
