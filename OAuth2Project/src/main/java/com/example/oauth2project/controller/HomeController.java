package com.example.oauth2project.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "Home!";
    }

    @GetMapping("/secured")
    public String secured(){
        return "you have to be logged in to access this page!";
    }
}
