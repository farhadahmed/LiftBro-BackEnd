package com.liftbro.backend.rest;

import com.liftbro.backend.binding.Demos;
import com.liftbro.backend.service.DemosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemosController {

    @Autowired
    private DemosService demosService;

    @PostMapping("/demos")
    public ResponseEntity<String> createDemo(@RequestBody Demos demo) {
        String status = demosService.upsert(demo);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/demos/{id}")
    public ResponseEntity<Demos> getDemo(@PathVariable Integer id) {
        Demos demo = demosService.getById(id);
        return new ResponseEntity<>(demo, HttpStatus.OK);
    }

    @GetMapping("/demos")
    public ResponseEntity<List<Demos>> getAllDemos() {
        List<Demos> allDemos = demosService.getAllDemos();
        return new ResponseEntity<>(allDemos, HttpStatus.OK);
    }

    @PutMapping("/demos")
    public ResponseEntity<String> updateDemo(@RequestBody Demos demo) {
        String status = demosService.upsert(demo);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/demos/{id}")
    public ResponseEntity<String> deleteDemo(@PathVariable Integer id) {
        String status = demosService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
