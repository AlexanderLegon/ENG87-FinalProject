package com.sparta.eng87.finalproject.ServiceTests;

import com.sparta.eng87.finalproject.entities.CourseEntity;

import com.sparta.eng87.finalproject.repositories.CourseRepository;
import com.sparta.eng87.finalproject.services.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.*;

public class CourseServiceTests {

    private CourseService courseService;
    private CourseEntity courseEntity;
    private List<CourseEntity> courses;
    private List<Object[]> coursesInArrays= new ArrayList<>();
    private List<String> courseNames= Arrays.asList("testing1","testing2");
    private List<String> discipline= Arrays.asList("java","ba");
    private List<String> courseType= Arrays.asList("tech","business");
    private List<String> trainerFirstNames = Arrays.asList("fred","jeff");
    private List<String> trainerLastNames = Arrays.asList("bloggs","doe");
    private List<String> location = Arrays.asList("London", "Birmingham");
    private List<java.util.Date> startDate = Arrays.asList(new GregorianCalendar(2021,Calendar.MAY,4).getTime(),new GregorianCalendar(2021,Calendar.MAY,10).getTime());
    private List<Integer> duration= Arrays.asList(12,7);
    private List<Integer> courseId = Arrays.asList(1,2);
    private List<String> traineeCount = Arrays.asList("12","5");
    private List<String> trainerNames = Arrays.asList("fred bloggs","jeff doe");



    @BeforeEach
    void setUp(){
        CourseRepository courseRepository= Mockito.mock(CourseRepository.class);
        courseEntity = new CourseEntity("test",1,1,1,1,new Date(121,1,1));
        courseEntity.setCourseId(1);
        courses = Arrays.asList(courseEntity,courseEntity,courseEntity,courseEntity);
        Object[] one = {courseNames.get(0),discipline.get(0),courseType.get(0),trainerFirstNames.get(0),trainerLastNames.get(0),location.get(0),startDate.get(0),duration.get(0),courseId.get(0),traineeCount.get(0)};
        Object[] two = {courseNames.get(1),discipline.get(1),courseType.get(1),trainerFirstNames.get(1),trainerLastNames.get(1),location.get(1),startDate.get(1),duration.get(1),courseId.get(1),traineeCount.get(1)};
        coursesInArrays.add(one);
        coursesInArrays.add(two);
        Mockito.when(courseRepository.findById(1)).thenReturn(java.util.Optional.of(courseEntity));
        Mockito.when(courseRepository.getCourseEntityByCourseName("test")).thenReturn(courseEntity);
        Mockito.when(courseRepository.getAllCourses()).thenReturn(courses);
        Mockito.when(courseRepository.getAllCoursesByArray()).thenReturn(coursesInArrays);
        courseService=new CourseService(courseRepository);

    }

//    @Test
//    void shouldThrowInvalidArgumentException(){
//        Assertions.assertThrows(IllegalArgumentException.class,()->{courseService.findCourseById(999);});
//    }

    @Test
    void shouldReturnACourseEntity(){
        Assertions.assertEquals(courseService.findCourseById(1),courseEntity);
    }

    @Test
    void shouldReturnCourseEntityByName(){
        Assertions.assertEquals(courseService.getCourseEntityByCourseName("test"),courseEntity);
    }

    @Test
    void shouldGetAllCourses(){
        Assertions.assertEquals(courseService.getAllCourses(),courses);
    }

    @Test
    void shouldGetCourseNames(){
        Assertions.assertEquals(courseService.getCourseNames(),courseNames);
    }

    @Test

    void shouldGetDisciplineNames(){
        Assertions.assertEquals(courseService.getDisciplineNames(),discipline);
    }

    @Test
    void shouldGetCourseTypeNames(){
        Assertions.assertEquals(courseService.getCourseTypeNames(),courseType);
    }

    @Test
    void shouldGetTraineeCount(){
        Assertions.assertEquals(courseService.getTraineeCount(),traineeCount);
    }

    @Test
    void shouldGetTrainerNames(){
        Assertions.assertEquals(courseService.getTrainerNames(),trainerNames);
    }

    @Test
    void shouldGetLocations(){
        Assertions.assertEquals(courseService.getLocations(),location);
    }

    @Test
    void shouldGetStartDates(){
        Assertions.assertEquals(courseService.getCourseStartDates(),startDate);
    }

    @Test
    void shouldReturnDatesAsFormattedString(){
        List<String> formattedDates= new ArrayList<>();
        formattedDates.add("04-05-21");
        formattedDates.add("10-05-21");
        Assertions.assertEquals(courseService.getListOfStringFromDates(startDate),formattedDates);
    }
    @Test
    void shouldReturnCourseDuration(){
        Assertions.assertEquals(courseService.getDisciplineDurations(),duration);
    }
    @Test
    void shouldReturnCourseEndDates(){
        List<java.util.Date> endDates = new ArrayList<>();
        endDates.add(new GregorianCalendar(2021, Calendar.JULY,23).getTime());
        endDates.add(new GregorianCalendar(2021, Calendar.JUNE,25).getTime());
       Assertions.assertEquals(courseService.getCourseEndDate(),endDates);
    }

    @Test
    void shouldReturnBondDates(){
        List<java.util.Date> bonds = new ArrayList<>();
        bonds.add(new GregorianCalendar(2021, Calendar.OCTOBER,23).getTime());
        bonds.add(new GregorianCalendar(2021, Calendar.SEPTEMBER,25).getTime());
        Assertions.assertEquals(courseService.getBonds(),bonds);
    }
    
}
