package com.sparta.eng87.finalproject;

import com.sparta.eng87.finalproject.entities.TraineeEntity;
import com.sparta.eng87.finalproject.services.TraineeService;
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
    public CommandLineRunner demo(TraineeService traineeService){
        return (args) -> {
            traineeService.addTrainee(new TraineeEntity("qwe", "asd", 1));
        };
    }

}
