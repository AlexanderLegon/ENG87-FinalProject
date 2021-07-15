package com.sparta.eng87.finalproject;


import com.sparta.eng87.finalproject.entities.LocationEntity;
import com.sparta.eng87.finalproject.repositories.LocationRepository;
import com.sparta.eng87.finalproject.services.LocationService;
import com.sparta.eng87.finalproject.entities.DisciplineEntity;
import com.sparta.eng87.finalproject.services.DisciplineService;
import com.sparta.eng87.finalproject.entities.TraineeEntity;
import com.sparta.eng87.finalproject.services.TraineeService;
import com.sparta.eng87.finalproject.entities.TrainerEntity;
import com.sparta.eng87.finalproject.services.TrainerService;
import com.sparta.eng87.finalproject.entities.CourseEntity;
import com.sparta.eng87.finalproject.services.CourseService;
import com.sparta.eng87.finalproject.entities.CourseTypeEntity;
import com.sparta.eng87.finalproject.services.CourseTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.sql.Date;


@SpringBootApplication
public class FinalProjectApplication {

    public static void main(String[] args) {


        SpringApplication.run(FinalProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CourseTypeService courseTypeService, LocationService locationService, DisciplineService disciplineService, TraineeService traineeService, TrainerService trainerService, CourseService courseService) {
        return (args) -> {
            locationService.addLocation(new LocationEntity("Leeds", 50));
            locationService.addLocation(new LocationEntity("Manchester", 25));
            locationService.addLocation(new LocationEntity("Liverpool", 30));
            locationService.addLocation(new LocationEntity("Birmingham", 40));
            disciplineService.addDiscipline(new DisciplineEntity("Java", 12));
            disciplineService.addDiscipline(new DisciplineEntity("C#", 12));
            disciplineService.addDiscipline(new DisciplineEntity("DevOps", 12));
            disciplineService.addDiscipline(new DisciplineEntity("JavaSDET", 12));
            disciplineService.addDiscipline(new DisciplineEntity("C#SDET", 12));
            traineeService.addTrainee(new TraineeEntity("qwe", "asd", 1));
            traineeService.addTrainee(new TraineeEntity("dgfsgdsf", "dafghsfd", 2));
            traineeService.addTrainee(new TraineeEntity("George", "dafghsfd", 2));
            traineeService.addTrainee(new TraineeEntity("Karim", "dafghsfd", 2));
            traineeService.addTrainee(new TraineeEntity("Tom", "dafghsfd", 2));
            traineeService.addTrainee(new TraineeEntity("Thomas", "dafghsfd", 2));
            traineeService.addTrainee(new TraineeEntity("Alexander", "dafghsfd", 2));
            traineeService.addTrainee(new TraineeEntity("Alex L", "dafghsfd", 2));
            traineeService.addTrainee(new TraineeEntity("Alex C", "dafghsfd", 2));
            traineeService.addTrainee(new TraineeEntity("Jian", "dafghsfd", 2));
            traineeService.addTrainee(new TraineeEntity("Adrian", "dafghsfd", 2));
            trainerService.addTrainer(new TrainerEntity("Karim", "Wohler"));
            trainerService.addTrainer(new TrainerEntity("Mike", "Wazowski"));
            trainerService.addTrainer(new TrainerEntity("Ainsley", "Harriott"));
            courseService.addCourse(new CourseEntity("Engineering 87", 1 ,1 , 2 ,1, Date.valueOf("2021-05-04")));
            courseService.addCourse(new CourseEntity("Data 17", 2 ,2 , 2 ,2, Date.valueOf("2021-04-19")));
            courseService.addCourse(new CourseEntity("Engineering 90", 4 ,2 , 2 ,3, Date.valueOf("2021-05-10")));
            courseService.addCourse(new CourseEntity("Business 61", 5 ,3 , 1 ,2, Date.valueOf("2021-04-12")));
            courseTypeService.save(new CourseTypeEntity("Business"));
            courseTypeService.save(new CourseTypeEntity("Technology"));
        };
    }
}
