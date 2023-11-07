package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.MembersRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Member;
import com.luv2code.springboot.thymeleafdemo.entity.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembersServiceImpl implements MembersService{

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Optional<Member> findByUserId(String username) {
        return membersRepository.findByUserId(username);
    }

    @Override
    public void save(MemberForm theMember) {
        try{
            String hasedPassword=passwordEncoder.encode(theMember.getPassword());
            System.out.println("saving to members");
            Member m=new Member();
            String username=theMember.getUserName();
            m.setUserId(username);
            m.setPw(hasedPassword);
            m.setActive(1);
            System.out.println(m.getActive());
            System.out.println(m.getPw());
            System.out.println(m.getUserId());
            membersRepository.save(m);
        }catch (Exception e){

        }
    }
}
