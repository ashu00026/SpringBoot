package com.code.springboot.thymeleafDemo.Model;

import java.util.List;

public class Student {
    public Student(){

    }
    private String firstName;
    private String lastName;

    private String country;

    private List<String> systemChoosen;

    public List<String> getSystemChoosen() {
        return systemChoosen;
    }

    public void setSystemChoosen(List<String> systemChoosen) {
        this.systemChoosen = systemChoosen;
    }

    public String getLanguageChosen() {
        return LanguageChosen;
    }

    public void setLanguageChosen(String languageChosen) {
        LanguageChosen = languageChosen;
    }

    private String LanguageChosen;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
