package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.entity.Member;
import com.luv2code.springboot.thymeleafdemo.entity.MemberForm;
import com.luv2code.springboot.thymeleafdemo.service.MembersService;
import com.luv2code.springboot.thymeleafdemo.service.RolesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MembersService theMemberService;

    @Autowired
    private RolesService theRoleService;

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("member") MemberForm theMember, BindingResult result,
                                Model theModel){
        if(result.hasErrors())return "Login/RegisterUser";
        if(!theMember.getPassword().equals(theMember.getConfirmPassword())){
            System.out.println("PasswordMismatch");
            theModel.addAttribute("passwordMisMatch","Passwords Do not Match!!");
            return "Login/RegisterUser";
        }
        String userName=theMember.getUserName();
        Optional<Member> duplicate=theMemberService.findByUserId(userName);
        if(duplicate.isPresent()){
            System.out.println("DuplicateUser");
            theModel.addAttribute("duplicateUser","Username already Exists!!");
            return "Login/RegisterUser";
        };
        theMemberService.save(theMember);
        theRoleService.saveRole(theMember);
        return "redirect:/showMyLoginPage";
    }


}
