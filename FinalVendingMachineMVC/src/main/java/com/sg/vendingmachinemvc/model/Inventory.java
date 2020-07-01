/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemvc.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author benli
 */
public class Inventory {
    
    private int itemId;
    private String soda;
    private double price;
    private int inventory;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    
    public String getSoda() {
        return soda;
    }

    public void setSoda(String soda) {
        this.soda = soda;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
        public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.itemId;
        hash = 29 * hash + Objects.hashCode(this.soda);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 29 * hash + this.inventory;
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
        if (this.itemId != other.itemId) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.inventory != other.inventory) {
            return false;
        }
        if (!Objects.equals(this.soda, other.soda)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Soda: " + soda + "Price: " + price + "Inventory: " + inventory;
    }

    
    
}
