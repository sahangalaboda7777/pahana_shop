package com.pahanabookshop.model;

public class Customer {
    private String accountNo;
    private String name;
    private String address;
    private String phone;

    public Customer() {}

    public Customer(String accountNo, String name, String address, String phone) {
        this.accountNo = accountNo;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
