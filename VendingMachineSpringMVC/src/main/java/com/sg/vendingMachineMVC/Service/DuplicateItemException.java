/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachineMVC.Service;

/**
 *
 * @author benli
 */
public class DuplicateItemException extends Exception{
    
    public DuplicateItemException(String message) {
        super(message);
    }
    
    public DuplicateItemException(String message, Throwable cause) {
        super(message, cause);
    }
}