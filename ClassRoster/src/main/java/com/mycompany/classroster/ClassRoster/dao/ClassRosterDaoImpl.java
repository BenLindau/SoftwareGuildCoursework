/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.ClassRoster.dao;

import com.mycompany.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author benli
 */
public class ClassRosterDaoImpl implements ClassRosterDao {

    private Map<String, Student> students = new HashMap<>();
    
    public static final String ROSTER_FILE = "roster.txt";
    
    public static final String DELIMITER = "::";
    
    private void loadRoster() throws ClassRosterDaoException {
        Scanner scanner;
        
        try { 
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterDaoException("-_- could not load roster data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            Student currentStudent = new Student(currentTokens[0]);
                    currentStudent.setFirstName(currentTokens[1]);
                    currentStudent.setLastName(currentTokens[2]);
                    currentStudent.setCohort(currentTokens[3]);
                    
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        scanner.close();
        }
    
    private void writeRoster() throws ClassRosterDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterDaoException("Could not save student data.");                   
        }
        List<Student> studentList = this.getAllStudents();
        
        for(Student currentStudent : studentList) {
            out.println(currentStudent.getStudentId() + DELIMITER + currentStudent.getFirstName() + currentStudent.getLastName() + DELIMITER + currentStudent.getCohort());
            out.flush();
        }
        out.close();
    }
    
    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterDaoException {
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterDaoException {
        loadRoster();
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterDaoException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterDaoException {
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }
    
}
