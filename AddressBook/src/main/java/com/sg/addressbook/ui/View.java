/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.Contacts;
import java.util.List;

/**
 *
 * @author benli
 */
public class View {
    
    private UserIO io;
    
    public View(UserIO io) {
        this.io = io;
    }
    
    public int printMenuSelection() {    
        io.print("Main Menu");
        io.print("1. Show Contacts");
        io.print("2. Add Contact");
        io.print("3. Search Contact");
        io.print("4. Delete Contact");
        io.print("5. Exit");
        
        return io.readInt("Please select from the above choices", 1, 5);
    }
    
    public Contacts getNewContactInfo() {
        int contactId = io.readInt("Please enter contactId");
        String firstName = io.readString("Please enter first name");
        String lastName = io.readString("Please enter last name");
        String street = io.readString("Please enter street address");
        String city = io.readString("Please enter city");
        String state = io.readString("Please enter state");
        String zip = io.readString("Please enter zip");
        String phone = io.readString("Please enter phone number");
        String email = io.readString("Please enter email");
        
        Contacts currentContact = new Contacts();
        
        currentContact.setContactId(contactId);
        currentContact.setFirstName(firstName);
        currentContact.setLastName(lastName);
        currentContact.setStreet(street);
        currentContact.setCity(city);
        currentContact.setState(state);
        currentContact.setZip(zip);
        currentContact.setPhone(phone);
        currentContact.setEmail(email);
        return currentContact;
               
    }
    
    public void displayCreateContactBanner() {
        io.print("=== Create Contact ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("=== Contact Created ====");
    }
    
    public void displayContactList(List<Contacts> contactList) {
        for (Contacts currentContact : contactList) {
            io.print(currentContact.getContactId() + " : " 
            + currentContact.getFirstName() + " : "
            + currentContact.getLastName() + " : "
            + currentContact.getPhone() + " : "
            + currentContact.getEmail() + " : ");
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All Contacts ===");
    }
    
    public void displayContactBanner() {
        io.print("=== Display Contact ===");
    }
    
    public int getContactId() {
        return io.readInt("Please enter contactId");
    }
    
    public void displayContactInfo(Contacts contact) {
        if (contact != null) {
            io.print(contact.getFirstName());
            io.print(contact.getLastName());
            io.print(contact.getStreet());
            io.print(contact.getCity());
            io.print(contact.getState());
            io.print(contact.getZip());
            io.print(contact.getPhone());
            io.print(contact.getEmail());
        } else {
            io.print("No Contact");
        }
        io.readString("Please hit enter to continue");
    } 
    
    public void displayRemoveContactBanner() {
        io.print("=== Remove Contact ===");               
    }
    
    public void displayRemoveSuccessBanner() {
        io.print("=== Contact Removed ===");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
}
