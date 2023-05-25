package com.liftbro.backend.services;

import com.liftbro.backend.models.WorkoutSessions;

import java.util.List;

public interface WorkoutSessionsService {
    public String upsert(WorkoutSessions workoutSession);

    public WorkoutSessions getById(Integer workoutSessionId);

    public List<WorkoutSessions> getAllWorkoutSessions();

    public String deleteById(Integer workoutSessionId);
}
