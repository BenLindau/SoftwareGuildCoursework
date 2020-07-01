/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tipcalculatormvc;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author benli
 */
@Controller
public class TipCalculatorController {

    @RequestMapping(value = "tipCalc",
            method = RequestMethod.POST)
    public String calculateTip(HttpServletRequest request, 
            Map<String, Object> model) {
        
        String bill = request.getParameter("bill");
        String bigTip = request.getParameter("tip");
        
        double dubBill = Double.parseDouble(bill);
        double dubTip = Double.parseDouble(bigTip);
        
        double tipPercent = dubTip / 100;
        
        double tipAmount = dubBill * tipPercent;
        
        double fullAmount = dubBill + tipAmount;
        
        model.put("bill", dubBill);
        model.put("bigTip", bigTip);
        model.put("tipAmount", tipAmount);
        model.put("fullAmount", fullAmount);
        
        return "result";
        
    }

}
