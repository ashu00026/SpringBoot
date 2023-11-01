package com.panicodes.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    public TrackCoach(){
        System.out.println("CONSTRUCTOR "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "do 5 rounds around the ground!!";
    }


}
