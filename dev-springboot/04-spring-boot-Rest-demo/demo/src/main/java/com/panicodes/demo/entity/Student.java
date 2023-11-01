package com.panicodes.demo.entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class Student {
    private String firstName;
    private String lastName;

    public Student(){
        System.out.println("constructor: "+getClass().getSimpleName());
    }

    public Student(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
}
