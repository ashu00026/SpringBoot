package com.panicodes.demo.controllerAdvice;

import com.panicodes.demo.exceptions.StudentErrorResponse;
import com.panicodes.demo.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        //ResponseEntity is a wrapper class for http Response object which provides fine-grip on the response object.
        //last line of this method which is returned tells that this is a notFound error so set the status of request as NOTFOUND.
        StudentErrorResponse error=new StudentErrorResponse();

        //but HERE we are only setting the value of notFound in the request body so that the response is seen as 404..
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllExceptions(Exception exc){
        //this Exception handler is for all other exceptions which are not handled by any other Exception handlers..
        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        //update the message and send any friendly message u want to the user..
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
