package com.panicodes.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("CONSTRUCOR: TennisCoach");
    }
    @Override
    public String getDailyWorkout() {
        return "do a Tennis practice for 1 hr";
    }
}
