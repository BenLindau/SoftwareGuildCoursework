/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 *
 * @author benli
 */
public class StudentQuiz implements StudentUI {
    
    public String name;
    public HashMap<String, ArrayList<Integer>> quizScores = new HashMap<>();
    public ArrayList<Integer> score;
    
   
    public void addStudent(String name) {
        quizScores.put(name, new ArrayList<>());
        
    }

    
    public void addQuizScores(String name, int newScore) {
               
        quizScores.put(name, new ArrayList<>());
        score = quizScores.get(name);
       
        score.add(newScore);
    }
    
    public void removeStudent(String name) {
        
        name = myScan.scan.nextLine();
        quizScores.remove(name);
        
    }
    
     @Override
    public void viewStudents() {
        Set<String> keys = quizScores.keySet();
        Iterator iters = keys.iterator();
               while(iters.hasNext()) {
                System.out.println(iters.next());
        }
    }
    
    @Override
    public void printScores() {
        System.out.println(quizScores);
        
    }

    @Override
    public void averageScore() {
        
        

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    @Override
    public void addStudent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addQuizScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeStudent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

                
        
    }
    
        

