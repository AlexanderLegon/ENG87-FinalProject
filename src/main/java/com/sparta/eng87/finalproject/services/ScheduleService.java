package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
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

    public List<Object[]> getActiveCourseWeeks(List<String> weeks, List<String> courseNames) {
        String courseStartDate;
        List<Date> courseEndDate = courseService.getCourseEndDate();
        String currentEndDate;
        List<Object[]> activeDays = new ArrayList<>();
        List<Integer> currentCourseActive = new ArrayList<>();
        boolean active = false;

//        ZoneOffset offset = ZoneOffset.of("Z");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i<courseNames.size();i++) {

            courseStartDate = courseRepository.getCourseStartDatesByCourseName(courseNames.get(i));
            currentEndDate = dateFormat.format(courseEndDate.get(i));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate courseStartDateTime = LocalDate.parse(courseStartDate, formatter);
            LocalDate courseEndDateTime = LocalDate.parse(currentEndDate, formatter2);
            Integer courseId = courseRepository.findCourseIdByCourseName(courseNames.get(i));


//            courseStartDate = dateFormat.format(courseStartDate);

            while (!(courseStartDateTime.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
                courseStartDateTime=courseStartDateTime.minusDays(1);
            }
            while (!(courseEndDateTime.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
                courseEndDateTime=courseEndDateTime.minusDays(1);
            }



            currentEndDate = courseEndDateTime.toString();
            courseStartDate = courseStartDateTime.toString();
            int weekNum = 1;
            List<Object[]> trainerWeeks = courseRepository.getTrainerDatesByCourseId(courseId);
            if( trainerWeeks.size()>0) {
                System.out.println(trainerWeeks.get(0).toString());
            }
            for(String week:weeks) {
                LocalDate currentWeek = LocalDate.parse(week, formatter2);

                if ((currentWeek.isAfter(courseStartDateTime) && currentWeek.isBefore(courseEndDateTime))||currentWeek.isEqual(courseEndDateTime)||currentWeek.isEqual(courseStartDateTime)){
                    currentCourseActive.add(1);

                    weekNum++;
                }else{currentCourseActive.add(0);}
//                if (currentWeek.isEqual(courseStartDateTime)) {
//                    active = true;
//                    currentCourseActive.add(1);
//                } else if (active){
//                    currentCourseActive.add(1);
//                }
//                if(currentWeek.isEqual(courseEndDateTime) && LocalDate.parse(weeks.get(0), formatter2).isAfter(courseStartDateTime)){
//                    currentCourseActive.add(1);
//                    active = false;
//                } else if(!active){
//                    currentCourseActive.add(0);
//                }

            }

            activeDays.add(currentCourseActive.toArray());
            currentCourseActive.clear();
        }
        return activeDays;
    }
}