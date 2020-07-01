/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalcspringjsp;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author benli
 */

@Controller
public class FlooringCalcController {

    @RequestMapping(value = "flooringCalc",
            method = RequestMethod.POST)
    
    public String flooringDetails(HttpServletRequest request, Map<String, Object> model) {
    
    String lengthOfArea = request.getParameter("lengthOfArea");
        String widthOfArea = request.getParameter("widthOfArea");
        String costPerFoot = request.getParameter("cost");
        
        int length = Integer.parseInt(lengthOfArea);
        int width = Integer.parseInt(widthOfArea);
        int cost = Integer.parseInt(costPerFoot);
        
        int area = length * width;
        int areaCost = cost * area;
        
        double doubleArea = (double)(area);
        double wholeTime = (area/20);
        double laborTime = wholeTime * 4;
        
        double laborCost = laborTime * 21.5;
        double totalCost = laborCost + areaCost;
        
        model.put("areaCost", areaCost);
        model.put("laborCost", laborCost);
        model.put("wholeTime", wholeTime);
        model.put("totalCost", totalCost);
        
        
        return "result";
        
        
        
        }

}
