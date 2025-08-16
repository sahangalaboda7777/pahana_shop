package com.pahanabookshop.service.impl;

import com.pahanabookshop.dao.CustomerDao;
import com.pahanabookshop.dao.impl.CustomerDaoImpl;
import com.pahanabookshop.model.Customer;
import com.pahanabookshop.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public boolean addCustomer(Customer customer) {
        // Additional validation can be added here
        return customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerByAccountNo(String accountNo) {
        return customerDao.getCustomerByAccountNo(accountNo);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(String accountNo) {
        return customerDao.deleteCustomer(accountNo);
    }
}
