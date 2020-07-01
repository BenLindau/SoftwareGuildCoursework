/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster;

import com.mycompany.classroster.ClassRoster.dao.ClassRosterDao;
import com.mycompany.classroster.ClassRoster.dao.ClassRosterDaoImpl;
import com.mycompany.classroster.ClassRoster.ui.ClassRosterView;
import com.mycompany.classroster.ClassRoster.ui.UserIO;
import com.mycompany.classroster.ClassRoster.ui.UserIOConsoleImpl;
import com.mycompany.classroster.ClassRosterController.ClassRosterController;

/**
 *
 * @author benli
 */
public class App {
        
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoImpl();
        ClassRosterController controller = new ClassRosterController(myDao, myView);
        controller.run();
    }
    
}
