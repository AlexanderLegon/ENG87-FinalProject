package com.sparta.eng87.finalproject;


import com.sparta.eng87.finalproject.entities.UserEntity;
import com.sparta.eng87.finalproject.services.UserService;
import com.sparta.eng87.finalproject.entities.*;
import com.sparta.eng87.finalproject.repositories.LocationRepository;
import com.sparta.eng87.finalproject.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.sql.Date;


@SpringBootApplication
public class FinalProjectApplication {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {


        SpringApplication.run(FinalProjectApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(UserService userService, CourseTypeService courseTypeService, LocationService locationService, DisciplineService disciplineService, TraineeService traineeService, TrainerService trainerService, CourseService courseService, QualityGateService qualityGateService) {
        return (args) -> {
//            locationService.addLocation(new LocationEntity("Leeds", 50));
//            locationService.addLocation(new LocationEntity("Manchester", 25));
//            locationService.addLocation(new LocationEntity("Liverpool", 30));
//            locationService.addLocation(new LocationEntity("Birmingham", 40));
//            disciplineService.addDiscipline(new DisciplineEntity("Java", 12));
//            disciplineService.addDiscipline(new DisciplineEntity("C#", 12));
//            disciplineService.addDiscipline(new DisciplineEntity("DevOps", 12));
//            disciplineService.addDiscipline(new DisciplineEntity("JavaSDET", 12));
//            disciplineService.addDiscipline(new DisciplineEntity("C#SDET", 12));
//            traineeService.addTrainee(new TraineeEntity("qwe", "asd", 1));
//            traineeService.addTrainee(new TraineeEntity("dgfsgdsf", "dafghsfd", 2));
//            traineeService.addTrainee(new TraineeEntity("George", "dafghsfd", 2));
//            traineeService.addTrainee(new TraineeEntity("Karim", "dafghsfd", 2));
//            traineeService.addTrainee(new TraineeEntity("Tom", "dafghsfd", 2));
//            traineeService.addTrainee(new TraineeEntity("Thomas", "dafghsfd", 2));
//            traineeService.addTrainee(new TraineeEntity("Alexander", "dafghsfd", 2));
//            traineeService.addTrainee(new TraineeEntity("Alex L", "dafghsfd", 2));
//            traineeService.addTrainee(new TraineeEntity("Alex C", "dafghsfd", 2));
//            traineeService.addTrainee(new TraineeEntity("Jian", "dafghsfd", 2));
//            traineeService.addTrainee(new TraineeEntity("Adrian", "dafghsfd", 2));
//            trainerService.addTrainer(new TrainerEntity("Karim", "Wohler"));
//            trainerService.addTrainer(new TrainerEntity("Mike", "Wazowski"));
//            trainerService.addTrainer(new TrainerEntity("Ainsley", "Harriott"));
//            courseService.addCourse(new CourseEntity("Engineering 87", 1 ,1 , 2 ,1, Date.valueOf("2021-05-04")));
//            courseService.addCourse(new CourseEntity("Data 17", 2 ,2 , 2 ,2, Date.valueOf("2021-04-19")));
//            courseService.addCourse(new CourseEntity("Engineering 90", 4 ,2 , 2 ,3, Date.valueOf("2021-05-10")));
//            courseService.addCourse(new CourseEntity("Business 61", 5 ,3 , 1 ,2, Date.valueOf("2021-04-12")));
//            courseTypeService.addCourseType(new CourseTypeEntity("Business"));
//            courseTypeService.addCourseType(new CourseTypeEntity("Technology"));
           qualityGateService.save(new QualityGateEntity(1,"Failed- needs support",1,2,"good technical answers but soft skill questions lacking","good content to answers but they are rambled and communication is unclear",  Date.valueOf("2021-04-12")));
            qualityGateService.save(new QualityGateEntity(1,"Passed",2,3,"much clearer answers with strong personality coming through","Made good attempt at technical questions testing to see how they behaved when they aren't sure", Date.valueOf("2021-05-10")));
            qualityGateService.save(new QualityGateEntity(2,"passed",1,2,"Amazing","Really well structured answer to all questions", Date.valueOf("2021-05-04")));
//            userService.addUser(new UserEntity("Alex", encoder.encode("password"), "USER", 1));
//            userService.addUser(new UserEntity("Richard", encoder.encode("password"), "USER", 1));


        };
    }
}
