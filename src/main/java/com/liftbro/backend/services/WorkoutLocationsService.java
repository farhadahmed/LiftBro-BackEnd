package com.liftbro.backend.services;

import com.liftbro.backend.models.WorkoutLocations;

import java.util.List;

public interface WorkoutLocationsService {
    public String upsert(WorkoutLocations workoutLocation);

    public WorkoutLocations getById(Integer workoutLocationId);

    public List<WorkoutLocations> getAllWorkoutLocations();

    public String deleteById(Integer workoutLocationId);
}
