package com.portfolioproject.model;

public class Stock extends Asset {

    private double quantity;
    private double purchasePrice;
    private double currentPrice;

    public Stock(String name, double quantity, double purchasePrice, double currentPrice) {
        super(name);
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public double calculateValue() {
        return quantity * currentPrice;
    }

    @Override
    public String toString() {
        return "Stock Name: " + getName()
                + ", Quantity: " + quantity
                + ", Purchase Price: " + purchasePrice
                + ", Current Price: " + currentPrice
                + ", Current Value: " + calculateValue();
    }
}