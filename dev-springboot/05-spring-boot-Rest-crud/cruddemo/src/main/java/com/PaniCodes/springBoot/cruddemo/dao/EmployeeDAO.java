package com.PaniCodes.springBoot.cruddemo.dao;

import com.PaniCodes.springBoot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee getEmployee(int id);

    Employee save(Employee theEmployee);

    void deleteById(int id);


}
