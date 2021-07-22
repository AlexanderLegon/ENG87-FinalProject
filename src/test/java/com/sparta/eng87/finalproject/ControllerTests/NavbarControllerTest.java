package com.sparta.eng87.finalproject.ControllerTests;

import com.sparta.eng87.finalproject.controllers.FragmentController;
import com.sparta.eng87.finalproject.services.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class NavbarControllerTest {

    private FragmentController fragmentController;
    private Model model;
    @BeforeEach
    void setUp(){
        TraineeService traineeService = Mockito.mock(TraineeService.class);
        TrainerService trainerService = Mockito.mock(TrainerService.class);
        LocationService locationService=Mockito.mock(LocationService.class);
        CourseService courseService = Mockito.mock(CourseService.class);
        CourseTypeService courseTypeService = Mockito.mock(CourseTypeService.class);
        DisciplineService disciplineService = Mockito.mock(DisciplineService.class);
        QualityGateService qualityGateService = Mockito.mock(QualityGateService.class);
        model=Mockito.mock(Model.class);
        Mockito.when(model.addAttribute(anyString(),any())).thenReturn(new ExtendedModelMap());
        fragmentController= new FragmentController(locationService,courseService,traineeService, trainerService,courseTypeService,disciplineService,qualityGateService);
    }

    @Test
    void shouldRedirectToAccountManagement(){
        Assertions.assertEquals(fragmentController.goToAbout(),"accountManagement");
    }

    @Test
    void shouldGoToLoginPage(){
        Assertions.assertEquals(fragmentController.goToLogin(),"login");
    }

    @Test
    void shouldGoToTraineePage(){
        Assertions.assertEquals(fragmentController.goToTrainee(model),"traineePage");
    }

    @Test
    void shouldGoToTrainerPage(){
        Assertions.assertEquals(fragmentController.goToTrainer(model),"trainerPage");
    }

    @Test
    void shouldGoToCourse(){
        Assertions.assertEquals(fragmentController.goToCourse(model),"coursePage");
    }

    @Test
    void shouldGoToCentre(){
        Assertions.assertEquals(fragmentController.goToCentre(model),"centres");
    }

    @Test
    void shouldGotToExtraCourseInfoPage(){
        Assertions.assertEquals(fragmentController.goToCourseTypes(model),"extraCourseInfoPage");
    }
}
