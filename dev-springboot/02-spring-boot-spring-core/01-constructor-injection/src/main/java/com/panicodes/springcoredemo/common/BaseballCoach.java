package com.panicodes.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//scope of bean turned to prototype
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("CONSTRUCTOR: BaseballCoach");
    }
    @Override
    public String getDailyWorkout(){
        return "Do A baseball practice for 2 hr";
    }
}
