/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Contacts;
import java.util.List;

/**
 *
 * @author benli
 */
public interface Dao {
    
    
    public Contacts addContact(Contacts contact);
    
    public List<Contacts> getAllContacts();
    
    public Contacts getContact(int contactId);
    
    public void removeContacts(int contactId);
    
    public void updateContact(Contacts contact);
        
    
}
