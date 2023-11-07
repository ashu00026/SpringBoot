package com.company.Service;

import com.company.Model.Customer;
import com.company.Respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository theCustomerRepository){
        this.customerRepository=theCustomerRepository;
    }

    @Override
    public List<Customer> findByEmail(String email){
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer save(com.company.Model.Customer theCustomer) {
        return customerRepository.save(theCustomer);
    }


}
