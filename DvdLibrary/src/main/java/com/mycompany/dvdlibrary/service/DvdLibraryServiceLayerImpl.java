/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.service;

import com.mycompany.dvdlibrary.dao.DvdLibraryAuditDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.mycompany.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author benli
 */
public class DvdLibraryServiceLayerImpl implements DvdLibraryServiceLayer {

    DvdLibraryDao dao;
    private DvdLibraryAuditDao auditDao;
    
    
    private void validateDvdData(DVD dvd) throws DvdLibraryDataValidationException {
        if (dvd.getTitle() == null || 
            dvd.getTitle().trim().length() == 0 ||
            dvd.getReleaseDate() == null || 
                /*dvd.getReleaseDate().trim().length() == 0 ||*/
            dvd.getRating() == null || 
            dvd.getRating().trim().length() == 0 ||
            dvd.getDirector() == null || 
            dvd.getDirector().trim().length() == 0 ||
            dvd.getComments() == null || 
            dvd.getComments().trim().length() == 0) {
            throw new DvdLibraryDataValidationException("ERROR: All fields are required");
        }
            
    }
    
    public DvdLibraryServiceLayerImpl(DvdLibraryDao dao, DvdLibraryAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
        
    @Override
    public void createDvd(DVD dvd) throws DvdLibraryDuplicateIdException, DvdLibraryDataValidationException, DvdLibraryPersistenceException {
        if (dao.getDvd(dvd.getTitle()) != null) {
            throw new DvdLibraryDuplicateIdException("ERROR: Could not create dvd. Dvd " + dvd.getTitle() + " already exists");
        }
           validateDvdData(dvd);
           
           dao.addDvd(dvd.getTitle(), dvd);
           
           //auditDao.writeAuditEntry("Dvd " + dvd.getTitle() + " created!");
            
    }

    @Override
    public List<DVD> getAllDvds() throws DvdLibraryPersistenceException {
        return dao.getAllDVDs();
        }

    @Override
    public DVD getDvd(String title) throws DvdLibraryPersistenceException {
        return dao.getDvd(title);
    }

    @Override
    public DVD removeDvd(String title) throws DvdLibraryPersistenceException {
        DVD removedDvd = dao.removeDvd(title);
        
       //auditDao.writeAuditEntry("Dvd " + title + " Removed");
        
        return removedDvd;
    }
    
}
