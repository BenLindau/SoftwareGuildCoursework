/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalcmvc;

import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author benli
 */
@Controller
public class InterestCalcController {

    @RequestMapping(value = "interestCalc",
            method = RequestMethod.POST)
    public String calculateInterest(HttpServletRequest request, 
            Map<String, Object> model) {
    String amount = request.getParameter("amount");
        String interest = request.getParameter("interest");
        String time = request.getParameter("time");
        
        double dubAmount = Double.parseDouble(amount);
        double dubInterest = Double.parseDouble(interest);
        double dubTime = Double.parseDouble(time);
        
        double quarters = dubTime * 4;
        
        double newInterest = Math.pow((1+ (dubInterest/100)), quarters);
        
        double finalInterest = newInterest;
        
        double finalAmount = finalInterest + dubAmount;
        
        model.put("Amount", dubAmount);
        model.put("Time", dubTime);
        model.put("finalInterest", finalInterest);
        model.put("finalAmount", finalAmount);
        
        return "result";
        
    }
   
}
    

