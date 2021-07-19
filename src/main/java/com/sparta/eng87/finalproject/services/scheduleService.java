package com.sparta.eng87.finalproject.services;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class scheduleService {



public List<String> listDates ()
{
    int prevWeeks = 12;
    int futureWeeks = 40;
    List<String> dates = new ArrayList<>();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
   while(!(new SimpleDateFormat("EE").format(date)).equals("Mon")){
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(date);
       calendar.add(Calendar.DAY_OF_YEAR, (-1));
       date = calendar.getTime();
    //   System.out.println(new SimpleDateFormat("EE").format(date));
   }
 //   System.out.println(dateFormat.format(date));
 //   System.out.println(new SimpleDateFormat("EE").format(date));
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    // TODO make this nicer to look at
    for (int i = prevWeeks;i > 0;i--) {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, (-7*i));
        Date newDate = calendar.getTime();
        String temp = dateFormat.format(newDate);
        dates.add(temp);
     //   System.out.println(temp);
    }
    for ( int j = 0; j<futureWeeks;j++)
    {
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, (7*j));
        Date newDate = calendar.getTime();
        String temp = dateFormat.format(newDate);
        dates.add(temp);
    }


    return dates;

}


}