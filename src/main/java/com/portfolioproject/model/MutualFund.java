package com.portfolioproject.model;

public class MutualFund extends Asset {

    private double nav;
    private double exitLoad;

    public MutualFund(
            String assetId,
            String assetName,
            double purchasePrice,
            double nav,
            double exitLoad) {

        super(
                assetId,
                assetName,
                purchasePrice
        );

        this.nav = nav;
        this.exitLoad = exitLoad;
    }

    public double getNav() {

        return nav;
    }

    public void setNav(double nav) {

        this.nav = nav;
    }

    public double getExitLoad() {

        return exitLoad;
    }

    public void setExitLoad(double exitLoad) {

        this.exitLoad = exitLoad;
    }

    @Override
    public double calculateCurrentValue() {

        return nav * (1 - exitLoad / 100);
    }

    @Override
    public String toString() {

        return "MutualFund{" +
                "Asset ID='" + getAssetId() + '\'' +
                ", Asset Name='" + getAssetName() + '\'' +
                ", Purchase Price=" + getPurchasePrice() +
                ", NAV=" + nav +
                ", Exit Load=" + exitLoad + "%" +
                '}';
    }
}