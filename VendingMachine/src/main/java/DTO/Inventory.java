/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;

/**
 *
 * @author benli
 */
public class Inventory {
    
    private String soda;
    private BigDecimal price;
    private int inventory;

    public String getSoda() {
        return soda;
    }

    public void setSoda(String soda) {
        this.soda = soda;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    
    @Override
    public String toString() {
        return "Soda: " + soda + "Price: " + price + "Inventory: " + inventory;
    }
    
}
