/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public class DvdLibraryDaoStubImpl implements DvdLibraryDao {

    DVD onlyDvd;
    List<DVD> dvdList = new ArrayList<>();
    
    public DvdLibraryDaoStubImpl() {
        onlyDvd = new DVD("movie1");
        
        onlyDvd.setRating("98");
        onlyDvd.setDirector("mike");
        onlyDvd.setComments("ok");
        onlyDvd.setStudio("Pixar");
        
        dvdList.add(onlyDvd);
    }
    
    @Override
    public DVD addDvd(String title, DVD dvd) throws DvdLibraryPersistenceException {
        if(title.equals(onlyDvd.getTitle())) {
            return onlyDvd;
        }else {
            return null;
        }
    }

    @Override
    public List<DVD> getAllDVDs() throws DvdLibraryPersistenceException {
        return dvdList;
    }

    @Override
    public DVD getDvd(String title) throws DvdLibraryPersistenceException {
      if(title.equals(onlyDvd.getTitle())) {
            return onlyDvd;
        }else {
            return null;
        }
    }

    @Override
    public DVD removeDvd(String title) throws DvdLibraryPersistenceException {
      if(title.equals(onlyDvd.getTitle())) {
            return onlyDvd;
        }else {
            return null;
        }
    }

    @Override
    public List<DVD> getDvdsByDate(Long ReleaseDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getDvdsWithRating(String Rating) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getMoviesDirectedBy(String Director) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getMoviesFromStudio(String Studio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getAverageReleaseDate(Long ReleaseDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD getNewestDvd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> getAverageNotes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getOldersDvd(Long dateForRelease) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
