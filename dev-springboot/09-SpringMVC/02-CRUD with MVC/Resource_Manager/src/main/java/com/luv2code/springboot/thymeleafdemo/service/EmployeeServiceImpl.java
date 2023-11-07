package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.ResourceRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Resource;

@Service
public class EmployeeServiceImpl implements ResourceService {

	private ResourceRepository theResourceRepository;
	
	@Autowired
	public EmployeeServiceImpl(ResourceRepository theEmployeeRepository
	) {
		this.theResourceRepository = theEmployeeRepository;
	}
	@Override
	public List<Resource> findByUserId(String subjectName){
		return theResourceRepository.findBySubject(subjectName);
	}
	
	@Override
	public List<Resource> findAll() {
		return theResourceRepository.findAllByOrderBySubjectAsc();
	}

	@Override
	public Resource findById(int theId) {
		Optional<Resource> result = theResourceRepository.findById(theId);
		
		Resource theResource = null;
		
		if (result.isPresent()) {
			theResource = result.get();
		}
		else {
			throw new RuntimeException("Did not find subject id - " + theId);
		}
		
		return theResource;
	}

	@Override
	public void save(Resource theResource) {
		theResourceRepository.save(theResource);
	}

	@Override
	public void deleteById(int theId) {
		theResourceRepository.deleteById(theId);
	}

}






