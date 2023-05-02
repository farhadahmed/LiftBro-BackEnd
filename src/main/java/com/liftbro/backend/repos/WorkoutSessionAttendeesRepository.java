package com.liftbro.backend.repos;

import com.liftbro.backend.models.WorkoutSessionAttendees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface WorkoutSessionAttendeesRepository extends JpaRepository<WorkoutSessionAttendees, Serializable> {
}
