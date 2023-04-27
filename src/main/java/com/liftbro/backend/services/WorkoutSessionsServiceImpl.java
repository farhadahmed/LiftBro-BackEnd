package com.liftbro.backend.services;

import com.liftbro.backend.models.WorkoutLocations;
import com.liftbro.backend.models.WorkoutSessions;
import com.liftbro.backend.repos.WorkoutSessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutSessionsServiceImpl implements WorkoutSessionsService {

    @Autowired
    private WorkoutSessionsRepository workoutSessionsRepository;

    @Override
    public String upsert(WorkoutSessions workoutSession) {
        workoutSessionsRepository.save(workoutSession); // upsert -- either insert or update based on primary key
        return "success";
    }

    @Override
    public WorkoutSessions getById(Integer workoutSessionId) {
        Optional<WorkoutSessions> findById = workoutSessionsRepository.findById(workoutSessionId);

        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public List<WorkoutSessions> getAllWorkoutSessions() {
        return workoutSessionsRepository.findAll();
    }

    @Override
    public String deleteById(Integer workoutSessionId) {
        if (workoutSessionsRepository.existsById(workoutSessionId)) {
            workoutSessionsRepository.deleteById(workoutSessionId);
            return "Delete successful ";
        }
        else {
            return "No record found";
        }
    }
}
