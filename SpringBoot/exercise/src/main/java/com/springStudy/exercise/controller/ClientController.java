package com.springStudy.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springStudy.exercise.models.entities.Client;
@RestController
@RequestMapping(path="/customer")
public class ClientController {
    @GetMapping(path="/")
    public Client getClient(){
        return new Client();
    }
    @GetMapping(path="{name}")
    public Client getClientId(@PathVariable String name){//Here, we have one way to pass parameters;
        return new Client(name);
    }
    @GetMapping
    public Client anotherWayToGetClient(
        @RequestParam(name="name",defaultValue ="client_") String name){//here, we have another way to pass parameters via url;
            return new Client(name);
        }
}
