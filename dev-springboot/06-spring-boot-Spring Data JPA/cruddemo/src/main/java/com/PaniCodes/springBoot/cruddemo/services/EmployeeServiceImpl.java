package com.PaniCodes.springBoot.cruddemo.services;

//import com.PaniCodes.springBoot.cruddemo.dao.EmployeeDAO;
import com.PaniCodes.springBoot.cruddemo.dao.EmployeeRepository;
import com.PaniCodes.springBoot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

//    private EmployeeDAO employeeDAO;

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        this.employeeRepository=theEmployeeRepository;
    }

    @Override
    public List<Employee> findEveryone() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
//        return employeeRepository.getEmployee(id);
        Optional<Employee> result=employeeRepository.findById(id);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }else{
            throw new RuntimeException("no Employee found of id -"+id);
        }
        return theEmployee;
    }

//    @Transactional
    @Override
    public Employee updateEmployee(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Transactional
    @Override
    public void removeAnEmployee(int id) {
        employeeRepository.deleteById(id);

    }
}
