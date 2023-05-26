package com.liftbro.backend.repos;

import com.liftbro.backend.models.WorkoutSessions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface WorkoutSessionsRepository extends JpaRepository<WorkoutSessions, Serializable> {
}
