package com.springStudy.exercise.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/httpMethods")
public class GeneralMethodsController {
    @GetMapping
    public String get(){
        return "Test GET!!";
    }
    @PutMapping
    public String put(){
        return "Test PUT!!";
    }
    @DeleteMapping
    public String delete(){
        return "Test DELETE!!";
    }
    @PatchMapping
    public String patch(){
        return "Test PATCH!!";
    }
    @PostMapping
    public String post(){
        return "Test POST!!";
    }
    
}
