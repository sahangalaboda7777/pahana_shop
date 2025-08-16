package com.pahanabookshop.controller;

import com.pahanabookshop.model.Customer;
import com.pahanabookshop.service.CustomerService;
import com.pahanabookshop.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            List<Customer> customers = customerService.getAllCustomers();
            request.setAttribute("customers", customers);
            request.getRequestDispatcher("customers.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            String accountNo = request.getParameter("accountNo");
            Customer customer = customerService.getCustomerByAccountNo(accountNo);
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("customer_form.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            String accountNo = request.getParameter("accountNo");
            customerService.deleteCustomer(accountNo);
            response.sendRedirect("customer?action=list");
        } else if ("add".equals(action)) {
            request.getRequestDispatcher("customer_form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("accountNo");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        Customer customer = new Customer(accountNo, name, address, phone);

        if (customerService.getCustomerByAccountNo(accountNo) != null) {
            customerService.updateCustomer(customer);
        } else {
            customerService.addCustomer(customer);
        }

        response.sendRedirect("customer?action=list");
    }
}
