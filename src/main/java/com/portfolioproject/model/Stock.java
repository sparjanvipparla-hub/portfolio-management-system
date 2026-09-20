package com.portfolioproject.model;

public class Stock extends Asset {

    private double currentPrice;

    public Stock(String assetId, String assetName,
                 double purchasePrice, double currentPrice) {

        super(assetId, assetName, purchasePrice);
        this.currentPrice = currentPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public double calculateCurrentValue() {
        return currentPrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "Asset ID='" + getAssetId() + '\'' +
                ", Asset Name='" + getAssetName() + '\'' +
                ", Purchase Price=" + getPurchasePrice() +
                ", Current Price=" + currentPrice +
                '}';
    }
}