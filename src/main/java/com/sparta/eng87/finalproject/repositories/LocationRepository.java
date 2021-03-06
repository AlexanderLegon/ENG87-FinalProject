package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

    @Query(value = "SELECT * FROM location l", nativeQuery = true)
    List<Object> getAllLocations();

    @Query(value = "SELECT number_of_rooms FROM location WHERE location_id = ?", nativeQuery = true)
    int getNumberOfRoomsById(Integer locationId);

    @Query(value = "SELECT * FROM location", nativeQuery = true)
    List<LocationEntity> getAllLocationEntities();
}
