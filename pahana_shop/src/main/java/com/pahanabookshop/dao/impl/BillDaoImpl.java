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
        String sql = "INSERT INTO bills (bill_no, account_no, bill_date, total_amount) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bill.getBillNo());
            ps.setString(2, bill.getAccountNo());
            ps.setDate(3, new java.sql.Date(bill.getBillDate().getTime()));
            ps.setDouble(4, bill.getTotalAmount());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Bill getBillByNo(String billNo) {
        String sql = "SELECT * FROM bills WHERE bill_no=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, billNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Bill(rs.getString("bill_no"),
                        rs.getString("account_no"),
                        rs.getDate("bill_date"),
                        rs.getDouble("total_amount"),
                        null); // Bill items can be loaded separately if needed
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
                list.add(new Bill(rs.getString("bill_no"),
                        rs.getString("account_no"),
                        rs.getDate("bill_date"),
                        rs.getDouble("total_amount"),
                        null));
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
