/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author benli
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao{
    
    
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, DVD> dvds = new HashMap<>();   
    
     @Override
    public DVD addDvd(String title, DVD dvd) 
            throws DvdLibraryPersistenceException {
        
        DVD newDvd = dvds.put(title, dvd);
        
        writeRoster();      
        
        return newDvd;
    }
    

    @Override
    public List<DVD> getAllDVDs() throws DvdLibraryPersistenceException {           
        loadRoster();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDvd(String title) throws DvdLibraryPersistenceException {
        loadRoster();
        return dvds.get(title);
    }

    @Override
    public DVD removeDvd(String title) throws DvdLibraryPersistenceException {
        DVD removeDvd = (DVD) dvds.remove(title);
        writeRoster();
        return removeDvd;
    }

    private void loadRoster() throws DvdLibraryPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryPersistenceException("Could not load roster data into memory", e);
        }
            String currentLine;
            String[] currentTokens;
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                
                DVD currentDvd = new DVD(currentTokens[0]);
                
                String stringReleaseDate = currentTokens[1];
                
                Long releaseDate = Long.parseLong(stringReleaseDate);
                
                currentDvd.setReleaseDate(releaseDate);
                currentDvd.setRating(currentTokens[2]);
                currentDvd.setDirector(currentTokens[3]);
                currentDvd.setStudio(currentTokens[4]);
                currentDvd.setComments(currentTokens[5]);
                
                dvds.put(currentDvd.getTitle(), currentDvd);
                
            }
            scanner.close();
            }
            private void writeRoster() throws DvdLibraryPersistenceException {
            
                PrintWriter out;
            
            try {
                out = new PrintWriter(new FileWriter(ROSTER_FILE));
            } catch (IOException e) {
                throw new DvdLibraryPersistenceException("Could not save Dvd Data");
            }
            List<DVD> dvdList = this.getAllDVDs();
            for (DVD currentDvd : dvdList) {
                out.println(currentDvd.getTitle() + DELIMITER + currentDvd.getReleaseDate() + DELIMITER + currentDvd.getRating() + DELIMITER + currentDvd.getDirector() + DELIMITER + currentDvd.getStudio() + DELIMITER + currentDvd.getComments());
                out.flush();
            }
            out.close();     
    }

    @Override
    public List<DVD> getDvdsByDate(Long ReleaseDate) {
        return dvds.values()
                .stream()
                .filter(DVD -> DVD.getReleaseDate().equals(ReleaseDate))
                .collect(Collectors.toList());
                
    }

    @Override
    public List<DVD> getDvdsWithRating(String Rating) {
       return dvds.values()
                .stream()
                .filter(DVD -> DVD.getRating().equalsIgnoreCase(Rating))
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> getMoviesDirectedBy(String Director) {
       return dvds.values()
                .stream()
                .filter(DVD -> DVD.getDirector().equalsIgnoreCase(Director))
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> getMoviesFromStudio(String Studio) {
        return dvds.values()
                .stream()
                .filter(DVD -> DVD.getStudio().equalsIgnoreCase(Studio))
                .collect(Collectors.toList());
    }

    

    @Override
    public DVD getNewestDvd() {
        /*return dvds.values()
                .stream()
                .max(Map.Entry.comparingByValue(Comparator.comparingLong(DVD::getReleaseDate)))
                .get;*/
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public List<DVD> getOldersDvd(Long dateForRelease) {
       return dvds.values()
                .stream()
                .filter(DVD -> DVD.getReleaseDate().equals(dateForRelease))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, String> getAverageNotes() {
        return dvds.values()
                .stream() 
                .collect(Collectors.toMap(map -> map.getTitle(), map -> map.getComments()));
    }    

    @Override
    public List<DVD> getAverageReleaseDate(Long ReleaseDate) {
        return dvds.values()
                .stream()
                .filter(DVD -> DVD.getReleaseDate().equals(ReleaseDate))
                .collect(Collectors.toList());
    }
}
