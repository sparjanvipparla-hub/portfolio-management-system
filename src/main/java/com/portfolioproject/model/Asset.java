package com.portfolioproject.model;

public abstract class Asset {

    private String name;

    public Asset(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateValue();
}