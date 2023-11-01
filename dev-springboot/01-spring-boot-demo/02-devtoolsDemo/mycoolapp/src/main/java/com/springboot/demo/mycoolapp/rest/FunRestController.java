package com.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "hello World";
    }
    //expose a new endpoint for ""workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run a hard 5k";
    }
    @GetMapping("/fortune")
    public String getFortune(){
        return "you will have a great day today!!";
    }

}
