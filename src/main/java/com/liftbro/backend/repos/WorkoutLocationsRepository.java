package com.liftbro.backend.repos;

import com.liftbro.backend.models.WorkoutLocations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface WorkoutLocationsRepository extends JpaRepository<WorkoutLocations, Serializable> {
}
