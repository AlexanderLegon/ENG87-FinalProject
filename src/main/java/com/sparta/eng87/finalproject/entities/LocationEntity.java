package com.sparta.eng87.finalproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "location", schema = "courseorganisation")
public class LocationEntity {
    private Integer locationId;
    private String location;
    private Integer numberOfRooms;

    public LocationEntity() {
    }

    public LocationEntity(String location, Integer numberOfRooms) {
        this.location = location;
        this.numberOfRooms = numberOfRooms;
    }

    @Id
    @Column(name = "location_id")
    @GeneratedValue
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "number_of_rooms")
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
