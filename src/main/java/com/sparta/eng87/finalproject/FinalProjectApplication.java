package com.sparta.eng87.finalproject;

import com.sparta.eng87.finalproject.entities.CourseEntity;
import com.sparta.eng87.finalproject.services.CourseService;
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
    public CommandLineRunner demo(CourseService courseService){
        return (args) -> {
            courseService.addCourse(new CourseEntity("Engineering 87", 1 ,1 , 2 ,1, Date.valueOf("2021-05-04")));
            courseService.addCourse(new CourseEntity("Data 17", 2 ,2 , 2 ,2, Date.valueOf("2021-04-19")));
            courseService.addCourse(new CourseEntity("Engineering 90", 4 ,2 , 2 ,3, Date.valueOf("2021-05-10")));
            courseService.addCourse(new CourseEntity("Business 61", 5 ,3 , 1 ,2, Date.valueOf("2021-04-12")));

        };
    }

}
