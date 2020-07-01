/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.Order;
import UserIO.UserIO;
import UserIO.UserIOFileImpl;
import UserIO.View;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author benli
 */
public class DaoFileImpl implements Dao {

    View view;
    UserIO io = new UserIOFileImpl();
    
        
    private Map<String, Order> orderList = new HashMap<>();
    
    public static final String ROSTER_FILE = "roster.txt";
    
    public static final String DELIMITER = " :: "; 
           
    
    @Override
    public Order addOrder(String orderNum, Order order) throws PersistenceException {
        Order newOrder = orderList.put(orderNum, order);
        writeRoster();
        return newOrder;
       
    }

    @Override
    public List<Order> getOrders() throws PersistenceException {
        loadRoster();
        return new ArrayList<Order>(orderList.values());
    }

    @Override
    public Order editOrder(Order editedOrder) throws PersistenceException {
        writeRoster();
        return editedOrder;
    }

    @Override
    public Order getOrder(String orderNum) throws PersistenceException {
       loadRoster();
       return orderList.get(orderNum);
    }
    
    @Override
    public Order removeOrder(String orderNum) throws PersistenceException{
        Order removedOrder = orderList.remove(orderNum);
        writeRoster();
        return removedOrder;
    }
    
    @Override
    public void saveUpdates() throws PersistenceException {
        writeRoster();
    }

    private void loadRoster() throws PersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException("Could not load roster file", e);
        }
        
            String currentLine;
            String[] currentTokens;
            
            while (scanner.hasNextLine()) {
                
                currentLine = scanner.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                
                Order currentOrder = new Order();
                
                double taxRate = Double.parseDouble(currentTokens[3]);
                BigDecimal area = new BigDecimal(currentTokens[4]);
                
                currentOrder.setOrderNum(currentTokens[0]);
                currentOrder.setName(currentTokens[1]);
                currentOrder.setState(currentTokens[2]);
                currentOrder.setTaxRate(taxRate);
                currentOrder.setArea(area);
                currentOrder.setMaterial(currentTokens[5]);
                
                orderList.put(currentOrder.getOrderNum(), currentOrder);
            }
            scanner.close();   
        }
    private void writeRoster() throws PersistenceException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new PersistenceException("Could not save Student data.", e);
        }
        
        List<Order> orderList = this.getOrders();
        
        for (Order currentOrder : orderList) {
            out.println(currentOrder.getOrderNum() + DELIMITER +
                    currentOrder.getName() + DELIMITER + 
                    currentOrder.getState() + DELIMITER + 
                    currentOrder.getTaxRate() + DELIMITER + 
                    currentOrder.getArea() + DELIMITER + 
                    currentOrder.getMaterial());
            out.flush();
        }
        out.close();
        }

    
}
