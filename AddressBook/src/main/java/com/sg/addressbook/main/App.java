/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.main;

import com.sg.addressbook.Controller.Controller;
import com.sg.addressbook.dao.Dao;
import com.sg.addressbook.dao.DaoFileImpl;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOImpl;
import com.sg.addressbook.ui.View;

/**
 *
 * @author benli
 */
public class App {
    
    public static void main(String[] args) {
        UserIO myIO = new UserIOImpl();
        View myView = new View(myIO);
        Dao myDao = new DaoFileImpl();
        Controller controller = new Controller(myDao, myView);
        controller.run();
    }
    
}
