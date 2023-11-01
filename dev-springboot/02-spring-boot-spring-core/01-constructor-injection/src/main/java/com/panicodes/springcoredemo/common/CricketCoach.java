package com.panicodes.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Lazy
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("CONSTRUCTOR: CricketCoach");
    }
    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 minutes!";
    }

    @PreDestroy
    public void doCleanupStuff(){
        System.out.println("do my clean-up stuff for "+getClass().getSimpleName());;
    }

    @PostConstruct
    public void doStartupStuff(){
        System.out.println("do my Start-up stuff for "+getClass().getSimpleName());;
    }
}
