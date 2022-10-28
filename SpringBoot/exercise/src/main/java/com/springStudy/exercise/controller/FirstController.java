package com.springStudy.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping(path={"/hello","/greetings"})
    public String greetings(){
        return "Greetings everyone!!!";
    }
}
