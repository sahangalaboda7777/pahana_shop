package com.pahanabookshop.dao;

import com.pahanabookshop.model.Customer;
import java.util.List;

public interface CustomerDao {
    boolean addCustomer(Customer customer);
    Customer getCustomerByAccountNo(String accountNo);
    List<Customer> getAllCustomers();
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String accountNo);
}
