/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.Controller;

import com.sg.addressbook.dao.Dao;
import com.sg.addressbook.dao.DaoFileImpl;
import com.sg.addressbook.dto.Contacts;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOImpl;
import com.sg.addressbook.ui.View;
import java.util.List;

/**
 *
 * @author benli
 */
public class Controller {
    
    Dao dao;
    View view;
    
    public Controller(Dao dao, View view) {
        this.dao = dao;
        this.view = view;
    }
    
    
    private UserIO io = new UserIOImpl();
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
           
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    listContacts();
                    break;
                case 2:
                    createContact();
                    break;
                case 3:
                    viewContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                }
            }
        exitMessage();
        }
    private int getMenuSelection() {
        return view.printMenuSelection();
    }
    
    private void createContact() {
        view.displayCreateContactBanner();
        Contacts contact = view.getNewContactInfo();
        dao.addContact(contact);
        view.displayCreateSuccessBanner();
    }
    
    private void listContacts() {
        view.displayDisplayAllBanner();
        List<Contacts> contactList = dao.getAllContacts();
        view.displayContactList(contactList);
    }
    
    private void viewContact() {
        view.displayContactBanner();
        int contactId = view.getContactId();
        Contacts contact = dao.getContact(contactId);
        view.displayContactInfo(contact);
    }
    
    private void removeContact() {
        view.displayRemoveContactBanner();
        int contactId = view.getContactId();
        dao.removeContacts(contactId);
        view.displayRemoveSuccessBanner();       
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
}

    private void exitMessage() {
        view.displayExitBanner();
}
}

