package com.springStudy.exercise.models.repository;



public class ClientRepository {
    public static Integer id=0;
    public static Integer incrementId(){
        return id++;
    }
}
