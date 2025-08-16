package com.pahanabookshop.model;

import java.util.Date;
import java.util.List;

public class Bill {
    private int billId;         // DB Auto Increment
    private String billNo;      // Display (BILL001 etc.)
    private String accountNo;
    private Date billDate;
    private double totalAmount;
    private List<BillItem> items;

    public Bill() {}

    public Bill(int billId, String accountNo, Date billDate, double totalAmount, List<BillItem> items) {
        this.billId = billId;
        this.billNo = String.format("BILL%03d", billId); // Generate display format
        this.accountNo = accountNo;
        this.billDate = billDate;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public int getBillId() { return billId; }
    public void setBillId(int billId) {
        this.billId = billId;
        this.billNo = String.format("BILL%03d", billId); // Always sync
    }

    public String getBillNo() { return billNo; }

    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    public Date getBillDate() { return billDate; }
    public void setBillDate(Date billDate) { this.billDate = billDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public List<BillItem> getItems() { return items; }
    public void setItems(List<BillItem> items) { this.items = items; }
}

