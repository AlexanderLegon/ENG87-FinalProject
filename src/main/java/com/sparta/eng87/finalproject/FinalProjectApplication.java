package com.sparta.eng87.finalproject;

import com.sparta.eng87.finalproject.entities.DisciplineEntity;
import com.sparta.eng87.finalproject.services.DisciplineService;
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
    public CommandLineRunner demo(DisciplineService disciplineService){
        return (args)-> {
            disciplineService.addDiscipline(new DisciplineEntity("Java", 12));
            disciplineService.addDiscipline(new DisciplineEntity("C#", 12));
            disciplineService.addDiscipline(new DisciplineEntity("DevOps", 12));
            disciplineService.addDiscipline(new DisciplineEntity("JavaSDET", 12));
            disciplineService.addDiscipline(new DisciplineEntity("C#SDET", 12));
        };
    }
}
