package com.portfolioproject.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userid;
    private String name;
    private String email;

    private List<Holding> holdings;

    public User(String userid, String name, String email) {

        this.userid = userid;
        this.name = name;
        this.email = email;

        this.holdings = new ArrayList<>();
    }

    public void addHolding(Holding holding) {

        if (holding != null) {
            holdings.add(holding);
        }
    }

    public void display() {

        System.out.println();
        System.out.println("========== USER DETAILS ==========");
        System.out.println("User ID            : " + userid);
        System.out.println("Name               : " + name);
        System.out.println("Email              : " + email);
        System.out.println("Number of Holdings : " + holdings.size());
        System.out.println("==================================");
    }

    public void displayHoldings() {

        if (holdings.isEmpty()) {

            System.out.println("No holdings available.");

            return;
        }

        for (Holding holding : holdings) {

            holding.display();
        }
    }

    public String getUserid() {

        return userid;
    }

    public void setUserid(String userid) {

        this.userid = userid;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public List<Holding> getHoldings() {

        return holdings;
    }

    public void setHoldings(List<Holding> holdings) {

        this.holdings = holdings;
    }
}