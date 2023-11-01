package com.PaniCodes.springBoot.cruddemo.dao;

import com.PaniCodes.springBoot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for Entity MAnager
    private EntityManager entityManager;

    //setup constructor Injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
        //execute query and  get Results
        List<Employee>employees=theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
        Employee theEmployee=entityManager.find(Employee.class,id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee=entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee theEmployee=entityManager.find(Employee.class,id);
        entityManager.remove(theEmployee);
    }
}
