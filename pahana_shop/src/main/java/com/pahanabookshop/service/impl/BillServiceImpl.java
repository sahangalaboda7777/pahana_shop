package com.pahanabookshop.service.impl;

import com.pahanabookshop.dao.BillDao;
import com.pahanabookshop.dao.impl.BillDaoImpl;
import com.pahanabookshop.model.Bill;
import com.pahanabookshop.service.BillService;

import java.util.List;

public class BillServiceImpl implements BillService {

    private BillDao billDao = new BillDaoImpl();

    @Override
    public boolean addBill(Bill bill) {
        // Business logic for total calculation or validation can be added here
        return billDao.addBill(bill);
    }

    @Override
    public Bill getBillByNo(String billNo) {
        return billDao.getBillByNo(billNo);
    }

    @Override
    public List<Bill> getAllBills() {
        return billDao.getAllBills();
    }

    @Override
    public boolean deleteBill(String billNo) {
        return billDao.deleteBill(billNo);
    }
}
