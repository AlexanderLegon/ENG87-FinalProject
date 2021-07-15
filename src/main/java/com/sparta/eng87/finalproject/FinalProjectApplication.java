package com.sparta.eng87.finalproject;

import com.sparta.eng87.finalproject.entities.TrainerEntity;
import com.sparta.eng87.finalproject.services.TrainerService;
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
    public CommandLineRunner demo(TrainerService trainerService){
        return (args) -> {
            trainerService.addTrainer(new TrainerEntity(1, "Karim", "Wohler"));
            trainerService.addTrainer(new TrainerEntity(2, "Mike", "Wazowski"));
            trainerService.addTrainer(new TrainerEntity(3, "Ainsley", "Harriott"));
        };
    }
}
