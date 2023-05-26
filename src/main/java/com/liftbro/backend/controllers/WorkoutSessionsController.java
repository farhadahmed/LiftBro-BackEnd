package com.liftbro.backend.controllers;

import com.liftbro.backend.models.WorkoutSessions;
import com.liftbro.backend.services.WorkoutSessionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutSessionsController {

    @Autowired
    private WorkoutSessionsService workoutSessionsService;

    @PostMapping("/workoutSessions")
    public ResponseEntity<String> create(@RequestBody WorkoutSessions workoutSession) {
        String status = workoutSessionsService.upsert(workoutSession);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/workoutSessions/{workout_session_id}")
    public ResponseEntity<WorkoutSessions> getWorkoutSession(@PathVariable Integer workout_session_id) {
        WorkoutSessions workoutSession = workoutSessionsService.getById(workout_session_id);
        return new ResponseEntity<>(workoutSession, HttpStatus.OK);
    }

    @GetMapping("/workoutSessions")
    public ResponseEntity<List<WorkoutSessions>> getAllWorkoutSessions() {
        List<WorkoutSessions> allWorkoutSessionss = workoutSessionsService.getAllWorkoutSessions();
        return new ResponseEntity<>(allWorkoutSessionss, HttpStatus.OK);
    }

    @PutMapping("/workoutSessions")
    public ResponseEntity<String> updateWorkoutSession(@RequestBody WorkoutSessions workoutSession) {
        String status = workoutSessionsService.upsert(workoutSession);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/workoutSessions/{workout_session_id}")
    public ResponseEntity<String> deleteWorkoutSession(@PathVariable Integer workout_session_id) {
        String status = workoutSessionsService.deleteById(workout_session_id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
