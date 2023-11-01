package com.panicodes.springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("CONSTRUCTOR: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "swim for 3 hrs!!!";
    }
}
