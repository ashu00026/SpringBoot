package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Resource;
//import com.luv2code.springboot.thymeleafdemo.entity.Members;
//import com.luv2code.springboot.thymeleafdemo.entity.Roles;

public interface ResourceService {

	List<Resource> findByUserId(String userName);

	List<Resource> findAll();
	
	Resource findById(int theId);
	
	void save(Resource theEmployee);
	
	void deleteById(int theId);
//
//	List<Roles> findByRole(String username);
//
//	List<Members> findByUserName(String userName);
	
}
