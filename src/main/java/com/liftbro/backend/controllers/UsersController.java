package com.liftbro.backend.controllers;

import com.liftbro.backend.models.Users;
import com.liftbro.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users2")
    public ResponseEntity<String> createUser(@RequestBody Users user) {
        String status = usersService.upsert(user);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/users2/{user_id}")
    public ResponseEntity<Users> getUser(@PathVariable Integer user_id) {
        Users user = usersService.getById(user_id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users2")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> allUsers = usersService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PutMapping("/users2")
    public ResponseEntity<String> updateUser(@RequestBody Users user) {
        String status = usersService.upsert(user);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/users2/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer user_id) {
        String status = usersService.deleteById(user_id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
