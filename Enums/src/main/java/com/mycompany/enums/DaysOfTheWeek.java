/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enums;

import static com.mycompany.enums.DaysOfTheWeek.weekDays.FRIDAY;
import static com.mycompany.enums.DaysOfTheWeek.weekDays.MONDAY;
import static com.mycompany.enums.DaysOfTheWeek.weekDays.SATURDAY;
import static com.mycompany.enums.DaysOfTheWeek.weekDays.SUNDAY;
import static com.mycompany.enums.DaysOfTheWeek.weekDays.TEUSDAY;
import static com.mycompany.enums.DaysOfTheWeek.weekDays.THURSDAY;
import static com.mycompany.enums.DaysOfTheWeek.weekDays.WEDNESDAY;

/**
 *
 * @author benli
 */
public class DaysOfTheWeek {
    
    
    public int daysUntilFiday(int daysLeft, weekDays currentDay) {
        
        switch(currentDay) {
           
            case MONDAY:
                return 4;
            case TEUSDAY:
                return 3;
            case WEDNESDAY:
                return 2;
            case THURSDAY:
                return 1;
            case FRIDAY:
                return 0;
            case SATURDAY:
                return 6;
            case SUNDAY:
                return 5;
            default:
                throw new UnsupportedOperationException();
                
        }
        
    }
    public enum weekDays {
     MONDAY, TEUSDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
       
}
}


