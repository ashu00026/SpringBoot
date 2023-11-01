package com.panicodes.demo.rest;

import com.panicodes.demo.entity.Student;
import com.panicodes.demo.exceptions.StudentErrorResponse;
import com.panicodes.demo.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    //load the student only once and then store them so that we can use them multiple times
    private List<Student> theStudents;

    @PostConstruct
    public void loadStudents(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("ashutosh","panigrahi"));
        theStudents.add(new Student("arun","sahu"));
        theStudents.add(new Student("kamal","prasad"));
    }

    //define an endpoint for "/students--return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getSingleStudent(@PathVariable int studentId){
        //put the path variable annotation in order to retrieve the path parameter form the api end-point
        //also put the variable in its suitable data type
        //byDefault the pathVariable should match the name of your variable
        //return the student by doing a get on the list of students with the index in the pathVariable

        //exception Handling
        if((studentId>=theStudents.size())||(studentId<0)){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
            //StudentNotFound is an exception which calls the super(RuntimeExceptions constructor) class with the given message
            //FOR any exception to raise we have to call the class which extends the runtimeException and then pass the message to it
//            ..through the super keyWord
            //now the exception handler does the rest part//
            //student Error Response class is only for setting the object to respond with custom wanted structure
        }
        return theStudents.get(studentId);
    }
    //move the ExceptionHandlers to the ControllerAdvice for Making them global ExceptionHandlers

}
