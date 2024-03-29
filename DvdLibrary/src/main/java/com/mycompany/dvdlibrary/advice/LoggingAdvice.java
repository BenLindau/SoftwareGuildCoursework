/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.advice;

import com.mycompany.dvdlibrary.dao.DvdLibraryAuditDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author benli
 */
public class LoggingAdvice {
    
    DvdLibraryAuditDao auditDao;
    
    public LoggingAdvice(DvdLibraryAuditDao auditDao) {
        this.auditDao = auditDao;
    }
    
    public void createAuditEntry(JoinPoint jp)  {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
            } catch (DvdLibraryPersistenceException e) {
                System.err.println("ERROR: Could not create audit entry in loggingAdvice");
            }
        
    }
    
}
 