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


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate yearStart = LocalDate.of(2021,5,1);
        LocalDate yearEnd = LocalDate.of(2022,4,30);
        LocalDate now = LocalDate.now();

        List<String> dates = new ArrayList<>();

        while (!(yearStart.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
            yearStart=yearStart.minusDays(1);
        }

        while (!(yearEnd.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
            yearEnd=yearEnd.minusDays(1);
        }

        while(now.isAfter(yearEnd)){
            yearEnd=yearEnd.plusYears(1);
        }


        //   System.out.println(dateFormat.format(date));
        //   System.out.println(new SimpleDateFormat("EE").format(date));
       dates.add(formatter.format(yearStart).toString());
        for (int i = 0; i < 52; i++) {

            yearStart=yearStart.plusDays(7);
            dates.add(formatter.format(yearStart).toString());
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


//            courseStartDate = dateFormat.format(courseStartDate);


            while (!(courseStartDateTime.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
                courseStartDateTime=courseStartDateTime.minusDays(1);
            }
            while (!(courseEndDateTime.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
                courseEndDateTime=courseEndDateTime.minusDays(1);
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Date d1 = simpleDateFormat.parse(courseStartDate);
                Date d2 = simpleDateFormat.parse(courseEndDate.toString());
                Date d3 = simpleDateFormat.parse("2021/12/20");
                Calendar c = Calendar.getInstance();
                System.out.println(d2);

                if(d1.compareTo(d3) < 0 && (d2.compareTo(d3) > 0)){
                    c.setTime(d2);
                    c.add(Calendar.DATE, 14);
                    d2 = simpleDateFormat.parse(String.valueOf(c.getTime()));
                    System.out.println(d2);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

            currentEndDate = courseEndDateTime.toString();
            courseStartDate = courseStartDateTime.toString();
            for(String week:weeks) {
                LocalDate currentWeek = LocalDate.parse(week, formatter2);

                if ((currentWeek.isAfter(courseStartDateTime) && currentWeek.isBefore(courseEndDateTime))||currentWeek.isEqual(courseEndDateTime)||currentWeek.isEqual(courseStartDateTime)){
                    currentCourseActive.add(1);
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