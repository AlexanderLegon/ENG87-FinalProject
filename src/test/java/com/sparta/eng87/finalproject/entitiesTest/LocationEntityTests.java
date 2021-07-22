package com.sparta.eng87.finalproject.entitiesTest;

import com.sparta.eng87.finalproject.entities.LocationEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationEntityTests {

    LocationEntity locationEntity;

    @BeforeEach
    void setup() {
        locationEntity = new LocationEntity("London", 10);
    }

    @Test
    public void shouldReturnId() {
        locationEntity.setLocationId(1);
        Assertions.assertEquals(1, locationEntity.getLocationId());
    }

    @Test
    public void shouldReturnLondon() {
        Assertions.assertEquals("London", locationEntity.getLocation());
    }

    @Test
    public void shouldReturnBirmingham() {
        locationEntity.setLocation("Birmingham");
        Assertions.assertEquals("Birmingham", locationEntity.getLocation());
    }

    @Test
    public void shouldReturn10() {
        Assertions.assertEquals(10, locationEntity.getNumberOfRooms());
    }

    @Test
    public void shouldReturn15() {
        locationEntity.setNumberOfRooms(15);
        Assertions.assertEquals(15, locationEntity.getNumberOfRooms());
    }
}
