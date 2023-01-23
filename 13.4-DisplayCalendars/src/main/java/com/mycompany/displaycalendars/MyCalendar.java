/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.displaycalendars;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;//allows for console input

/**
 *
 * @author Garin McCullick
 */
public class MyCalendar {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("please enter year ex:1990");
        int yearInput = scn.nextInt();
        System.out.println("please enter month");
        int monthInput = scn.nextInt()-1;//-1 for the month january = 0 but is first month
        
        
        System.out.println(monthInput + 1 + "," + yearInput);
        
        //setting up gregorian calendar with input
        GregorianCalendar gregCal = new GregorianCalendar(yearInput,monthInput,1);//getting the month and year input from  and setting day of month to first day.
        int days = gregCal.getActualMaximum(Calendar.DATE);//getting max # of days in the month
        //System.out.println("DAY"+days)
        int week = gregCal.get(Calendar.DAY_OF_WEEK);//the day # in the week 3rd day of the week etc... this marks which day to start the month on the first week
        System.out.println("Day " + week + " in week");
        
        int totalWeeks = gregCal.getActualMaximum(Calendar.WEEK_OF_MONTH);//get actual maximum gets max amount of days in month but can also be used to get max weeks. on your calendar there are a max of 6 lines so if the month starts on the last day of the week and ends on the first day of the week there is enough room.
        System.out.println("# of weeks in month " + totalWeeks);//total weeks works off set month from month input which can be changed for testing
        
        //now need to loop through max days list them and create new line after every 7 or max week
        int dayCount = 1;//counting the days 1 by 1 in for loop
        
        for (int i = 1; i <= totalWeeks; i++){//display total # of weeks in the month min4- max6
            
            System.out.println();//next line
            for(int x = 1; x <= 7; x++){//each week inside total weeks
                String date = Integer.toString(dayCount-week+1);
               
            if((dayCount - week + 1)>days){
                
                System.out.print(" ");
            }else{
                //taking integers and converting to string for formatting
                if(date.length()==1){//if date only has 1 number in it place a zero before otherwise leave as is
                    System.out.print(" 0"+date);
                }
                else{
                System.out.print(" " + date);
                }
            
            }
            dayCount++;//increases the day count from the for loop each time
           }
        }
        System.out.println();//new line
        System.out.println(monthInput + 1 + " " + yearInput + " contains " + days + " days!");
    }}

