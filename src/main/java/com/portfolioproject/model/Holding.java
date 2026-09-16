package com.portfolioproject.model;

public class Holding {

    private String holdingId;
    private String assetName;
    private double quantity;
    private double purchasePrice;

    // Constructor
    public Holding(String holdingId, String assetName, double quantity, double purchasePrice) {
        this.holdingId = holdingId;
        this.assetName = assetName;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
    }

    // Getters
    public String getHoldingId() {
        return holdingId;
    }

    public String getAssetName() {
        return assetName;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    // Setters
    public void setHoldingId(String holdingId) {
        this.holdingId = holdingId;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    // Display Holding
    public void display() {

        System.out.println("Holding ID: " + holdingId);
        System.out.println("Asset Name: " + assetName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Purchase Price: " + purchasePrice);
    }
}