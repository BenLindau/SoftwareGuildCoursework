/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalcjsp;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benli
 */
@WebServlet(name = "interestCalc", urlPatterns = {"/interestCalc"})
public class interestCalc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
        
        
        String startAmount = Double.toString(dubAmount);
        String stringAmount = Double.toString(finalAmount);
        String stringTime = Double.toString(dubTime);
        String stringInterest = Double.toString(finalInterest);
        
        request.setAttribute("startAmount", startAmount);
        request.setAttribute("stringAmount", stringAmount);
        request.setAttribute("stringTime", stringTime);
        request.setAttribute("stringInterest", stringInterest);
        RequestDispatcher rd =request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
