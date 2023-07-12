package com.liftbro.backend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @GetMapping("/")
    public String getHomepage() {
        return "<h1> Lift Bro home page placeholder </h1>";

    }
}
