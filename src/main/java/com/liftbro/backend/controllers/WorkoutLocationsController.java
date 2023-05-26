package com.liftbro.backend.controllers;

import com.liftbro.backend.models.WorkoutLocations;
import com.liftbro.backend.services.WorkoutLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutLocationsController {

    @Autowired
    private WorkoutLocationsService workoutLocationsService;

    @PostMapping("/workoutLocations")
    public ResponseEntity<String> create(@RequestBody WorkoutLocations workoutLocation) {
        String status = workoutLocationsService.upsert(workoutLocation);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/workoutLocations/{workout_location_id}")
    public ResponseEntity<WorkoutLocations> getWorkoutLocation(@PathVariable Integer workout_location_id) {
        WorkoutLocations workoutLocation = workoutLocationsService.getById(workout_location_id);
        return new ResponseEntity<>(workoutLocation, HttpStatus.OK);
    }

    @GetMapping("/workoutLocations")
    public ResponseEntity<List<WorkoutLocations>> getAllWorkoutLocations() {
        List<WorkoutLocations> allWorkoutLocations = workoutLocationsService.getAllWorkoutLocations();
        return new ResponseEntity<>(allWorkoutLocations, HttpStatus.OK);
    }

    @PutMapping("/workoutLocations")
    public ResponseEntity<String> updateWorkoutLocation(@RequestBody WorkoutLocations workoutLocation) {
        String status = workoutLocationsService.upsert(workoutLocation);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/workoutLocations/{workout_location_id}")
    public ResponseEntity<String> deleteWorkoutLocation(@PathVariable Integer workout_location_id) {
        String status = workoutLocationsService.deleteById(workout_location_id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
