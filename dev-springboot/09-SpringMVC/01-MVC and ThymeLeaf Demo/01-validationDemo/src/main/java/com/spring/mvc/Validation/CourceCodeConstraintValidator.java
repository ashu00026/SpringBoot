package com.spring.mvc.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourceCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePreFix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePreFix=courseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        if(theCode!=null)return theCode.startsWith(coursePreFix);
        return false;
    }
}
