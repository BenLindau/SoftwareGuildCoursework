/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author benli
 */
public class DaoPersistenceException extends Exception {
    
    public DaoPersistenceException(String message) {
        super(message);
    }
    public DaoPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
