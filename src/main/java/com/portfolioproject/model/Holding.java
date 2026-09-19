package com.portfolioproject.model;

public class Holding {

    private Asset asset;
    private double quantity;

    public Holding(Asset asset, double quantity) {
        this.asset = asset;
        this.quantity = quantity;
    }

    public Asset getAsset() {
        return asset;
    }

    public double getQuantity() {
        return quantity;
    }

    public double calculateValue() {
        return asset.calculateValue();
    }

    @Override
    public String toString() {
        return "Asset: " + asset.getName()
                + ", Quantity: " + quantity
                + ", Value: " + calculateValue();
    }
}