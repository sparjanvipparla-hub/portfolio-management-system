package com.portfolioproject.model;

public class MutualFund extends Asset {

    private double units;
    private double nav;
    private double exitLoad;

    public MutualFund(String name, double units, double nav, double exitLoad) {
        super(name);
        this.units = units;
        this.nav = nav;
        this.exitLoad = exitLoad;
    }

    public double getUnits() {
        return units;
    }

    public double getNav() {
        return nav;
    }

    public double getExitLoad() {
        return exitLoad;
    }

    @Override
    public double calculateValue() {
        double totalValue = units * nav;
        double exitLoadAmount = totalValue * exitLoad / 100.0;

        return totalValue - exitLoadAmount;
    }

    @Override
    public String toString() {
        return "Mutual Fund Name: " + getName()
                + ", Units: " + units
                + ", NAV: " + nav
                + ", Exit Load: " + exitLoad + "%"
                + ", Current Value: " + calculateValue();
    }
}