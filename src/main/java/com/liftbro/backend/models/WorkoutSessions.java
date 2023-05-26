package com.liftbro.backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "workout_sessions")
public class WorkoutSessions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workout_session_id;
    private int workout_location_id;
    private Timestamp sessionDateTime;
    private Timestamp creationDate;
    private Timestamp lastUpdated;

}

/*
create table workout_sessions(
	workout_session_id int AUTO_INCREMENT PRIMARY KEY,
    workout_location_id int,
    session_date_time DATETIME,
    creation_date DATETIME,
    last_updated DATETIME,
    FOREIGN KEY (workout_location_id) REFERENCES workout_locations (workout_location_id)
);
 */