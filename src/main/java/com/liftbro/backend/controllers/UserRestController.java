package com.liftbro.backend.controllers;

import com.liftbro.backend.models.UsersTest;
import com.liftbro.backend.services.UsersServiceTODELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UsersServiceTODELETE userSerice;

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UsersTest user) {
        String status = userSerice.upsert(user);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/users/{users_id}")
    public ResponseEntity<UsersTest> getUser(@PathVariable Integer users_id) {
        UsersTest user = userSerice.getById(users_id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UsersTest>> getAllUsers() {
        List<UsersTest> allUsers = userSerice.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<String> updateUser(@RequestBody UsersTest user) {
        String status = userSerice.upsert(user);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/users/{users_id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer users_id) {
        String status = userSerice.deleteById(users_id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
