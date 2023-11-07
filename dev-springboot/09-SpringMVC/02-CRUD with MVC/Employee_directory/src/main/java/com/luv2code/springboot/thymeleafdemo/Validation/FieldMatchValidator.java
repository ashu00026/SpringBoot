package com.luv2code.springboot.thymeleafdemo.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
//import org.springframework.beans.BeanUtils;
//import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;


    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = true;
        try
        {
            valid =  firstFieldName == null && secondFieldName == null || firstFieldName != null && firstFieldName.equals(secondFieldName);
        }
        catch (final Exception ignore)
        {
            // ignore
        }

        return valid;
    }
}
