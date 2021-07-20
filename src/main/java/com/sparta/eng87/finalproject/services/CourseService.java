package com.sparta.eng87.finalproject.services;


import com.sparta.eng87.finalproject.entities.CourseEntity;
import com.sparta.eng87.finalproject.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.List;

@Service
public class CourseService {
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-YY");

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void addCourse(CourseEntity courseEntity){
        courseRepository.save(courseEntity);
    }

    public CourseEntity findCourseById(Integer id){
        return courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid ID")
        );
    }

    public void removeCourse(Integer id){
        courseRepository.deleteById(id);
    }

    public CourseEntity getCourseEntityByCourseName(String courseName) {
        return courseRepository.getCourseEntityByCourseName(courseName);
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public List<Object[]> getAllCoursesObjects() {
        return courseRepository.getAllCoursesByArray();
    }

    public List<String> getCourseNames(){
        List<String> courseNames = new ArrayList<>();
        List<Object[]> courseInformation = courseRepository.getAllCoursesByArray();

        for(Object[] c: courseInformation){
            courseNames.add("" + c[0]);
        }
        return courseNames;
    }

    public List<String> getDisciplineNames(){
        List<String> disciplineNames = new ArrayList<>();
        List<Object[]> courseInformation = courseRepository.getAllCoursesByArray();

        for(Object[] c: courseInformation){
            disciplineNames.add("" + c[1]);
        }
        return disciplineNames;
    }

    public List<String> getCourseTypeNames(){
        List<String> courseTypeNames = new ArrayList<>();
        List<Object[]> courseInformation = courseRepository.getAllCoursesByArray();

        for(Object[] c: courseInformation){
            courseTypeNames.add("" + c[2]);
        }
        return courseTypeNames;
    }

    public List<String> getTrainerNames(){
        List<String> trainerNames = new ArrayList<>();
        List<Object[]> courseInformation = courseRepository.getAllCoursesByArray();

        for(Object[] c: courseInformation){
            trainerNames.add("" + c[3] + " " + c[4]);
        }
        return trainerNames;
    }

    public List<String> getLocations(){
        List<String> locations = new ArrayList<>();
        List<Object[]> courseInformation = courseRepository.getAllCoursesByArray();

        for(Object[] c: courseInformation){
            locations.add("" + c[5]);
        }
        return locations;
    }

    public List<Date> getCourseStartDates(){
        List<Date> courseStartDates = new ArrayList<>();
        List<Object[]> courseInformation = courseRepository.getAllCoursesByArray();

        for(Object[] c: courseInformation){
            courseStartDates.add((Date)c[6]);
        }
        return courseStartDates;
    }

    public List<String> getListOfStringFromDates(List<Date> dates){
        List<String> output = new ArrayList<>();

        for(Date d: dates){
            output.add(format.format(d));
        }

        return output;
    }

    public List<Integer> getDisciplineDurations(){
        List<Integer> disciplineDurations = new ArrayList<>();
        List<Object[]> courseInformation = courseRepository.getAllCoursesByArray();

        for(Object[] c: courseInformation){
            disciplineDurations.add((Integer)c[7]);
        }
        return disciplineDurations;
    }

    public List<Date> getCourseEndDate(){
        List<Date> courseStartDates = getCourseStartDates();
        List<Integer> courseDurations = getDisciplineDurations();
        List<Date> courseEndDates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        for(int i = 0; i < courseStartDates.size(); i++){
            calendar.setTime(courseStartDates.get(i));
            calendar.add(Calendar.DATE, ((courseDurations.get(i)-1)*7));
            Date endDate = calendar.getTime();
            for(int j = 0; j < 7; j++){
                if(calendar.get(Calendar.DAY_OF_WEEK) == 6){
                    endDate = calendar.getTime();
                    courseEndDates.add(endDate);
                    break;
                }
                calendar.add(Calendar.DATE, 1);

            }
        }
        return courseEndDates;
    }

    public List<Date> getBonds(){
        List<Date> courseEndDates = getCourseEndDate();
        Calendar calendar = Calendar.getInstance();
        List<Date> endBondDates = new ArrayList<>();

        for(Date c: courseEndDates){
            calendar.setTime(c);
            calendar.add(Calendar.MONTH, 3);
            Date endBondDate = calendar.getTime();
            endBondDates.add(endBondDate);
        }

        return endBondDates;
    }

}
