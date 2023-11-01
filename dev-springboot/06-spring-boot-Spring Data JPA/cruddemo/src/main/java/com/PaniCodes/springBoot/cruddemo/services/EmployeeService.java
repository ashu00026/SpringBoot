package com.PaniCodes.springBoot.cruddemo.services;

import com.PaniCodes.springBoot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findEveryone();

    Employee findEmployeeById(int id);

    Employee updateEmployee(Employee theEmployee);

    void removeAnEmployee(int id);

}
