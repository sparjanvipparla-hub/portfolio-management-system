package com.portfolioproject.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userId;
    private String name;
    private String email;

    private List<Holding> holdings;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.holdings = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addHolding(Holding holding) {
        holdings.add(holding);
    }

    public void displayInvestments() {

        if (holdings.isEmpty()) {
            System.out.println("No investments found.");
            return;
        }

        System.out.println("\n===== HOLDINGS =====");

        for (Holding holding : holdings) {
            System.out.println(holding);
        }
    }

    @Override
    public String toString() {
        return "User ID: " + userId
                + "\nName: " + name
                + "\nEmail: " + email;
    }
}