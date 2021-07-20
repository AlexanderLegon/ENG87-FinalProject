package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
public class ScheduleService {

    CourseRepository courseRepository;
    CourseService courseService;

    public ScheduleService(CourseRepository courseRepository,CourseService courseService) {
        this.courseRepository = courseRepository;
        this.courseService = courseService;
    }

    public List<String> listDates() {
        int prevWeeks = 12;
        int futureWeeks = 40;
        List<String> dates = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        while (!(new SimpleDateFormat("EE").format(date)).equals("Mon")) {
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
        for (int i = prevWeeks; i > 0; i--) {
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, (-7 * i));
            Date newDate = calendar.getTime();
            String temp = dateFormat.format(newDate);
            dates.add(temp);
            //   System.out.println(temp);
        }
        for (int j = 0; j < futureWeeks; j++) {
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, (7 * j));
            Date newDate = calendar.getTime();
            String temp = dateFormat.format(newDate);
            dates.add(temp);
        }


        return dates;

    }

    public List<String[]> getActiveCourseWeeks(List<String> weeks, List<String> courseNames) {
        String courseStartDate;
        List<java.util.Date> courseEndDate = courseService.getCourseEndDate();
        String currentEndDate;
        List<String[]> activeDays = new ArrayList<>();
        List<Integer> currentCourseActive = new ArrayList<>();
        boolean active = false;

//        ZoneOffset offset = ZoneOffset.of("Z");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i<courseNames.size();i++) {
            courseStartDate = courseRepository.getCourseStartDatesByCourseName(courseNames.get(i));
            currentEndDate = dateFormat.format(courseEndDate.get(i));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime courseStartDateTime = LocalDateTime.parse(courseStartDate, formatter);
            LocalDateTime courseEndDateTime = LocalDateTime.parse(currentEndDate, formatter);

            System.out.println(courseStartDateTime);
//            courseStartDate = dateFormat.format(courseStartDate);


            while (!(courseStartDateTime.getDayOfWeek().equals("MONDAY"))) {

                courseStartDateTime=courseStartDateTime.minusDays(1);


            }
            while (!(courseEndDateTime.getDayOfWeek().equals("MONDAY"))) {

                courseEndDateTime=courseEndDateTime.minusDays(1);


            }
//            while (!(new SimpleDateFormat("EE").format(currentEndDate)).equals("Mon")) {
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(Date.from(LocalDate.parse(currentEndDate).atStartOfDay().toInstant(offset)));
//                calendar.add(Calendar.DAY_OF_YEAR, (-1));
//                Date temp  = calendar.getTime();
//                currentEndDate = temp.toString();
//                //   System.out.println(new SimpleDateFormat("EE").format(date));
//            }

            currentEndDate = courseEndDateTime.toString();
            courseStartDate = courseStartDateTime.toString();
            for(String week:weeks){

                if (week.equals(courseStartDate)){
                    active = true;
                    currentCourseActive.add(1);
                } else if (active){
                    currentCourseActive.add(1);
                }
                if(week.equals(currentEndDate)){
                    currentCourseActive.add(1);
                    active = false;
                } else if(!active){
                    currentCourseActive.add(0);
                }

            }

            activeDays.add((String[]) currentCourseActive.toArray());

        }
        return activeDays;
    }
}