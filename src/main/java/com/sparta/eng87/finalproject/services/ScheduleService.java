package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.repositories.CourseRepository;
import com.sparta.eng87.finalproject.repositories.TrainerRepository;
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
    TrainerRepository trainerRepository;

    public ScheduleService(CourseRepository courseRepository, CourseService courseService, TrainerRepository trainerRepository) {
        this.courseRepository = courseRepository;
        this.courseService = courseService;
        this.trainerRepository = trainerRepository;
    }

    public List<String> listDates() {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate yearStart = LocalDate.of(2021, 5, 1);
        LocalDate yearEnd = LocalDate.of(2022, 4, 30);
        LocalDate now = LocalDate.now();

        List<String> dates = new ArrayList<>();

        while (!(yearStart.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
            yearStart = yearStart.minusDays(1);
        }

        while (!(yearEnd.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
            yearEnd = yearEnd.minusDays(1);
        }

        while (now.isAfter(yearEnd)) {
            yearEnd = yearEnd.plusYears(1);
        }


        //   System.out.println(dateFormat.format(date));
        //   System.out.println(new SimpleDateFormat("EE").format(date));
        dates.add(formatter.format(yearStart).toString());
        for (int i = 0; i < 52; i++) {

            yearStart = yearStart.plusDays(7);
            dates.add(formatter.format(yearStart).toString());
        }


        return dates;

    }

    public List<Object[]> getActiveCourseWeeks(List<String> weeks, List<String> courseNames) {
        String courseStartDate;
        List<Date> courseEndDate = courseService.getCourseEndDate();
        String currentEndDate;
        List<Object[]> activeDays = new ArrayList<>();
        List<String> currentCourseActive = new ArrayList<>();
        boolean active = false;

//        ZoneOffset offset = ZoneOffset.of("Z");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < courseNames.size(); i++) {

            courseStartDate = courseRepository.getCourseStartDatesByCourseName(courseNames.get(i));
            currentEndDate = dateFormat.format(courseEndDate.get(i));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate courseStartDateTime = LocalDate.parse(courseStartDate, formatter);
            LocalDate courseEndDateTime = LocalDate.parse(currentEndDate, formatter2);
            Integer courseId = courseRepository.findCourseIdByCourseName(courseNames.get(i));


//            courseStartDate = dateFormat.format(courseStartDate);


            while (!(courseStartDateTime.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
                courseStartDateTime = courseStartDateTime.minusDays(1);
            }
            while (!(courseEndDateTime.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
                courseEndDateTime = courseEndDateTime.minusDays(1);
            }


            currentEndDate = courseEndDateTime.toString();
            courseStartDate = courseStartDateTime.toString();
            int weekNum = 1;
            int index = 0;
            List<Object[]> trainerWeeks = courseRepository.getTrainerDatesByCourseId(courseId);
            Object[] currentTrainer = trainerWeeks.get(0);

            LocalDate holidayDate = LocalDate.of(2021, 12, 31);

            LocalDate currentYear = LocalDate.parse(weeks.get(0), formatter2);
            while (currentYear.isAfter(holidayDate.plusMonths(5))) {
                holidayDate = holidayDate.plusYears(1);
            }
            while (!(holidayDate.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
                holidayDate = holidayDate.minusDays(1);
            }

            LocalDate holidayDate2 = holidayDate.minusDays(8);
            holidayDate = holidayDate.plusDays(1);



            for (String week : weeks) {
                LocalDate currentWeek = LocalDate.parse(week, formatter2);

                if (!(currentWeek.isBefore(holidayDate) && currentWeek.isAfter(holidayDate2))) {

                    if ((currentWeek.isAfter(courseStartDateTime) && currentWeek.isBefore(courseEndDateTime)) || currentWeek.isEqual(courseEndDateTime) || currentWeek.isEqual(courseStartDateTime)) {
                        // currentCourseActive.add(1);
                        for (int k = 0; k < trainerWeeks.size(); k++) {

                            if ((int) trainerWeeks.get(k)[4] == weekNum) {
                                currentTrainer = trainerWeeks.get(k);
                                break;
                            }
                            if ((int) currentTrainer[2] < weekNum) {
                                if ((int) trainerWeeks.get(k)[4] < weekNum && (int) trainerWeeks.get(k)[2] > weekNum) {
                                    currentTrainer = trainerWeeks.get(k);
                                }
                            }
                        }

                        currentCourseActive.add(trainerRepository.getTrainerColorByTrainerId((int) currentTrainer[3]));


                        weekNum++;
                    } else {
                        currentCourseActive.add("#ffffff");
                    }
                } else {
                    currentCourseActive.add("#ffffff");
                }

            }
            activeDays.add(currentCourseActive.toArray());
            currentCourseActive.clear();
        }
        return activeDays;
    }
}