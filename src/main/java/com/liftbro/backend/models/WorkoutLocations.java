package com.liftbro.backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="workout_locations")
public class WorkoutLocations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workout_location_id;
    private String address;
    private String name;
}

/*
SCHEMA

create table workout_locations(
	workout_location_id int AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(200) NOT NULL,
    name VARCHAR(150) NOT NULL
);
 */