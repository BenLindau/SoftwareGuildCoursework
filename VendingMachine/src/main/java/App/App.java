/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controller.Controller;
import Dao.Dao;
import Dao.DaoFileImpl;
import Service.ServiceLayer;
import Service.ServiceLayerImpl;
import UserIO.UserIO;
import UserIO.UserIoImpl;
import UserIO.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benli
 */
public class App {
    
    public static void main(String[] args) {
    /*  UserIO myIO = new UserIoImpl();
        View myView = new View(myIO);
        Dao myDao = new DaoFileImpl();
        ServiceLayer myService = new ServiceLayerImpl(myDao) {};
        Controller controller = new Controller(myService, myView, myDao);
        controller.run();*/
    ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = 
           ctx.getBean("controller", Controller.class);
        controller.run();
    }
    
}
