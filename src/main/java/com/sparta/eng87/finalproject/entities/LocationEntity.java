package com.sparta.eng87.finalproject.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "location", schema = "courseorganisation")
@SequenceGenerator(name="sequenceLocation", initialValue=1, allocationSize = 1)
public class LocationEntity {
    private Integer locationId;
    private String location;
    private Integer numberOfRooms;

    @OneToMany(mappedBy = "location")
    private Set<CourseEntity> courseEntities;

    public LocationEntity() {
    }

    public LocationEntity(String location, Integer numberOfRooms) {
        this.location = location;
        this.numberOfRooms = numberOfRooms;
    }

    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceLocation")
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
