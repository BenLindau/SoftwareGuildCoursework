/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquiz;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author benli
 */
public class Test {
    
    
    public static void main(String[] args) {
        
               
    
    HashMap<String, ArrayList<Integer>> quizScores = new HashMap<>();
        System.out.println("Please input student name.");
        String name = myScan.scan.nextLine();
        quizScores.put(name, new ArrayList<>());
        
       quizScores.put(name, new ArrayList<>());
        ArrayList<Integer> score = quizScores.get(name);
        
        int quizScore;
        
       
            System.out.println("Please enter a quiz score ot say done to stop");
            quizScore = myScan.scan.nextInt();
            score.add(quizScore);
        
        
        System.out.println(quizScores);
        

}
}