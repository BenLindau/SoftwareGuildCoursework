/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Advice;

import Dao.AuditDao;
import Dao.Dao;
import Dao.PersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author benli
 */
public class LoggingAdvice {
    AuditDao auditDao;
    
    public LoggingAdvice(AuditDao auditDao) {
         this.auditDao = auditDao;
    }
    
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
    
    for (Object currentArg : args) {
        auditEntry += currentArg;
    }
    try {
        auditDao.writeAuditEntry(auditEntry);
    } catch (PersistenceException e) {
        System.err.println("Error: Could not create Audit Entry in logging advice");
    }
    }
}
