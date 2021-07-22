package com.sparta.eng87.finalproject.entitiesTest;

import com.sparta.eng87.finalproject.entities.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserEntityTests {

    UserEntity userEntity;

    @BeforeEach
    void setup() {
        userEntity = new UserEntity("Alex", "password", "ADMIN", 1);
    }

    @Test
    public void shouldReturnId() {
        userEntity.setUserId(1);
        Assertions.assertEquals(1, userEntity.getUserId());
    }

    @Test
    public void shouldReturnAlex() {
        Assertions.assertEquals("Alex", userEntity.getUserName());
    }

    @Test
    public void shouldReturnRichard() {
        userEntity.setUserName("Richard");
        Assertions.assertEquals("Richard", userEntity.getUserName());
    }

    @Test
    public void shouldReturnPassword() {
        Assertions.assertEquals("password", userEntity.getUserPassword());
    }

    @Test
    public void shouldReturnPassw0rd() {
        userEntity.setUserPassword("passw0rd");
        Assertions.assertEquals("passw0rd", userEntity.getUserPassword());
    }

    @Test
    public void shouldReturnAdmin() {
        Assertions.assertEquals("ADMIN", userEntity.getUserRole());
    }

    @Test
    public void shouldReturnUser() {
        userEntity.setUserRole("USER");
        Assertions.assertEquals("USER", userEntity.getUserRole());
    }

    @Test
    public void shouldReturn1() {
        Assertions.assertEquals(1, userEntity.getUserEnabled());
    }

    @Test
    public void shouldReturn0() {
        userEntity.setUserEnabled(0);
        Assertions.assertEquals(0, userEntity.getUserEnabled());
    }
}
