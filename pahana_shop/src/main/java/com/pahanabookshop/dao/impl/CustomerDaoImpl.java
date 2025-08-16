package com.pahanabookshop.dao.impl;

import com.pahanabookshop.dao.CustomerDao;
import com.pahanabookshop.model.Customer;
import com.pahanabookshop.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public boolean addCustomer(Customer customer) {
	    String sql = "INSERT INTO customers (account_no, name, address, phone) VALUES (?, ?, ?, ?)";
	    try (Connection conn = DBUtil.getConnection()) {
	        // Generate account number
	        String accountNo = generateAccountNo(conn);
	        customer.setAccountNo(accountNo);

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, customer.getAccountNo());
	            ps.setString(2, customer.getName());
	            ps.setString(3, customer.getAddress());
	            ps.setString(4, customer.getPhone());
	            return ps.executeUpdate() > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

    @Override
    public Customer getCustomerByAccountNo(String accountNo) {
        String sql = "SELECT * FROM customers WHERE account_no=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, accountNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getString("account_no"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (Connection conn = DBUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Customer(rs.getString("account_no"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customers SET name=?, address=?, phone=? WHERE account_no=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getAccountNo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String accountNo) {
        String sql = "DELETE FROM customers WHERE account_no=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, accountNo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private String generateAccountNo(Connection conn) throws SQLException {
        String sql = "SELECT MAX(account_no) FROM customers";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next() && rs.getString(1) != null) {
                String lastId = rs.getString(1); // e.g., CUST005
                int num = Integer.parseInt(lastId.replace("CUST", ""));
                return String.format("CUST%03d", num + 1);
            } else {
                return "CUST001";
            }
        }
    }
}
