package com.liftbro.backend.services;

import com.liftbro.backend.models.WorkoutSessionAttendees;
import com.liftbro.backend.repos.WorkoutSessionAttendeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutSessionAttendeesServiceImpl implements WorkoutSessionAttendeesService {

    @Autowired
    private WorkoutSessionAttendeesRepository workoutSessionAttendeesRepository;


    @Override
    public String upsert(WorkoutSessionAttendees workoutSessionAttendees) {
        workoutSessionAttendeesRepository.save(workoutSessionAttendees); // upsert -- either insert or update based on primary key
        return "success";
    }

    @Override
    public WorkoutSessionAttendees getById(Integer workoutSessionAttendeeId) {
        Optional<WorkoutSessionAttendees> findById = workoutSessionAttendeesRepository.findById(workoutSessionAttendeeId);

        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public List<WorkoutSessionAttendees> getAllWorkoutSessionAttendees() {
        return workoutSessionAttendeesRepository.findAll();
    }

    @Override
    public String deleteById(Integer workoutSessionAttendeeId) {
        if (workoutSessionAttendeesRepository.existsById(workoutSessionAttendeeId)) {
            workoutSessionAttendeesRepository.deleteById(workoutSessionAttendeeId);
            return "Delete successful ";
        }
        else {
            return "No record found";
        }
    }
}
