package com.sparta.eng87.finalproject.ControllerTests;

import com.sparta.eng87.finalproject.controllers.ScheduleController;
import com.sparta.eng87.finalproject.services.CourseService;
import com.sparta.eng87.finalproject.services.ScheduleService;
import com.sparta.eng87.finalproject.services.TrainerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;


import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

public class ScheduleControllerTest {

    private ScheduleController scheduleController;
    private Model model;

    @BeforeEach
    void setUp(){
        CourseService courseService = Mockito.mock(CourseService.class);
        TrainerService trainerService = Mockito.mock(TrainerService.class);
        ScheduleService scheduleService = Mockito.mock(ScheduleService.class);
        model = Mockito.spy(Model.class);
        List<String> dates = Arrays.asList("1","2","3","4");
        List<Integer> duration= Arrays.asList(12,12,12,12);
        List<String> courseNames= Arrays.asList("course1","course2","course3","course4");
        Object[] active = {"1","1","1","1"};
        List<String> colours = Arrays.asList("Red", "Green", "Yellow","Red");
        List<Object[]> activeWeeks = Arrays.asList(active,active,active,active);
        List<String> traineeCount= Arrays.asList("5","10","6","4");
        Mockito.when(scheduleService.listDates()).thenReturn(dates);
        Mockito.when(courseService.getCourseNames()).thenReturn(courseNames);
        Mockito.when(scheduleService.getActiveCourseWeeks(dates,courseNames)).thenReturn(activeWeeks);
        Mockito.when(courseService.getTraineeCount()).thenReturn(traineeCount);
        Mockito.when(courseService.getDisciplineNames()).thenReturn(dates);
        Mockito.when(courseService.getCourseTypeNames()).thenReturn(dates);
        Mockito.when(courseService.getTrainerNames()).thenReturn(courseNames);
        Mockito.when(courseService.getLocations()).thenReturn(dates);
        Mockito.when(courseService.getListOfStringFromDates(anyList())).thenReturn(dates);
        Mockito.when(courseService.getDisciplineDurations()).thenReturn(duration);
        Mockito.when(trainerService.getListOfTrainerColor(anyList())).thenReturn(colours);
        Mockito.when(model.addAttribute(anyString(),anyList())).thenReturn(new ExtendedModelMap());
        scheduleController= new ScheduleController(courseService,trainerService,scheduleService);
    }

    @Test
    void shouldDirectToSchedulePage(){
        Assertions.assertEquals(scheduleController.goToScheduler(model), "schedulerPage");
    }
}
