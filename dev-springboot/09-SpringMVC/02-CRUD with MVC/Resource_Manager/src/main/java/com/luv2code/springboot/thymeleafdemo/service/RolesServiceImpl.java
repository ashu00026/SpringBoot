package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.RolesRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Member;
import com.luv2code.springboot.thymeleafdemo.entity.MemberForm;
import com.luv2code.springboot.thymeleafdemo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RolesServiceImpl implements RolesService{

    @Autowired
    private RolesRepository rolesRepository;


    @Override
    public Optional<Role> findByUserId(String username) {
        return rolesRepository.findByUserId(username);
    }

    @Override
    public void saveManager(MemberForm theMember){
        Role role=new Role();
        role.setUserId(theMember.getUserName());
        role.setRole("ROLE_EMPLOYEE");
        rolesRepository.save(role);
        Role role2=new Role();
        role2.setId(0);
        role2.setUserId(theMember.getUserName());
        role2.setRole("ROLE_MANAGER");
        rolesRepository.save(role2);
    }
    @Override
    public void saveRole(MemberForm theMember) {
        Role role=new Role();
        role.setUserId(theMember.getUserName());
        role.setRole("ROLE_EMPLOYEE");
        rolesRepository.save(role);
    }
}
