/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachineMVC.model;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.soda);
        hash = 59 * hash + Objects.hashCode(this.price);
        hash = 59 * hash + this.inventory;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inventory other = (Inventory) obj;
        if (this.inventory != other.inventory) {
            return false;
        }
        if (!Objects.equals(this.soda, other.soda)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }
    
    
    
}
