package com.sparta.eng87.finalproject;


import com.sparta.eng87.finalproject.entities.LocationEntity;
import com.sparta.eng87.finalproject.repositories.LocationRepository;
import com.sparta.eng87.finalproject.services.LocationService;
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
    public CommandLineRunner demo(LocationService locationService, DisciplineService disciplineService) {
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


        };

    }
}
