package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
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
//        LocalDateTime now = LocalDateTime.now();
//        ZoneId zone = ZoneId.of("GMT");
        ZoneOffset offset = ZoneOffset.of("+0:00");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i<courseNames.size();i++) {
            courseStartDate = courseRepository.getCourseStartDatesByCourseName(courseNames.get(i));



            courseStartDate = dateFormat.format(courseStartDate);
            currentEndDate = dateFormat.format(courseEndDate.get(i));
            while (!(new SimpleDateFormat("EE").format(courseStartDate)).equals("Mon")) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(Date.from(LocalDate.parse(courseStartDate).atStartOfDay().toInstant(offset)));
                calendar.add(Calendar.DAY_OF_YEAR, (-1));
                Date temp  = calendar.getTime();
                courseStartDate = temp.toString();
                //   System.out.println(new SimpleDateFormat("EE").format(date));
            }

            while (!(new SimpleDateFormat("EE").format(currentEndDate)).equals("Mon")) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(Date.from(LocalDate.parse(currentEndDate).atStartOfDay().toInstant(offset)));
                calendar.add(Calendar.DAY_OF_YEAR, (-1));
                Date temp  = calendar.getTime();
                currentEndDate = temp.toString();
                //   System.out.println(new SimpleDateFormat("EE").format(date));
            }
//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd h:m");
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







            for(String week:weeks){

                if (week.equals(courseStartDate)){
                    active = true;
                    currentCourseActive.add(1);
                } else if (active){
                    currentCourseActive.add(1);
                }
                if(week.equals(courseEndDate)){
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