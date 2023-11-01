package com.PaniCodes.springBoot.cruddemo.dao;

import com.PaniCodes.springBoot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
