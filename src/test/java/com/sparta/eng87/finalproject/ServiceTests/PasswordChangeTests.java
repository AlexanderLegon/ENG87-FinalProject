package com.sparta.eng87.finalproject.ServiceTests;


import com.sparta.eng87.finalproject.entities.UserEntity;
import com.sparta.eng87.finalproject.repositories.UserRepository;
import com.sparta.eng87.finalproject.services.UserService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;


import static org.mockito.ArgumentMatchers.anyString;

public class PasswordChangeTests {


    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp(){
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        Mockito.when(userRepository.getCurrentUser(anyString())).thenReturn(new UserEntity("Tom","Hello","User",1));
        Mockito.when(userRepository.save(new UserEntity("Tom",anyString(),"User",1))).thenReturn(new UserEntity("Tom","Hello","User",1));
        userService= new UserService(userRepository);
    }

    @Test
    void shouldReturnPasswordUpdated(){
        Assertions.assertEquals(userService.changePassword("Tom","password","password"),"Password Updated");
    }

    @Test
    void shouldReturnInvalidDetails(){
        Assertions.assertEquals(userService.changePassword("Tom","password","123"),"Invalid Details");
    }
}
