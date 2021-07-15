package com.sparta.eng87.finalproject;

import com.sparta.eng87.finalproject.entities.CourseTypeEntity;
import com.sparta.eng87.finalproject.services.CourseTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CourseTypeService courseTypeService){
        return (args) -> {
          courseTypeService.save(new CourseTypeEntity("Business"));
          courseTypeService.save(new CourseTypeEntity("Technology"));
        };
    }
}
