package com.pahanabookshop.model;

import java.util.Date;
import java.util.List;

public class Bill {
    private String billNo;
    private String accountNo;
    private Date billDate;
    private double totalAmount;
    private List<BillItem> items;

    public Bill() {}

    public Bill(String billNo, String accountNo, Date billDate, double totalAmount, List<BillItem> items) {
        this.billNo = billNo;
        this.accountNo = accountNo;
        this.billDate = billDate;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public String getBillNo() { return billNo; }
    public void setBillNo(String billNo) { this.billNo = billNo; }

    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    public Date getBillDate() { return billDate; }
    public void setBillDate(Date billDate) { this.billDate = billDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public List<BillItem> getItems() { return items; }
    public void setItems(List<BillItem> items) { this.items = items; }
}
