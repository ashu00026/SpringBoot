package com.code.springboot.thymeleafDemo.Controller;

import com.code.springboot.thymeleafDemo.Model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> theCountries;

    @Value("${languages}")
    private List<String>theLanguages;

    @Value("${operatingSystems}")
    private List<String>theSystems;

    @GetMapping("/studentForm")
    public String studentForm(Model theModel){
        Student theStudent=new Student();
//        theModel.addAttribute("student",new Student());
//        theStudent.setFirstName("FirstName");
//        theStudent.setLastName("LastName");
        theModel.addAttribute("student",theStudent);
        theModel.addAttribute("countries",theCountries);
        theModel.addAttribute("languages",theLanguages);
        theModel.addAttribute("systems",theSystems);
        return "studentForm";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent ){
        System.out.println("the FirstName is "+ theStudent.getFirstName());
        System.out.println("the lastName is "+ theStudent.getLastName());
        System.out.println("From "+ theStudent.getCountry());
        System.out.println("From "+ theStudent.getLanguageChosen());
        return "studentConfirmed";

    }


}
