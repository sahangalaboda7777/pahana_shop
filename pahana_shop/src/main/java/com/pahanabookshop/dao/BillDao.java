package com.pahanabookshop.dao;

import com.pahanabookshop.model.Bill;
import java.util.List;

public interface BillDao {
    boolean addBill(Bill bill);
    Bill getBillByNo(String billNo);
    List<Bill> getAllBills();
    boolean deleteBill(String billNo);
}
