/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary;

import com.mycompany.dvdlibrary.controller.DvdLibraryController;
import com.mycompany.dvdlibrary.dao.DvdLibraryAuditDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryAuditFileImpl;
import com.mycompany.dvdlibrary.dao.DvdLibraryDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mycompany.dvdlibrary.service.DvdLibraryServiceLayer;
import com.mycompany.dvdlibrary.service.DvdLibraryServiceLayerImpl;
import com.mycompany.dvdlibrary.ui.DvdLibraryView;
import com.mycompany.dvdlibrary.ui.UserIO;
import com.mycompany.dvdlibrary.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benli
 */
public class App {
    
    public static void main(String[] args) {
     /*   UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryAuditDao myAuditDao = new DvdLibraryAuditFileImpl();
        DvdLibraryServiceLayer myService = new DvdLibraryServiceLayerImpl(myDao, myAuditDao);
        DvdLibraryController controller = new DvdLibraryController(myService, myView);
        controller.run();
    }*/
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdLibraryController controller = 
           ctx.getBean("controller", DvdLibraryController.class);
        controller.run();
    }
}
    


