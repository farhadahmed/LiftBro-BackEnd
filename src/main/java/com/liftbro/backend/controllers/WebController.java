package com.liftbro.backend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @GetMapping("/")
    public String getHomePage() {
        return "<h1> Lift Bro home page placeholder </h1>";
    }

    @GetMapping("/test")
    public String getTestPage() {
        return "<h1> Test1 </h1>";
    }
}
