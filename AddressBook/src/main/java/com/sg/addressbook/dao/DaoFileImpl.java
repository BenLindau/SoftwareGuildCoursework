/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Contacts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author benli
 */
public class DaoFileImpl implements Dao {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    private static final String SQL_INSERT_CONTACT
            ="insert into contacts " 
            +"(FirstName, LastName, Street, City, State, Zip, Phone, Email) "
            +"values (?, ?, ?, ?,  ?, ?, ?, ?)";
    private static final String SQL_DELETE_CONTACT
            = "delete from contacts where contactId = ?";
    private static final String SQL_SELECT_CONTACT
            = "select * from contacts where contactId = ?";
    private static final String SQL_UPDATE_CONTACT
            = "update contacts set " 
            + "firstName = ?, LastName = ?, Street = ?, City = ?, "
            + "State = ?, Zip = ?, Phone = ?, Email = ? " 
            + "where contactId = ?";
    private static final String SQL_SELECT_ALL_CONTACTS
            = "select * from contacts";
  
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Contacts addContact(Contacts contact) {
        jdbcTemplate.update(SQL_INSERT_CONTACT, 
                contact.getFirstName(),
                contact.getLastName(),
                contact.getStreet(),
                contact.getCity(),
                contact.getState(),
                contact.getZip(),
                contact.getPhone(),
                contact.getEmail());
        
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID();",
                Integer.class);
        contact.setContactId(newId);
        return contact;         
    }

    @Override
    public List<Contacts> getAllContacts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CONTACTS, 
                new ContactMapper());
    }

    @Override
    public Contacts getContact(int contactId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CONTACT,
                    new ContactMapper(), contactId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void removeContacts(int contactId) {
        jdbcTemplate.update(SQL_DELETE_CONTACT, contactId);
        
    }

    @Override
    public void updateContact(Contacts contact) {
       jdbcTemplate.update(SQL_UPDATE_CONTACT, 
                contact.getFirstName(),
                contact.getLastName(),
                contact.getStreet(),
                contact.getCity(),
                contact.getState(),
                contact.getZip(),
                contact.getPhone(),
                contact.getEmail(),
                contact.getContactId());
    
    }
    
    private static final class ContactMapper implements RowMapper<Contacts> {
    public Contacts mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contacts contact = new Contacts();
        contact.setContactId(rs.getInt("contactId"));
        contact.setFirstName(rs.getString("firstName"));
        contact.setLastName(rs.getString("lastName"));
        contact.setStreet(rs.getString("street"));
        contact.setState(rs.getString("state"));
        contact.setZip(rs.getString("zip"));
        contact.setPhone(rs.getString("phone"));
        contact.setEmail(rs.getString("email"));
        return contact;
    }
    }
}
