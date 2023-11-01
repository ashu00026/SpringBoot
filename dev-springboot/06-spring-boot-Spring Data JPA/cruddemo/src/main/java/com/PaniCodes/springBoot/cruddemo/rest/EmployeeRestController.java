package com.PaniCodes.springBoot.cruddemo.rest;

//import com.PaniCodes.springBoot.cruddemo.dao.EmployeeDAO;
import com.PaniCodes.springBoot.cruddemo.entity.Employee;
import com.PaniCodes.springBoot.cruddemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    //quick and dirty--:inject employee Dao directly for now
    //later we will refactor and add service layer
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        this.employeeService=theEmployeeService;
    }
    //expose the "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findEveryone();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findEmployeeById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee id Not Found -"+employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee=employeeService.updateEmployee(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.updateEmployee(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee= employeeService.findEmployeeById(employeeId);
        if(theEmployee==null)throw new RuntimeException("employee to delete not Found!!!");
        employeeService.removeAnEmployee(employeeId);
        return "Deleted employee id -"+employeeId;
    }
}
