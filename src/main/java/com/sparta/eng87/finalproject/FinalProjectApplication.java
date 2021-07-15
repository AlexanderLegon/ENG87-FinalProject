package com.sparta.eng87.finalproject;

import com.sparta.eng87.finalproject.entities.LocationEntity;
import com.sparta.eng87.finalproject.repositories.LocationRepository;
import com.sparta.eng87.finalproject.services.LocationService;
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
    public CommandLineRunner demo(LocationService locationService) {
        return (args) -> {

            //loginService.addUser(new LoginEntity("employee", encoder.encode("password"), "EMPLOYEE",1 , (short) 1,1 ));
            //loginService.addUser(new LoginEntity("user", encoder.encode("password"), "USER",1 , (short) 1,1 ));
            locationService.addLocation(new LocationEntity("Leeds", 50));
            locationService.addLocation(new LocationEntity("Manchester", 25));
            locationService.addLocation(new LocationEntity("Liverpool", 30));
            locationService.addLocation(new LocationEntity("Birmingham", 40));


        };

    }
}
