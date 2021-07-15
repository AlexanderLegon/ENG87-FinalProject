package com.sparta.eng87.finalproject;

import com.sparta.eng87.finalproject.entities.UserEntity;
import com.sparta.eng87.finalproject.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FinalProjectApplication {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(UserService userService) {
//        return (args) -> {
//            userService.addUser(new UserEntity("Alex", encoder.encode("password"), "USER", 1));
//            userService.addUser(new UserEntity("Tom", encoder.encode("password"), "USER", 1));
//
//        };
//    }
}
