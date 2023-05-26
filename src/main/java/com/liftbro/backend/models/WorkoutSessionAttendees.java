package com.liftbro.backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "workout_session_attendees")
public class WorkoutSessionAttendees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workout_session_attendee_id;
    private int user_id;
    private int workout_session_id;
    private boolean is_admin_user;
}
