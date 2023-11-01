package com.panicodes.springcoredemo.rest;

import com.panicodes.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
//    private Coach anoterCoach;

    @Autowired
//    public DemoController(@Qualifier("mySwimCoach") Coach theCoach){
    public DemoController(@Qualifier("aquatic") Coach theCoach){
//                          @Qualifier("baseballCoach") Coach theAnotherCoach){
        System.out.println("CONSTRUCTOR: DemoController!!");
        myCoach=theCoach;
//        anoterCoach=theAnotherCoach;
    }

//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach=theCoach;
//    }
//    @GetMapping("/check")
//    public String check(){
//        return "comparing Beans: myCoach == anotherCoach, "+(myCoach==anoterCoach);
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


}
