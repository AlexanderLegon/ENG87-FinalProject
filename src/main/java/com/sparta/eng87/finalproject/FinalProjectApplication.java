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
        };
    }

}
