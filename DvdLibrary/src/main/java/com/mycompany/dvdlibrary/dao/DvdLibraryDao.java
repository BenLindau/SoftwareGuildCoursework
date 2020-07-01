/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public interface DvdLibraryDao {
    
    DVD addDvd(String title, DVD dvd)
        throws DvdLibraryPersistenceException;
    List<DVD> getAllDVDs()
        throws DvdLibraryPersistenceException;
    DVD getDvd(String Title)
        throws DvdLibraryPersistenceException;
    DVD removeDvd(String Title)
        throws DvdLibraryPersistenceException;
    
    public List<DVD> getDvdsByDate(Long ReleaseDate);
    
    public List<DVD> getDvdsWithRating(String Rating);
    
    public List<DVD> getMoviesDirectedBy(String Director);
    
    public List<DVD> getMoviesFromStudio(String Studio);
    
    public List<DVD> getAverageReleaseDate(Long ReleaseDate);
    
    public DVD getNewestDvd();
    
    public List<DVD> getOldersDvd(Long dateForRelease);
    
    public Map<String, String> getAverageNotes();
    
}
