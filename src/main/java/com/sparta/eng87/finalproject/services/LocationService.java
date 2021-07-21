package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.entities.LocationEntity;
import com.sparta.eng87.finalproject.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void addLocation (LocationEntity locationEntity) {
        locationRepository.save(locationEntity);
    }

    public Object findLocationById(Integer id) {
        return locationRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid location ID: " + id)
        );
    }

    public List<Object> getAllLocations(){
        return locationRepository.getAllLocations();
    }

    public void deleteLocation(Integer id) {
        locationRepository.deleteById(id);
    }

    public int getNumberOfRoomsById(Integer locationId) {
        return locationRepository.getNumberOfRoomsById(locationId);
    }
}
