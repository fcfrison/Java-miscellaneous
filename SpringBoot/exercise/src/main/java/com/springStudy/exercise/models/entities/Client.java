package com.springStudy.exercise.models.entities;

import com.springStudy.exercise.models.repository.ClientRepository;

public class Client {
    Integer id;
    String name;

    public Client(String name) {
        setId();
        setName(name);
    }
    public Client(){
        setId();
        setName(null);
    }
    public Integer getId() {
        return id;
    }
    private void setId() {
        this.id = ClientRepository.incrementId();
    }
    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = auxSetName(name);
    }
    private String auxSetName(String name){
        if(name==null) return  "client_" + getId();
        return name;
    }
    
}
