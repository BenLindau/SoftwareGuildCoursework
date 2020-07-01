/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.ui;

import com.mycompany.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author benli
 */
public class DvdLibraryView {
    
    private UserIO io;
    
    public DvdLibraryView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuSelection() {
        io.print("Main Menu");
        io.print("1. List Dvds");
        io.print("2. Create Dvd");
        io.print("3. View a Dvd");
        io.print("4. Remove a Dvd");
        io.print("Exit");
        
        return io.readInt("Please select from the above options", 1, 5);
    }
    
    public DVD getNewDvdInfo() {
        String title = io.readString("Please enter the Title");
        Long releaseDate = io.readLong("Please enter the release date");
        String rating = io.readString("Please enter the rating");
        String director = io.readString("Please enter the Director");
        String comments = io.readString("Please enter any comments");
    
        DVD currentDvd = new DVD(title);
        
        
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setRating(rating);
        currentDvd.setDirector(director);
        currentDvd.setComments(comments);
        return currentDvd;
    }
    
    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }
    public void displayCreateDvdSuccessBanner() {
        io.readString("Dvd create successful. Please hit enter to continue");
    }
    public void displayDvdList(List<DVD> dvdList) {
        for (DVD currentDvd : dvdList) {
            io.print(currentDvd.getTitle() + currentDvd.getReleaseDate() + currentDvd.getRating() + currentDvd.getDirector() + currentDvd.getStudio() + currentDvd.getComments());
        }
        io.readString("Please Hit enter to continue");
    }
    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===");
    }
    public void displayDisplayDvdBanner() {
        io.print("=== Display Student ===");
    }
    public String getDvdTitle() {
        return io.readString("Please enter the Dvd Title");
    }
   public void displayDvd(DVD Title) {
    if (Title != null) {
        String title = getDvdTitle();
        
        io.print(title);
        
    } else {
        io.print("No such Dvd");
    }
    io.readString("Please hit enter to continue");
    }

   public void displayRemoveDvdBanner() {
       io.print("=== Remove Dvd ===");
   }
   public void displayRemoveSuccessBanner() {
       io.print("=== Dvd Successfully Removed ===");
    }
   public void displayExitBanner() {
       io.print("Goodbye"); 
   }
   public void displayUnknownCommandBanner() {
       io.print("Unknown Command!");
   }
   public void displayErrorMessage(String errorMsg) {
       io.print("=== Error ===");
       io.print(errorMsg);
   }
   
}