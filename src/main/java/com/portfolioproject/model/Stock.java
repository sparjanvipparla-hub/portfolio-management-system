package com.portfolioproject.model;

public class Stock {

    private String stockid;
    private String stockname;
    private double price;

    // Constructor
    public Stock(String stockid, String stockname, double price) {
        this.stockid = stockid;
        this.stockname = stockname;
        this.price = price;
    }

    // Getter and Setter for Stock ID
    public String getStockid() {
        return stockid;
    }

    public void setStockid(String stockid) {
        this.stockid = stockid;
    }

    // Getter and Setter for Stock Name
    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    // Getter and Setter for Price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
