package com.pahanabookshop.service;

import com.pahanabookshop.model.Bill;
import java.util.List;

public interface BillService {
    boolean addBill(Bill bill);
    Bill getBillByNo(String billNo);
    List<Bill> getAllBills();
    boolean deleteBill(String billNo);
}
