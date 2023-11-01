package com.code.springboot.thymeleafDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate",new java.util.Date());
        //as we have thymelead dependency in pom.xml file ,spring boot auto configures to check for the .html files under the location below.
        return "helloWorld";//thymeLeaf will look for src/main/resources/templates/helloworld.html
    }
}
