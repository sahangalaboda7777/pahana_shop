package com.pahanabookshop.model;

public class BillItem {
    private int billItemId;
    private String billNo;
    private int itemId;
    private int quantity;
    private double unitPrice;
    private double subTotal;

    public BillItem() {}

    public BillItem(int billItemId, String billNo, int itemId, int quantity, double unitPrice, double subTotal) {
        this.billItemId = billItemId;
        this.billNo = billNo;
        this.itemId = itemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
    }

    public int getBillItemId() { return billItemId; }
    public void setBillItemId(int billItemId) { this.billItemId = billItemId; }

    public String getBillNo() { return billNo; }
    public void setBillNo(String billNo) { this.billNo = billNo; }

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    public double getSubTotal() { return subTotal; }
    public void setSubTotal(double subTotal) { this.subTotal = subTotal; }
}
