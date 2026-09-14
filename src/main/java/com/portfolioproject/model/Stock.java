package com.portfolioproject.model;

public class Stock {

    private String stockid;
    private String stockname;
    private double price;

    public Stock(String stockid, String stockname, double price) {
        this.stockid = stockid;
        this.stockname = stockname;
        this.price = price;
    }

    public String getStockid() {
        return stockid;
    }

    public void setStockid(String stockid) {
        this.stockid = stockid;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

