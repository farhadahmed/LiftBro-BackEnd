package com.liftbro.backend.services;

import com.liftbro.backend.models.WorkoutSessionAttendees;

import java.util.List;

public interface WorkoutSessionAttendeesService {
    public String upsert(WorkoutSessionAttendees workoutSessionAttendees);

    public WorkoutSessionAttendees getById(Integer workoutSessionAttendeeId);

    public List<WorkoutSessionAttendees> getAllWorkoutSessionAttendees();

    public String deleteById(Integer workoutSessionAttendeeId);
}
