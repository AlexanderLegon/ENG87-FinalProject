package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.entities.LocationEntity;
import com.sparta.eng87.finalproject.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
