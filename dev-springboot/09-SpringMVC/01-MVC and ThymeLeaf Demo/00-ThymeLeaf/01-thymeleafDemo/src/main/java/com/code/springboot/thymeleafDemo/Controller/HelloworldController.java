package com.code.springboot.thymeleafDemo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloworldController {

    @RequestMapping("/showform")
    public String showForm(){
        return "hello-world-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworldPage";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, @RequestParam("studentName")String theName, Model theModel){
//        String theName = request.getParameter("studentName");
        theName=theName.toUpperCase();
        String result="Yo! "+theName;

        theModel.addAttribute("message",result);
        return "helloworldPage";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormThree(@RequestParam("studentName")String theName, Model theModel){
//        String theName = request.getParameter("studentName");
        theName=theName.toUpperCase();

        String result="Yo! HEY from V3 "+theName;

        theModel.addAttribute("message",result);
        return "helloworldPage";
    }
}
