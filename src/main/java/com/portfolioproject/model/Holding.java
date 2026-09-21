package com.portfolioproject.model;

public class Holding {

    private String holdingId;
    private Asset asset;
    private double quantity;

    public Holding(
            String holdingId,
            Asset asset,
            double quantity) {

        this.holdingId = holdingId;
        this.asset = asset;
        this.quantity = quantity;
    }

    public String getHoldingId() {

        return holdingId;
    }

    public Asset getAsset() {

        return asset;
    }

    public double getQuantity() {

        return quantity;
    }

    public void setHoldingId(String holdingId) {

        this.holdingId = holdingId;
    }

    public void setAsset(Asset asset) {

        this.asset = asset;
    }

    public void setQuantity(double quantity) {

        this.quantity = quantity;
    }

    public double calculateValue() {

        return asset.calculateCurrentValue() * quantity;
    }

    public void display() {

        System.out.println("--------------------------------------");
        System.out.println("Holding ID     : " + holdingId);
        System.out.println("Asset ID       : " + asset.getAssetId());
        System.out.println("Asset Name     : " + asset.getAssetName());
        System.out.println("Quantity       : " + quantity);
        System.out.println(
                "Purchase Price : " +
                asset.getPurchasePrice()
        );

        System.out.printf(
                "Current Value  : %.2f%n",
                calculateValue()
        );

        System.out.println("--------------------------------------");
    }
}