package com.company.Service;


import com.company.Model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findByEmail(String email);

    Customer save(Customer theCustomer);

}
