/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserIO;

import DTO.Order;
import Dao.PersistenceException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public class View {
    
    UserIO io;
    
    public View(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
            io.print("1. Display All");
            io.print("2. Add Order");
            io.print("3. Edit Order");
            io.print("4. View Order");
            io.print("5. Remove Order");
            io.print("6. Save Updates");
            io.print("7. Exit");
            
            return io.readInt("Please select from the above options", 1, 6);
    }
    
    public Order getNewOrderInfo() {
        String orderNum = io.readString("Please enter order number.");
        String name = io.readString("Please enter client name.");
        String state = io.readString("Please enter state.");
        double taxRate = io.readDouble("Please enter tax rate.");
        double area = io.readDouble("please enter the area.");
        String material = io.readString("Please entery material type.");
        
        BigDecimal newArea = new BigDecimal(area).setScale(3, RoundingMode.HALF_UP);
        
        Order currentOrder = new Order();
        
        currentOrder.setOrderNum(orderNum);
        currentOrder.setName(name);
        currentOrder.setState(state);
        currentOrder.setTaxRate(taxRate);
        currentOrder.setArea(newArea);
        currentOrder.setMaterial(material);
        
        
        return currentOrder;
    }
    
    public void displayCreateOrderBanner() {
        io.print("=== Create Order ===");
    }
    
    public void displayCreateOrderSuccessBanner() {
        io.print("=== Order Successfully Created ===");
    }
    
    public void displayAllOrders(List<Order> orderList) {
        for (Order currentOrder : orderList) {
            io.print(currentOrder.getOrderNum() + (" : ") + currentOrder.getName() + (" : ") +
                    currentOrder.getState() + (" : ") + currentOrder.getTaxRate() + (" : ") +
                    currentOrder.getArea() + (" : ") + currentOrder.getMaterial());
        }
            
        
        io.readString("Please hit enter to continue.");
    }
    
    public void displayAllOrdersBanner() {
        io.print("=== Display All Orders ===");
    }
    
    public Order editOrder(Order editOrder) {
                      
            io.print("1. Name");
            io.print("2. State");
            io.print("3. Tax Rate");
            io.print("4. Area");
            io.print("5. Material");
            
                            
        switch (io.readInt("Please select from the above options")) {
                case 1:
                    String name = io.readString("Please enter updated name.");
                    editOrder.setName(name);
                    break;
                case 2:
                    String state = io.readString("Please enter updated state.");
                    editOrder.setState(state);
                    break;
                case 3:
                    Double taxRate = io.readDouble("Please enter updated tax rate.");
                    editOrder.setTaxRate(taxRate);
                    break;
                case 4:
                    Double area = io.readDouble("Please enter updated area.");
                    BigDecimal newArea = new BigDecimal(area);
                    editOrder.setArea(newArea);;
                    break;
                case 5:
                    String material = io.readString("Please enter updated material.");
                    editOrder.setMaterial(material);;
                    break;
                }
        return editOrder;
    }
    
    public void displayEditOrderBanner() {
        io.print("=== Edit Order ===");
    }
    
    public void displayOrderEditedBanner() {
        io.print("=== Order Edited ===");
    }
    
    public void displayOrder(Order order) {
        
        if (order != null) {
            io.print(order.getOrderNum() + " : " + order.getName() + " " + order.getState() + " " 
            + order.getTaxRate() + " " + order.getArea() + " " + order.getMaterial());
        } else {
            io.print("Order does not exist");
        }
        
                      
            
            if (order.getMaterial().equalsIgnoreCase("wood")) {
            
                double newArea = order.getArea().doubleValue();
            
                double cost = 3.0 * newArea;
                System.out.println("Cost per square foor w/ tile: $3");
                System.out.println("Total material cost: " + cost);
                          
                double labor = 5.0 * newArea;
                
                System.out.println("Labor per square foor w/ tile: $5");
                System.out.println("Total Labor cost: " + labor);
                
                                
                double taxCost = (labor + cost) * order.getTaxRate();
                
                System.out.println("Tax: " + taxCost);
                
                double totalCost = labor + cost + taxCost;
                
                System.out.println("Total cost: " + totalCost);
            
            } else if (order.getMaterial().equalsIgnoreCase("tile")) {
            
                double newArea = order.getArea().doubleValue();
            
                double cost = 2.0 * newArea;
                System.out.println("Cost per square foor w/ tile: $2");
                System.out.println("Total material cost: " + cost);
                
                double labor = 4.0 * newArea;
            
                System.out.println("Labor per square foor w/ tile: $4");
                System.out.println("Total Labor cost: " + labor);
               
                
                double taxCost = (labor + cost) * order.getTaxRate();
                
                System.out.println("Tax: " + taxCost);
                
                double totalCost = labor + cost + taxCost;
                
                System.out.println("Total cost: " + totalCost);
                
            } else {
                System.out.println("A valid material is not listed");
            }
            
            
                                
        io.readString("Please hit enter to continue.");
        
    }
    
    public void displayViewOrderbanner() {
        io.print("=== Display Order ===");
    }
    
    public String getOrderNum() {
        return  io.readString("Please enter the order number");
    }
    
    public void displayRemoveOrderBanner() {
        io.print("=== Remove Order ===");
    }
    
    public void displayRemoveSuccessBanner() {
        io.readString("Order Removed. Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Goodbye!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }
    
    public void displaySaveUpdates() {
        io.print("UPDATES SAVED");
    }
}
