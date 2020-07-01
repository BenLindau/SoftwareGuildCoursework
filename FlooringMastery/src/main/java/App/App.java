/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controller.Controller;
import Service.DataValidationException;
import Service.DuplicateIdException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benli
 */
public class App {
    
    public static void main(String[] args) throws DuplicateIdException, DataValidationException {
      /*  UserIO myIo = new UserIOFileImpl();
        View myView = new View(myIo);
        Dao myDao = new DaoFileImpl();
        AuditDao myAuditDao = new AuditDaoFileImpl();
        Service myService = new ServiceLayerImpl(myDao, myAuditDao);
        Controller controller = new Controller(myService, myView);
        controller.run(); */
      
      ApplicationContext ctx = 
              new ClassPathXmlApplicationContext("applicationContext.xml");
      Controller controller = ctx.getBean("controller", Controller.class);
        controller.run();
    }
    
}
