package com.pahanabookshop.model;

public class Item {
    private int itemId;
    private String name;
    private double price;
    private int stock;

    public Item() {}

    public Item(int itemId, String name, double price, int stock) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
