/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalcjspservlet;

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
@WebServlet(name = "FlooringCalc", urlPatterns = {"/FlooringCalc"})
public class FlooringCalc extends HttpServlet {

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
        double laborTime = (area /20.00) * 4;
        
        double laborCost = laborTime * 21.5;
        double totalCost = laborCost + areaCost;
        
        String stringAreaCost = Double.toString(areaCost);
        String stringLabor = Double.toString(laborCost);
        String stringTime = Double.toString(wholeTime);
        String stringCost = Double.toString(totalCost);
        
        
        request.setAttribute("widthOfArea", widthOfArea);
        request.setAttribute("costPerFoot", costPerFoot);
        request.setAttribute("stringLabor", stringLabor);
        request.setAttribute("stringTime", stringTime);
        request.setAttribute("stringCost", stringCost);
        request.setAttribute("stringAreaCost", stringAreaCost);
        
        
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
