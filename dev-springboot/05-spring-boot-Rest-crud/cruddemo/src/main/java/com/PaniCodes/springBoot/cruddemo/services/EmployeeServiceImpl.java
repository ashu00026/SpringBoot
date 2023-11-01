package com.PaniCodes.springBoot.cruddemo.services;

import com.PaniCodes.springBoot.cruddemo.dao.EmployeeDAO;
import com.PaniCodes.springBoot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        this.employeeDAO=theEmployeeDAO;
    }

    @Override
    public List<Employee> findEveryone() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void removeAnEmployee(int id) {
        employeeDAO.deleteById(id);

    }
}
