package com.portfolioproject.service;

import com.portfolioproject.model.Holding;
import com.portfolioproject.model.MutualFund;
import com.portfolioproject.model.Stock;
import com.portfolioproject.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PortfolioService {

    private Map<String, User> users;

    // Constructor

    public PortfolioService() {

        users = new HashMap<>();
    }

    // Add User

    public void addUser(User user) {

        if (user == null ||
                user.getUserid() == null ||
                user.getUserid().trim().isEmpty()) {

            return;
        }

        users.put(user.getUserid(), user);
    }

    // Check whether user exists

    public boolean userExists(String userid) {

        if (userid == null) {
            return false;
        }

        return users.containsKey(userid);
    }

    // Get User by ID

    public User getUser(String userid) {

        if (userid == null) {
            return null;
        }

        return users.get(userid);
    }

    // Get all users

    public Collection<User> getAllUsers() {

        return users.values();
    }

    // Load users from JSON

    public void loadUsers(
            Collection<User> loadedUsers) {

        if (loadedUsers == null) {
            return;
        }

        for (User user : loadedUsers) {

            addUser(user);
        }
    }

    // Add Stock Holding

    public boolean addStock(
            String userid,
            String holdingId,
            String stockId,
            String stockName,
            double purchasePrice,
            double currentPrice,
            int quantity) {

        User user = getUser(userid);

        if (user == null) {
            return false;
        }

        if (quantity <= 0 ||
                purchasePrice < 0 ||
                currentPrice < 0) {

            return false;
        }

        Stock stock = new Stock(
                stockId,
                stockName,
                purchasePrice,
                currentPrice
        );

        Holding holding = new Holding(
                holdingId,
                stock,
                quantity
        );

        user.addHolding(holding);

        return true;
    }

    // Add Mutual Fund Holding

    public boolean addMutualFund(
            String userid,
            String holdingId,
            String fundId,
            String fundName,
            double purchasePrice,
            double nav,
            int units) {

        User user = getUser(userid);

        if (user == null) {
            return false;
        }

        if (units <= 0 ||
                purchasePrice < 0 ||
                nav < 0) {

            return false;
        }

        MutualFund mutualFund =
                new MutualFund(
                        fundId,
                        fundName,
                        purchasePrice,
                        nav
                );

        Holding holding = new Holding(
                holdingId,
                mutualFund,
                units
        );

        user.addHolding(holding);

        return true;
    }

    // Calculate total portfolio value

    public double totalValue() {

        double total = 0;

        for (User user : users.values()) {

            for (Holding holding :
                    user.getHoldings()) {

                total += holding.getCurrentValue();
            }
        }

        return total;
    }

    // Calculate one user's portfolio value

    public double userTotalValue(String userid) {

        User user = getUser(userid);

        if (user == null) {
            return 0;
        }

        double total = 0;

        for (Holding holding :
                user.getHoldings()) {

            total += holding.getCurrentValue();
        }

        return total;
    }

    // Display all users

    public void displayUsers() {

        if (users.isEmpty()) {

            System.out.println(
                    "No users available."
            );

            return;
        }

        for (User user :
                users.values()) {

            user.display();
        }
    }

    // Display all holdings

    public void displayHoldings() {

        if (users.isEmpty()) {

            System.out.println(
                    "No users available."
            );

            return;
        }

        for (User user :
                users.values()) {

            user.displayHoldings();
        }
    }
}