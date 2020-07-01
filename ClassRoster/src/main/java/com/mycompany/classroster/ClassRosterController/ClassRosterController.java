/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.ClassRosterController;

import com.mycompany.classroster.ClassRoster.dao.ClassRosterDao;
import com.mycompany.classroster.ClassRoster.dao.ClassRosterDaoException;
import com.mycompany.classroster.ClassRoster.dao.ClassRosterDaoImpl;
import com.mycompany.classroster.ClassRoster.ui.ClassRosterView;
import com.mycompany.classroster.ClassRoster.ui.UserIO;
import com.mycompany.classroster.ClassRoster.ui.UserIOConsoleImpl;
import com.mycompany.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author benli
 */
public class ClassRosterController {
    
    private UserIO io = new UserIOConsoleImpl();
    
    ClassRosterView view;
    ClassRosterDao dao;
    
    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {
           
          int meunSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    } catch (ClassRosterDaoException e) {
        view.displayErrorMessage(e.getMessage());
    }
    }

    
private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() throws ClassRosterDaoException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateStudentBanner();
        
    }
    private void listStudents() throws ClassRosterDaoException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    private void viewStudent() throws ClassRosterDaoException {
        view.displayDisplayStudentBanner();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
    private void removeStudent() throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        dao.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();   
    }
    private void exitMessage() {
        view.displayExitBanner();
    }
}
    

