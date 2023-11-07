package com.luv2code.springboot.thymeleafdemo.entity;

import com.luv2code.springboot.thymeleafdemo.Validation.FieldMatch;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class MemberForm {

    public MemberForm(){

    }

    @Id
    @NotNull(message = "is Required")
    @Size(min = 5,max = 30)
    private String UserName;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "password must have 5 characters having 1 number and 1 specialCharacter!!")
    private String password;

    private int active;

    @NotNull
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
