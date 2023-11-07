package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Member;
import com.luv2code.springboot.thymeleafdemo.entity.MemberForm;
import com.luv2code.springboot.thymeleafdemo.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RolesService {
    Optional<Role> findByUserId(String username);

    void saveRole(MemberForm theMember);
}
