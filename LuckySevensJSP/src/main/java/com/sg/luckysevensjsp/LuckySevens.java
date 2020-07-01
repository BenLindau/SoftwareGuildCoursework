/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensjsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
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
@WebServlet(name = "LuckySevens", urlPatterns = {"/LuckySevens"})
public class LuckySevens extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
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
            
            request.setAttribute("numberOfRolls", i);
            request.setAttribute("maxRolledAt", maxRolledAt);
            request.setAttribute("max", max);
            
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
            
  }
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