/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensspringmvc2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author benli
 */
@Controller
public class LuckySevens {   
    
    @RequestMapping(value="LuckySevens", 
                    method=RequestMethod.POST)
    public String LuckySevens(HttpServletRequest request, Map<String, Object> model) {
        
         String inputCash = request.getParameter("inputCash");
            String betPerRoll = request.getParameter("betPerRoll");
            
            int total = Integer.parseInt(inputCash);
            int bet = Integer.parseInt(betPerRoll);
            
            Random dice1 = new Random();
            Random dice2 = new Random();
            
            int i = 1;
            int max = total;
            int maxRolledAt = 0;
         
            do {
        
        int roll1 = dice1.nextInt(6) + 1;
             
            int roll2 = dice2.nextInt(6) + 1;
            
            int result = roll1 + roll2; 
            
                       
            if (result == 7) {
                total = total + bet;
                
                    if (total > max) {
                        max = total;
                        maxRolledAt = i;
                        }
                    i++;
                } else {
                total = total - bet;
                
                    if (total > max) {
                        max = total;
                        maxRolledAt = i;
                        }
                    i++;
        }
    }while (total > 0);
            
            model.put("numberOfRolls", i);
            model.put("maxRolledAt", maxRolledAt);
            model.put("max", max);
        
        return "result";
    }
    
}