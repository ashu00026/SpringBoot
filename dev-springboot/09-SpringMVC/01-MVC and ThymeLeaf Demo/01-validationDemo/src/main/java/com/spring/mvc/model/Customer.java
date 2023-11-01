package com.spring.mvc.model;

import com.spring.mvc.Validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    public Customer(){

    }
    private String firstName;
    @NotNull(message = "is Required")
    @Size(min=1,message = "is Required")
    private String lastName;

    @Min(value=0,message = "please select a value more than or equal to 0")
    @Max(value=10,message = "please select a value less than or equal to 10")
    @NotNull(message = "is Required")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message="only 5 chars/digits")
    private String postalCode;

    @CourseCode(value="TOPS",message = "must start with TOPS")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
