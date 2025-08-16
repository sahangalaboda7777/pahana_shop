package com.pahanabookshop.dao.impl;

import com.pahanabookshop.dao.BillDao;
import com.pahanabookshop.model.Bill;
import com.pahanabookshop.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao {

	@Override
	public boolean addBill(Bill bill) {
	    String sql = "INSERT INTO bills (account_no, bill_date, total_amount) VALUES (?, ?, ?)";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        ps.setString(1, bill.getAccountNo());
	        ps.setDate(2, new java.sql.Date(bill.getBillDate().getTime()));
	        ps.setDouble(3, bill.getTotalAmount());

	        int rows = ps.executeUpdate();
	        if (rows > 0) {
	            try (ResultSet rs = ps.getGeneratedKeys()) {
	                if (rs.next()) {
	                    int generatedId = rs.getInt(1);
	                    bill.setBillId(generatedId); // This will also set billNo
	                }
	            }
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}


	@Override
	public Bill getBillByNo(String billNo) {
	    // billNo = "BILL001" etc. -> need to parse the numeric ID
	    int id = Integer.parseInt(billNo.replace("BILL", ""));

	    String sql = "SELECT * FROM bills WHERE bill_no=?";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            Bill bill = new Bill(
	                    rs.getInt("bill_no"),               // auto id
	                    rs.getString("account_no"),
	                    rs.getDate("bill_date"),
	                    rs.getDouble("total_amount"),
	                    null
	            );
	            return bill;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}


	@Override
	public List<Bill> getAllBills() {
	    List<Bill> list = new ArrayList<>();
	    String sql = "SELECT * FROM bills";
	    try (Connection conn = DBUtil.getConnection();
	         Statement st = conn.createStatement();
	         ResultSet rs = st.executeQuery(sql)) {

	        while (rs.next()) {
	            Bill bill = new Bill(
	                    rs.getInt("bill_no"),
	                    rs.getString("account_no"),
	                    rs.getDate("bill_date"),
	                    rs.getDouble("total_amount"),
	                    null
	            );
	            list.add(bill);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}


    @Override
    public boolean deleteBill(String billNo) {
        String sql = "DELETE FROM bills WHERE bill_no=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, billNo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
