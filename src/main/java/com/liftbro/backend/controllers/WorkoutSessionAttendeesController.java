package com.liftbro.backend.controllers;

import com.liftbro.backend.models.WorkoutSessionAttendees;
import com.liftbro.backend.services.WorkoutSessionAttendeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutSessionAttendeesController {

    @Autowired
    private WorkoutSessionAttendeesService workoutSessionAttendeesService;

    @PostMapping("/workoutSessionAttendees")
    public ResponseEntity<String> create(@RequestBody WorkoutSessionAttendees workoutSessionAttendee) {
        String status = workoutSessionAttendeesService.upsert(workoutSessionAttendee);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/workoutSessionAttendees/{workout_session_attendee_id}")
    public ResponseEntity<WorkoutSessionAttendees> getWorkoutSessionAttendee(@PathVariable Integer workout_session_attendee_id) {
        WorkoutSessionAttendees workoutSessionAttendee = workoutSessionAttendeesService.getById(workout_session_attendee_id);
        return new ResponseEntity<>(workoutSessionAttendee, HttpStatus.OK);
    }

    @GetMapping("/workoutSessionAttendees")
    public ResponseEntity<List<WorkoutSessionAttendees>> getAllWorkoutSessionAttendees() {
        List<WorkoutSessionAttendees> allWorkoutSessionAttendees = workoutSessionAttendeesService.getAllWorkoutSessionAttendees();
        return new ResponseEntity<>(allWorkoutSessionAttendees, HttpStatus.OK);
    }

    @PutMapping("/workoutSessionAttendees")
    public ResponseEntity<String> updateWorkoutSessionAttendee(@RequestBody WorkoutSessionAttendees workoutSessionAttendee) {
        String status = workoutSessionAttendeesService.upsert(workoutSessionAttendee);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/workoutSessionAttendees/{workout_session_attendee_id}")
    public ResponseEntity<String> deleteWorkoutSessionAttendee(@PathVariable Integer workout_session_attendee_id) {
        String status = workoutSessionAttendeesService.deleteById(workout_session_attendee_id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
