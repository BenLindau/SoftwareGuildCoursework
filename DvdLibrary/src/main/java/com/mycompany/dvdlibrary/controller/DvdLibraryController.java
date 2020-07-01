/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.controller;

import com.mycompany.dvdlibrary.dao.DvdLibraryDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryPersistenceException;
import com.mycompany.dvdlibrary.dto.DVD;
import com.mycompany.dvdlibrary.service.DvdLibraryDataValidationException;
import com.mycompany.dvdlibrary.service.DvdLibraryDuplicateIdException;
import com.mycompany.dvdlibrary.service.DvdLibraryServiceLayer;
import com.mycompany.dvdlibrary.ui.DvdLibraryView;
import com.mycompany.dvdlibrary.ui.UserIO;
import com.mycompany.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author benli
 */
public class DvdLibraryController {
    
    DvdLibraryView view;
    private DvdLibraryServiceLayer service;
    private UserIO io = new UserIOConsoleImpl();
   
    public DvdLibraryController(DvdLibraryServiceLayer service, DvdLibraryView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {
            
        menuSelection = getMenuSelection();
            
        switch (menuSelection) {
            case 1:
                listDvds();
                break;
            case 2:
                createDvd();
                break;
            case 3:
                viewDvd();
            case 4:
                removeDvd();
                break;
            case 5:
                keepGoing = false;
                break;
            default:
                unknownCommand();
        }    
        }
        exitMessage();
        } catch (DvdLibraryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    private int getMenuSelection() {
        return view.printMenuSelection();
    }
    private void createDvd() throws DvdLibraryPersistenceException {
        view.displayCreateDvdBanner();
        boolean hasErrors = false;
        do {
            DVD currentDvd = view.getNewDvdInfo();
            try {
                service.createDvd(currentDvd);
                view.displayCreateDvdSuccessBanner();
                hasErrors = false;
            } catch (DvdLibraryDuplicateIdException | DvdLibraryDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            } 
        }while (hasErrors);
    }
    private void listDvds() throws DvdLibraryPersistenceException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = service.getAllDvds();
        view.displayDvdList(dvdList);
    }
    private void viewDvd() throws DvdLibraryPersistenceException {
        view.displayDisplayDvdBanner();
        String viewDvd = view.getDvdTitle();
        DVD title = service.getDvd(viewDvd);
        view.displayDvd(title);
    }
    private void removeDvd() throws DvdLibraryPersistenceException {
       view.displayRemoveDvdBanner();
       String removeDvd = view.getDvdTitle();
       service.removeDvd(removeDvd);
       view.displayRemoveSuccessBanner();
   }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    private void exitMessage() {
        view.displayExitBanner();
    }
     
}
