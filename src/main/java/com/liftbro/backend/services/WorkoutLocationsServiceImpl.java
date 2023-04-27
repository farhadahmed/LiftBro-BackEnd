package com.liftbro.backend.services;

import com.liftbro.backend.models.WorkoutLocations;
import com.liftbro.backend.repos.WorkoutLocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutLocationsServiceImpl implements WorkoutLocationsService {

    @Autowired
    private WorkoutLocationsRepository workoutLocationsRepository;

    @Override
    public String upsert(WorkoutLocations workoutLocation) {
        workoutLocationsRepository.save(workoutLocation); // upsert -- either insert or update based on primary key
        return "success";
    }

    @Override
    public WorkoutLocations getById(Integer workoutLocationId) {
        Optional<WorkoutLocations> findById = workoutLocationsRepository.findById(workoutLocationId);

        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public List<WorkoutLocations> getAllWorkoutLocations() {
        return workoutLocationsRepository.findAll();
    }

    @Override
    public String deleteById(Integer workoutLocationId) {
        if (workoutLocationsRepository.existsById(workoutLocationId)) {
            workoutLocationsRepository.deleteById(workoutLocationId);
            return "Delete successful";
        }
        else {
            return "No record found";
        }
    }
}
