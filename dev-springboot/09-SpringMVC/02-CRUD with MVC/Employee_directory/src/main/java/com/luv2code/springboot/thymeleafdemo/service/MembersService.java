package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.entity.Member;
import com.luv2code.springboot.thymeleafdemo.entity.MemberForm;

import java.util.List;
import java.util.Optional;


public interface MembersService {

    Optional<Member> findByUserId(String username);

    void save(MemberForm theMember);

}
